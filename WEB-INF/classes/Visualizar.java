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
            case "/volver":
                volver(carrito, request, response);
                break;

            //Accion para pagar todo el carrito
            case "/pagar":
                pagar(carrito, request, response);
                break;

            //Accion para eliminar un cd
            case "/eliminar":
                eliminar(carrito, request, response);
                break;

            default:
                System.out.println("Error al reconocer al formulario");
                break;
        }
    }

    //Funcion para volver a la pagina inicial
    private void volver(Carrito carrito,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

    }

    //Funcion para pagar todo el carrito
    private void pagar(Carrito carrito,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        PrintWriter out = response.getWriter();
        out.println(
            "<html>" +
            "<head>" +
            "<title>Caja</title>" +
            "<meta charset=\"UTF-8\">" +
            "</head>" +
            "<body bgcolor=\"#FDF5E6\">" +
            "<h1 align=\"center\">Caja</h1>" +
            "<form action=\"finalizar\">" +
                "<table align=\"center\" border=\"1\" cellpadding=\"5\" cellspacing=\"0\" bgcolor=\"white\">" +
                "<tr><th>TOTAL A PAGAR</th></tr>" +
                "<tr><td align=\"center\">" + carrito.getImporteTotal() + "</td></tr>" +
                "</table>" +
                "<hr>" +
                "<div align=\"center\">" +
                "<input type=\"image\" name=\"pagar\" src=\"./Imagenes/partitura.png\" alt=\"Pagar\" " +
                        "width=\"200px\"" + "<br>" +
                "<font face=\"Times New Roman,Times\" size=\"+1\">Pagar y volver a la página principal</font>" +
                "</div>" +
            "</form>" +
            "</body>" +
            "</html>"
        );
    }

    //Funcion para eliminar un cd
    private void eliminar(Carrito carrito,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

    }

}