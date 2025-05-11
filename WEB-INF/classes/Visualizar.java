import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

public class Visualizar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtiene el ayudante
        AyudanteCarrito ayuda=new AyudanteCarrito();

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
                ayuda.eliminarCd(request);
                Dispatcher.dispatch(request,response, "visualizacion.jsp");
                break;

            //Accion para pagar todo el carrito. Necesita confirmacion iniciando sesion
            case "/pagar":
                Dispatcher.dispatch(request,response, "iniciarSesion.jsp");
                break;

            default:
                System.out.println("Error al reconocer al formulario");
                break;
        }
    }
}