package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Objeto para hacer transacciones sobre la tabla de usuarios
public class DAOUsuarios {
    private Connection conexion;

    //Constructor
    public DAOUsuarios(Connection conexion) {
        this.conexion = conexion;
    }

    //Metodo para anadir un nuevo usuario. Devuelve 0 si exito
    public int nuevoUsuario(String correo, String nombre, String tipoTarjeta, String numeroTarjeta) {
        
        //Se prepara la transacción y se ejecuta
        String sql = "INSERT INTO usuarios (correo, nombre, tipo_tarjeta, numero_tarjeta) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setString(2, nombre);
            stmt.setString(3, tipoTarjeta);
            stmt.setString(4, numeroTarjeta);
            stmt.executeUpdate();

        //En caso de error devuelve 1
        }catch(SQLException e){
            e.printStackTrace();
            return 1;
        }
        //En caso de exito devuelve 0
        return 0;
    }


    //Metodo para comprobar si las credenciales estan bien
    public Boolean validar(String correo, String contrasena, String tipoTarjeta, String numeroTarjeta){

        //Se prepara la transacción
        String sql = "SELECT * FROM usuarios WHERE correo = ?;";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, correo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    //Se obtiene la contraseña y se comprueba si coincide con lo introducido
                    String contrasena_base=rs.getString("contrasena");
                    String tipoTarjeta_base=rs.getString("tipo_tarjeta");
                    String numeroTarjeta_base=rs.getString("numero_tarjeta");
                    
                    return contrasena_base.equals(contrasena) && tipoTarjeta_base.equals(tipoTarjeta) && numeroTarjeta_base.equals(numeroTarjeta);
                } else {
                    return false;
                }
            }
        //En caso de error 
        } catch (SQLException e) {
            return false;
        }
    }
}

