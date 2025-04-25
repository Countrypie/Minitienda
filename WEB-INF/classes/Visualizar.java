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

            //Accion para volver a la pagina inicial
            case "volver":
                break;

            //Accion para pagar todo el carrito
            case "pagar":
                break;

            //Accion para eliminar un cd
            case "eliminar":
                break;

            default:
                break;
        }
    }

    //Funcion para volver a la pagina inicial
    private void volver(){

    }

    //Funcion para pagar todo el carrito
    private void pagar(){

    }

    //Funcion para eliminar un cd
    private void eliminar(){

    }

}