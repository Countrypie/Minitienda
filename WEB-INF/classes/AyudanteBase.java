import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

import baseDatos.ConexionBD;
import carrito.CarritoBean;

//Clase auxiliar para manejar el acceso a la base
public class AyudanteBase {

    //Metodo para crear un usuario. Devuelve 0 si hubo exito, 1 si fracaso
    public int crearUsuario(HttpServletRequest request){

        int retorno=-1;
        String correo=request.getParameter("correo"),
               contrasena=request.getParameter("contrasena"), 
               tipo=request.getParameter("tipo"), 
               numero=request.getParameter("numero");

        try{
            ConexionBD conexion = new ConexionBD();
            retorno=conexion.getDAOUsuarios().nuevoUsuario(correo, contrasena, tipo, numero);
            conexion.getConecion().close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return retorno;
    }

    //Metodo para comprobar si las credenciales son correctas.
    public Boolean validar(String correo, String contrasena){

        Boolean retorno=false;

        try{
            ConexionBD conexion = new ConexionBD();
            retorno=conexion.getDAOUsuarios().validar(correo, contrasena);
            conexion.getConecion().close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return retorno;
    }

    //Metodo para crear un nuevo pedido
    public void crearPedido(HttpServletRequest request, CarritoBean carrito){

        AyudanteCarrito ayuda=new AyudanteCarrito();

        carrito.setPropietario(request.getParameter("correo"));
        
        int id=-1;
        try{
            ConexionBD conexion = new ConexionBD();
            id=conexion.getDAOPedidos().insertarPedido(carrito.getPropietario(), carrito.getImporte());
            conexion.getConecion().close();
        }catch(Exception e){
            e.printStackTrace();
        }

        carrito.setPedido(id);
    }
}
