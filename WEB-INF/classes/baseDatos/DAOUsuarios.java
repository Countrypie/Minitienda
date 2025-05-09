package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUsuarios {
    private Connection conexion;

    public DAOUsuarios(Connection conexion) {
        this.conexion = conexion;
    }

    //Metodo para anadir un nuevo usuario. Devuelve 0 si exito
    public int nuevoUsuario(String correo, String contrasena, String tipoTarjeta, String numeroTarjeta) {
        String sql = "INSERT INTO usuarios (correo, contrasena, tipo_tarjeta, numero_tarjeta) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);
            stmt.setString(3, tipoTarjeta);
            stmt.setString(4, numeroTarjeta);
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            return 1;
        }

        return 0;
    }

    //Metodo para comprobar si las credenciales estan bien
    public Boolean validar(String correo, String contrasena){
        System.out.println("dentro");
        String sql = "SELECT * FROM usuarios WHERE correo = ?;";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, correo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String contrasena_base=rs.getString("contrasena");
                    System.out.printf("%s,%s\n",contrasena_base,contrasena);
                    return contrasena_base.equals(contrasena);
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            return false;
        }
    }
}

