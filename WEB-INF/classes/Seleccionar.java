import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Seleccionar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Hay que meter codigo de sesion

        Carrito carrito= new Carrito();
        carrito.anadirCD(request.getParameter("titulo"),
            Integer.parseInt(request.getParameter("cantidad")));

        //Hay que meter codigo de siguiente pagina
    }

}