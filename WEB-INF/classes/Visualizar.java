import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

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

        PrintWriter out=response.getWriter();
        out.println("<html>" +
            "<head>" +
            "<title>Musica para DAA</title>" +
            "<meta charset=\"UTF-8\">" +
            "</head>" +
            "<body bgcolor=\"#FDF5E6\">" +
            "<table align=\"center\" border=\"0\">" +
            "<tr>" +
            "<th><IMG SRC=\"./Imagenes/partitura.png\" ALIGN=\"CENTER\" width=\"200px\"></th>" +
            "<th><font face=\"Times New Roman,Times\" size=\"+3\">Música para DAA</font></th>" +
            "<th><IMG SRC=\"./Imagenes/partitura.png\" ALIGN=\"CENTER\" width=\"200px\"></th>" +
            "</tr>" +
            "</table>" +
            "<hr>" +
            "<p>" +
            "<center>" +
            "<form action=\"seleccionar\">" +
            "<b>CD:</b>" +
            "<select name=\"titulo\">" +
            "<option>Yuan | The Guo Brothers | China | $14.95</option>" +
            "<option>Drums of Passion | Babatunde Olatunji | Nigeria | $16.95</option>" +
            "<option>Kaira | Tounami Diabate| Mali | $16.95</option>" +
            "<option>The Lion is Loose | Eliades Ochoa | Cuba | $13.95</option>" +
            "<option>Dance the Devil Away | Outback | Australia | $14.95</option>" +
            "<option>Record of Changes | Samulnori | Korea | $12.95</option>" +
            "<option>Djelika | Tounami Diabate | Mali | $14.95</option>" +
            "<option>Rapture | Nusrat Fateh Ali Khan | Pakistan | $12.95</option>" +
            "<option>Cesaria Evora | Cesaria Evora | Cape Verde | $16.95</option>" +
            "<option>DAA | GSTIC | Spain | $50.00</option>" +
            "</select>" +
            "<b>Cantidad:</b>" +
            "<input type=\"text\" name=\"cantidad\" value=\"1\">" +
            "<p>" +
            "<center>" +
            "<input type=\"submit\" value=\"Selecciona Producto\">" +
            "</center>" +
            "</form>" +
            "</center>" +
            "<hr>" +
            "</body>" +
            "</html>"
        );
    }

    //Funcion para pagar todo el carrito
    private void pagar(Carrito carrito,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        PrintWriter out = response.getWriter();
        out.println(
            "<html>" +
            "<head>" +
            "<title>Caja</title>" +
            "<meta charset=\"UTF-8\">" +
            "<style>" +
                "input[type=image]{" +
                "  border: 2px solid transparent;" +
                "}" +
                "input[type=image]:hover {" +
                "  border: 2px solid purple;" +
                "}" +
            "</style>" +
            "</head>" +
            "<body bgcolor=\"#FDF5E6\">" +
            "<h1 align=\"center\">Caja</h1>" +
            "<form action=\"finalizar\">" +
                "<table align=\"center\" border=\"1\" bgcolor=\"white\">" +
                "<tr><th>TOTAL A PAGAR</th></tr>" +
                "<tr><td align=\"center\">" + String.format("%.2f", carrito.getImporteTotal()) + "</td></tr>" +
                "</table>" +
                "<hr>" +
                "<div align=\"center\">" +
                "<input type=\"image\" name=\"pagar\" src=\"./Imagenes/partitura.png\"" +
                "width=\"200px\" alt=\"Pagar y volver a la página principal\">" +
                "<br>Pagar y volver a la página principal" +
                "</tr></div>" +
            "</form>" +
            "</body>" +
            "</html>"
        );
    }

    //Funcion para eliminar un cd
    private void eliminar(Carrito carrito,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        String titulo = request.getParameter("seleccion");
        carrito.eliminaCd(titulo);

        //Se recarga esta pagina
        PrintWriter out=response.getWriter();
        out.println(
            "<html>" +
            "<head>" +
            "<title>Carrito de la compra</title>" +
            "<meta charset=\"UTF-8\">" +
            "<style>" +
                "input[type=image]{" +
                "  border: 2px solid transparent;" +
                "}" +
                "input[type=image]:hover {" +
                "  border: 2px solid purple;" +
                "}" +
            "</style>" +
            "</head>" +
            "<body bgcolor=\"#FDF5E6\">" +
            "<h1 align=\"center\">Carrito de la compra</h1>" +
            "<form action=\"eliminar\">" +
                "<table align=\"center\" border=\"1\" bgcolor=\"white\">" +
                "<tr>" +
                    "<th>TITULO DEL CD</th>" +
                    "<th>Cantidad</th>" +
                    "<th>Importe</th>" +
                    "<th>Eliminar</th>" +
                "</tr>"
        );
        for (String cd : carrito.getCds().keySet()) {
            int cantidad = carrito.getCds().get(cd);
            double importe = carrito.getImporte(cd);
            out.println(
                "<tr>" +
                    "<td>" + cd + "</td>" +
                    "<td align=\"center\">" + cantidad + "</td>" +
                    "<td align=\"right\">"  + String.format("%.2f", importe) + "</td>" +
                    "<td align=\"center\">" +
                    "<input type=\"radio\" name=\"seleccion\" value=\"" + cd + "\">" +
                    "</td>" +
                "</tr>"
            );
        }
        out.println(
                "<tr>" +
                    "<td colspan=\"2\" align=\"right\"><b>IMPORTE TOTAL</b></td>" +
                    "<td align=\"right\">" + String.format("%.2f", carrito.getImporteTotal()) + "</td>" +
                    "<td><input type=\"submit\" value=\"Eliminar\"></td>" +
                "</tr>" +
                "</table>" +
            "</form>" +
            "<hr>" +
            "<table align=\"center\" border=\"0\">" +
            "<tr>"+
                "<td>"+"<form action=\"volver\">" +
                "<input type=\"image\" src=\"./Imagenes/carrito.png\" alt=\"Sigo comprando\" width=\"200px\"><br>" +
                "</form>" + "<td>"+
                "<form action=\"pagar\">" +
                "<input type=\"image\" src=\"./Imagenes/caja.png\" alt=\"Me largo a pagar\" width=\"200px\"><br>" +
                "</td>" +
            "</tr>" +
            "<tr>"+
                "<td>"+
                "Sigo comprando" +
                "<td>"+
                "Me largo a pagar" +
                "</td>" +
            "</tr>" +
            "</table>" +
            "</body>" +
            "</html>"
        );
    }

}