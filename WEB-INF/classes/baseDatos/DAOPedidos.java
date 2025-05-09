package baseDatos;

import java.sql.*;

public class DAOPedidos {
    private Connection conexion;

    public DAOPedidos(Connection conexion) {
        this.conexion = conexion;
    }

    //Metodo para anadir un pedido nuevo. Devuelve el id del pedido
    public int insertarPedido(String correo, Float importeTotal) {
        String sql = "INSERT INTO pedidos (correo, importe_total) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, correo);
            stmt.setFloat(2, importeTotal);
            stmt.executeUpdate();
    
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
