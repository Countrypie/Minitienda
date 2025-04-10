import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import Carrito.java;

public class Seleccionar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        Carrito carrito= new Carrito(request.getParameter("titulo"),request.getParameter("cantidad"));
        carrito.anadirCD();
    }

}