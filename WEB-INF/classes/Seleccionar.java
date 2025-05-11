import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

public class Seleccionar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtiene el ayudante
        AyudanteCarrito ayuda=new AyudanteCarrito();
        
        //Se anade el cd al carrito
        ayuda.anadirCarrito(request);
        
        //Se devuelve la pagina de visualizacion del carrito
        Dispatcher.dispatch(request,response, "visualizacion.jsp");
    }
}