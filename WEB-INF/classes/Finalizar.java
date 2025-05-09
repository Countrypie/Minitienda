import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

public class Finalizar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtienen la sesion y el carrito
        HttpSession sesion=request.getSession();
        CarritoBean carrito=(CarritoBean)sesion.getAttribute("carrito");

        if(carrito==null){
            carrito= new CarritoBean();
            sesion.setAttribute("carrito",carrito);

        }else{
            //Logica de vaciar el carrito
            carrito.getCds().clear();;

        }

        //Volver a pagina principal
        Dispatcher.dispatch(request,response, "index.html");
    }

}