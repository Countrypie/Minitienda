import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

public class Seleccionar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtienen la sesion y el carrito
        HttpSession sesion=request.getSession();
        Carrito carrito=(Carrito)sesion.getAttribute("Carrito");

        if(carrito==null){
            carrito= new Carrito();
            sesion.setAttribute("Carrito",carrito);
        }
        
        //Se anade el cd al carrito
        carrito.anadirCD(request.getParameter("titulo"),
            Integer.parseInt(request.getParameter("cantidad")));

        //Se devuelve la pagina de visualizacion del carrito
        RequestDispatcher rd=request.getRequestDispatcher("visualizacion.jsp");
        rd.forward(request,response);
    }

}