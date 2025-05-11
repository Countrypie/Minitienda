import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

public class Finalizar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtiene el carrito y se vacia
        AyudanteCarrito ayuda=new AyudanteCarrito();
        ayuda.vaciar(request);

        //Volver a pagina principal
        Dispatcher.dispatch(request,response, "index.html");
    }

}