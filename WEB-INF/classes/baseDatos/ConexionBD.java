package baseDatos;


public class ConexionBD {
    private java.sql.Connection conexion;
    private DAOUsuarios daoUsuarios;
    private DAOPedidos daoPedidos;

    public ConexionBD (){

        try {

            Class.forName("org.postgresql.Driver").newInstance();

            String url = "jdbc:postgresql://localhost:5432/Minitienda";
            this.conexion=java.sql.DriverManager.getConnection(url, "acceso", "acceso");

            this.daoUsuarios = new DAOUsuarios(conexion);
            this.daoPedidos = new DAOPedidos(conexion);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public java.sql.Connection getConecion(){
        return this.conexion;
    }

    public DAOUsuarios getDAOUsuarios(){
        return this.daoUsuarios;
    }

    public DAOPedidos getDAOPedidos(){
        return this.daoPedidos;
    }
}
