import java.io.*;

import baseDatos.ConexionBD;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

public class Visualizar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtiene el carrito
        CarritoBean carrito=AyudanteCarrito.obtenerCarrito(request);

        //Se ejecuta una de las tres acciones posibles
        String accion=request.getServletPath();
        RequestDispatcher rd;
        switch(accion){

            //Accion para volver a la pagina inicial
            case "/volver":
                Dispatcher.dispatch(request,response, "index.html");
                break;

            //Accion para eliminar un cd
            case "/eliminar":
                AyudanteCarrito.eliminarCd(carrito, request.getParameter("seleccion"));
                Dispatcher.dispatch(request,response, "visualizacion.jsp");
                break;

            //Accion para pagar todo el carrito. Necesita confirmacion iniciando sesion
            case "/pagar":
                Dispatcher.dispatch(request,response, "iniciarSesion.jsp");
                break;

            //Accion para iniciar sesion e ir a la ultima pestana
            case "/iniciar":
                Boolean validado=AyudanteBase.validar(request.getParameter("correo"),
                    request.getParameter("contrasena"));

                //Si inicio sesion, va al fin. Si no, imprime error
                if(validado){
                    AyudanteBase.crearPedido(request);
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
                int estado=AyudanteBase.crearUsuario(request.getParameter("correo"),
                    request.getParameter("contrasena"), request.getParameter("tipo"), 
                    request.getParameter("numero"));

                //Si se creo correctamente, va al fin. Si no, imprime error 
                if(estado==0){
                    AyudanteBase.crearPedido(request);
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