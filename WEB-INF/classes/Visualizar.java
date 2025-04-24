import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Visualizar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtienen la sesion y el carrito
        HttpSession sesion=request.getSession();
        Carrito carrito=null;

        if(sesion.isNew()){
            carrito= new Carrito();
            sesion.setAttribute("Carrito",carrito);
        }else{
            carrito=(Carrito)sesion.getAttribute("Carrito");
        }

        //Se ejecuta una de las tres acciones posibles
        String accion=request.getServletPath();
        switch(accion){
            case "volver":
                break;

            case "pagar":
                break;

            case "eliminar":
                break;

            default:
                break;
        }
    }

}