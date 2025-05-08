import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

public class Seleccionar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtienen la sesion y el carrito
        HttpSession sesion=request.getSession();
        CarritoBean carrito=(CarritoBean)sesion.getAttribute("carrito");

        if(carrito==null){
            carrito= new CarritoBean();
            sesion.setAttribute("carrito",carrito);
        }
        
        //Se anade el cd al carrito
        String descripcion=request.getParameter("titulo");
        Integer cantidad=Integer.parseInt(request.getParameter("cantidad"));

        //La cantidad debe ser positiva
        if(cantidad>0){
            //Si ya estaba se incrementa
            if(carrito.getCds().containsKey(descripcion)){
                Cd cd=carrito.getCds().get(descripcion);
                cd.setCantidad(cd.getCantidad()+cantidad);
            //Si es nuevo se anade
            }else{
                Cd cd = new Cd(descripcion, cantidad);
                carrito.getCds().put(cd.getDescripcion(), cd);
            }
        }
        
        //Se devuelve la pagina de visualizacion del carrito
        RequestDispatcher rd=request.getRequestDispatcher("visualizacion.jsp");
        rd.forward(request,response);
    }

}