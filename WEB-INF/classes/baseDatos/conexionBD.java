package baseDatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class conexionBD {
    private java.sql.Connection conexion;
    private DAOUsuarios daoUsuarios;
    private DAOPedidos daoPedidos;

    public conexionBD (){

        try {

            String url = "jdbc:postgresql://localhost:5432/Minitienda";
            this.conexion=java.sql.DriverManager.getConnection(url, usuario, contrasena);

            daoUsuarios = new DAOUsuarios(conexion);
            daoPedidos = new DAOPedidos(conexion);

        } catch (IOException i){
            System.out.println(i.getMessage());
        } 
        catch (java.sql.SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public java.sql.Connection getConecion(){
        return this.conexion;
    }
}
