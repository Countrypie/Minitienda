import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

//Servlet que controla como anadir el cd seleccionado al carrito
public class Seleccionar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtiene el ayudante
        AyudanteCarrito ayuda=new AyudanteCarrito(request);
        
        //Se anade el cd al carrito
        ayuda.anadirCarrito();
        
        //Se reenvia a la pagina de visualizacion del carrito
        Dispatcher.dispatch(request,response, "visualizacion.jsp");
    }
}