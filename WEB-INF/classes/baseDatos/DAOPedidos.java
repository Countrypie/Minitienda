package baseDatos;

import java.sql.*;

//Objeto para ejecutar transacciones sobre la tabla de pedidos
public class DAOPedidos {
    private Connection conexion;

    //Constructor
    public DAOPedidos(Connection conexion) {
        this.conexion = conexion;
    }

    //Metodo para anadir un pedido nuevo. Devuelve el id del pedido, o -1 si hubo algun error
    public int insertarPedido(String correo, Float importeTotal) {
        
        //Se prepara la transaccion
        String sql = "INSERT INTO pedidos (correo, importe_total) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, correo);
            stmt.setFloat(2, importeTotal);
            stmt.executeUpdate();
    
            //Se obtiene el id generado
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }
        
        //En caso de error devuelve -1
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
