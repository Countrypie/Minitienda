import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

//Servlet que controla la pagina que muestra el contenido del carrito
public class Visualizar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtiene el ayudante
        AyudanteCarrito ayuda=new AyudanteCarrito();

        //Se edetecta la accion pedida
        String accion=request.getServletPath();
        switch(accion){

            //Accion para volver a la pagina inicial para anadir mas cds
            case "/volver":
                Dispatcher.dispatch(request,response, "index.html");
                break;

            //Accion para eliminar un cd del carrito
            case "/eliminar":
                ayuda.eliminarCd(request);
                Dispatcher.dispatch(request,response, "visualizacion.jsp");
                break;

            //Accion para ir a pagar el carrito. Necesita confirmacion iniciando sesion
            case "/irConfirmar":
                Dispatcher.dispatch(request,response, "iniciarSesion.jsp");
                break;

            default:
                System.out.printf("Error al reconocer al formulario, %s\n", accion);
                break;
        }
    }
}