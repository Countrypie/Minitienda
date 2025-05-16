import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

import baseDatos.ConexionBD;
import carrito.CarritoBean;

//Clase auxiliar para manejar el acceso a la base
public class AyudanteBase {

    HttpServletRequest request=null;

    //Constructor
    public AyudanteBase(HttpServletRequest request){
        this.request=request;
    }

    //Metodo para crear un usuario. Devuelve 0 si hubo exito, +-1 si fracaso
    public int crearUsuario(){

        //Se obtienen los valores del request
        int retorno=-1;
        String correo=request.getParameter("correo"),
               nombre=request.getParameter("nombre"), 
               tipo=request.getParameter("tipo"), 
               numero=request.getParameter("numero");

        //Se llama al DAO de Usuarios para crear un nuevo usuario
        try{
            ConexionBD conexion = new ConexionBD();
            retorno=conexion.getDAOUsuarios().nuevoUsuario(correo, nombre, tipo, numero);
            conexion.getConexion().close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return retorno;
    }

    //Metodo para comprobar si las credenciales son correctas.
    public Boolean validar(String correo, String contrasena, String tipo, String numero){

        Boolean retorno=false;
        //Se llama al DAO de usuarios para que valide
        try{
            ConexionBD conexion = new ConexionBD();
            retorno=conexion.getDAOUsuarios().validar(correo, contrasena, tipo, numero);
            conexion.getConexion().close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return retorno;
    }

    //Metodo para crear un nuevo pedido. Devuelve el id del pedido si hubo exito, si no -1
    public void crearPedido(CarritoBean carrito){
        
        int id=-1;
        //Se llama al DAO de pedidos para que cree al pedido
        try{
            ConexionBD conexion = new ConexionBD();
            id=conexion.getDAOPedidos().insertarPedido(carrito.getPropietario(), carrito.getImporte());
            conexion.getConexion().close();
        }catch(Exception e){
            e.printStackTrace();
        }

        carrito.setPedido(id);
    }
}
