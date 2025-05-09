import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

public class Seleccionar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtiene el carrito
        CarritoBean carrito=AyudanteCarrito.obtenerCarrito(request);
        
        //Se anade el cd al carrito
        AyudanteCarrito.anadirCarrito(carrito, request.getParameter("titulo"), 
            Integer.parseInt(request.getParameter("cantidad")));
        
        //Se devuelve la pagina de visualizacion del carrito
        Dispatcher.dispatch(request,response, "visualizacion.jsp");
    }
}