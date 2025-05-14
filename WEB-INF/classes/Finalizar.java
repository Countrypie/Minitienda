import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

//Servlet que se encarga de controlar las páginas de caja y fin
public class Finalizar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtienen los ayudantes
        AyudanteCarrito ayudaC=new AyudanteCarrito();
        AyudanteBase ayudaB=new AyudanteBase();

        //Se detecta la solicitud
        String accion=request.getServletPath();
        switch(accion){

            //Si se pago el pedido, se guarda en la BD y va a la pagina final
            case "/pagar":

                ayudaB.crearPedido(ayudaC.obtenerCarrito(request));
                Dispatcher.dispatch(request,response,"fin.jsp");
                break;

            //Si tras ver el ticket pulso en acabar, vuelve a la pagina principal
            case "/acabar":

                Dispatcher.dispatch(request,response,"index.html");
                break;
    

            default:
                System.out.println("Error al reconocer al formulario");
                break;
        }
    }

}