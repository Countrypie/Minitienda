package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.math.BigDecimal;

public class DAOPedidos {
    private Connection conexion;

    public DAOPedidos(Connection conexion) {
        this.conexion = conexion;
    }

    //Metodo para anadir un pedido nuevo. Devuelve 0 si exito
    public int insertarPedido(String correo, BigDecimal importeTotal) {
        String sql = "INSERT INTO pedidos (correo, importe_total) VALUES (?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setBigDecimal(2, importeTotal);
            stmt.executeUpdate();
        }catch(SQLException e){
            return 1;
        }
        
        return 0;
    }
}
