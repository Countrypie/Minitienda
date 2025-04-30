import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

public class Visualizar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtienen la sesion y el carrito
        HttpSession sesion=request.getSession();
        Carrito carrito=(Carrito)sesion.getAttribute("Carrito");

        if(carrito==null){
            carrito= new Carrito();
            sesion.setAttribute("Carrito",carrito);
        }

        //Se ejecuta una de las tres acciones posibles
        String accion=request.getServletPath();
        RequestDispatcher rd;
        switch(accion){

            //Accion para volver a la pagina inicial
            case "/volver":
                rd=request.getRequestDispatcher("index.html");
                rd.forward(request,response);
                break;

            //Accion para eliminar un cd
            case "/eliminar":
                carrito.eliminaCd(request.getParameter("seleccion"));
                rd=request.getRequestDispatcher("visualizacion.jsp");
                rd.forward(request,response);
                break;

            //Accion para pagar todo el carrito
            case "/pagar":
                rd=request.getRequestDispatcher("fin.jsp");
                rd.forward(request,response);
                break;
    

            default:
                System.out.println("Error al reconocer al formulario");
                break;
        }
    }
}