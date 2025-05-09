import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

import baseDatos.ConexionBD;
import carrito.CarritoBean;

//Clase auxiliar para manejar el acceso a la base
public class AyudanteBase {

    //Metodo para crear un usuario. Devuelve 0 si hubo exito, 1 si fracaso
    public static int crearUsuario(String correo, String contrasena, String tipo, String numero){

        int retorno=-1;

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
    public static Boolean validar(String correo, String contrasena){

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
}
