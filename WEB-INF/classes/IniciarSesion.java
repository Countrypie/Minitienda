import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

//Servlet que controla los formularios de iniciar sesion y crear un nuevo usuario
public class IniciarSesion extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtienen los ayudantes y el carrito
        AyudanteBase ayudaB=new AyudanteBase();
        AyudanteCarrito ayudaC=new AyudanteCarrito();
        CarritoBean carrito=ayudaC.obtenerCarrito(request);

        //Se detecta la accion pedida
        String accion=request.getServletPath();
        switch(accion){

            //Accion para validar el inicio de sesion
            case "/iniciar":
                //Se comprueba si las credenciales son correctas
                Boolean validado=ayudaB.validar(request.getParameter("correo"),
                    request.getParameter("contrasena"));

                //Si son correctas, se confirmo y va a la caja
                if(validado){
                    carrito.setPropietario(request.getParameter("correo"));
                    Dispatcher.dispatch(request,response, "caja.jsp");

                //Si son incorrectas aparece un mensaje de error
                }else{
                    escribirError(request, "Nombre o contraseña incorrectos.");
                    Dispatcher.dispatch(request,response, "iniciarSesion.jsp");
                }
                break;

            //Accion para abrir la pestana donde se crea un nuevo usuario
            case "/crear":
                Dispatcher.dispatch(request,response, "crearUsuario.jsp");
                break;

            //Accion para crear un usuario e ir a caja
            case "/crearYPagar":
                //Se crea el usuario y se ve si tuvo exito
                int estado=ayudaB.crearUsuario(request);

                //Si se creo correctamente, va a la caja. Si no, aparece un error 
                if(estado==0){
                    carrito.setPropietario(request.getParameter("correo"));
                    Dispatcher.dispatch(request,response, "caja.jsp");
                }else{
                    escribirError(request, "No se ha podido crear al usuario.");
                    Dispatcher.dispatch(request,response, "crearUsuario.jsp");
                }
                break;
    

            default:
                System.out.println("Error al reconocer al formulario");
                break;
        }
    }

    private void escribirError(HttpServletRequest peticion,String error){
        HttpSession sesion=peticion.getSession();
        sesion.setAttribute("mensajeError",error);
    }
}