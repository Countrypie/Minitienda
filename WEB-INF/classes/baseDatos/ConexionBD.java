package baseDatos;

//Clase para acceder a la base de datos
public class ConexionBD {

    //Objeto conexion para conectarse y objetos DAO para gestionar el acceso
    private java.sql.Connection conexion;
    private DAOUsuarios daoUsuarios;
    private DAOPedidos daoPedidos;

    //Constructor
    public ConexionBD (){

        try {

            //Se obtiene la conexion
            Class.forName("org.postgresql.Driver").newInstance();

            String url = "jdbc:postgresql://localhost:5432/Minitienda";
            this.conexion=java.sql.DriverManager.getConnection(url, "acceso", "acceso");

            //Se crean los DAO
            this.daoUsuarios = new DAOUsuarios(conexion);
            this.daoPedidos = new DAOPedidos(conexion);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Getters
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
