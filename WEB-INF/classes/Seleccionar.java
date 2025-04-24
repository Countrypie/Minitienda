import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Seleccionar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Hay que meter codigo de sesion
        HttpSession sesion=request.getSession();
        Carrito carrito=null;
        System.out.println("test");

        if(sesion.isNew()){
            carrito= new Carrito();
            sesion.setAttribute("Carrito",carrito);
        }else{
            carrito=(Carrito)sesion.getAttribute("Carrito");
        }
        
        //Se anade el cd al carrito
        carrito.anadirCD(request.getParameter("titulo"),
            Integer.parseInt(request.getParameter("cantidad")));

        //Hay que meter codigo de siguiente pagina
    }

}