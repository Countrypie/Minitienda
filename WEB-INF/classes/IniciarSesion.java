import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

public class IniciarSesion extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtiene el ayudante
        AyudanteBase ayuda=new AyudanteBase();

        //Se ejecuta una de las tres acciones posibles
        String accion=request.getServletPath();
        RequestDispatcher rd;
        switch(accion){

            //Accion para iniciar sesion e ir a la ultima pestana
            case "/iniciar":
                Boolean validado=ayuda.validar(request.getParameter("correo"),
                    request.getParameter("contrasena"));

                //Si inicio sesion, va al fin. Si no, imprime error
                if(validado){
                    ayuda.crearPedido(request, new AyudanteCarrito().obtenerCarrito(request));
                    Dispatcher.dispatch(request,response, "fin.jsp");
                }else{
                    escribirError(request, "Nombre o contraseña incorrectos.");
                    Dispatcher.dispatch(request,response, "iniciarSesion.jsp");
                }
                break;

            //Accion para ir a crear un nuevo usuario
            case "/crear":
                Dispatcher.dispatch(request,response, "crearUsuario.jsp");
                break;

            //Accion para pagar con un usuario recien creado, y va a la ultima pestaña
            case "/crearYPagar":
                int estado=ayuda.crearUsuario(request);

                //Si se creo correctamente, va al fin. Si no, imprime error 
                if(estado==0){
                    ayuda.crearPedido(request, new AyudanteCarrito().obtenerCarrito(request));
                    Dispatcher.dispatch(request,response, "fin.jsp");
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