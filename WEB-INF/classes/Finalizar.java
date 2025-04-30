import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

public class Finalizar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtienen la sesion y el carrito
        HttpSession sesion=request.getSession();

        //Logica de vaciar el carrito
        sesion.invalidate();

        //Volver a pagina principal
        RequestDispatcher rd=request.getRequestDispatcher("index.html");
        rd.forward(request,response);
    }

}