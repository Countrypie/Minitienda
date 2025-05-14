import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

//Servlet que se encarga de controlar las páginas de caja y fin
public class Finalizar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtienen los ayudantes
        AyudanteCarrito ayudaC=new AyudanteCarrito(request);
        AyudanteBase ayudaB=new AyudanteBase(request);

        //Se crea el pedido
        ayudaB.crearPedido(ayudaC.obtenerCarrito());
        //Se guarda el importe
        HttpSession session=request.getSession();
        session.setAttribute("importe",ayudaC.obtenerCarrito().getImporte());
        //Se vacia el carrito
        ayudaC.vaciar();
        //Se va a la pagina con el ticket
        Dispatcher.dispatch(request,response,"fin.jsp");
            
    }

}