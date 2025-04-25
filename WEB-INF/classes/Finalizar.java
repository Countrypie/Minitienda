import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Finalizar extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        response.setContentType("text/html");

        //Se obtienen la sesion y el carrito
        HttpSession sesion=request.getSession();

        //Logica de eliminar la sesion
        sesion.invalidate();

        //Volver a pagina principal
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

}