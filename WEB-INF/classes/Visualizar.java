import java.io.*;

import baseDatos.ConexionBD;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

public class Visualizar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtiene el carrito
        CarritoBean carrito=AyudanteSesion.obtenerCarrito(request);

        //Se ejecuta una de las tres acciones posibles
        String accion=request.getServletPath();
        RequestDispatcher rd;
        switch(accion){

            //Accion para volver a la pagina inicial
            case "/volver":
                Dispatcher.dispatch(request,response, "index.html");
                break;

            //Accion para eliminar un cd
            case "/eliminar":
                AyudanteCarrito.eliminarCd(carrito, request.getParameter("seleccion"));
                Dispatcher.dispatch(request,response, "visualizacion.jsp");
                break;

            //Accion para pagar todo el carrito
            case "/pagar":
                try{
                    ConexionBD conexion = new ConexionBD();
                    conexion.getDAOUsuarios().nuevoUsuario("accion", "micontrasena", "visa", 69);
                    conexion.getConecion().close();
                }catch(Exception e){
                    e.printStackTrace();
                }
                Dispatcher.dispatch(request,response, "fin.jsp");
                break;
    

            default:
                System.out.println("Error al reconocer al formulario");
                break;
        }
    }
}