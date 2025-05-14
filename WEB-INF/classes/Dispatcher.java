import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

//Clase estatica para cambiar de pagina usando el metodo forward
public class Dispatcher {

    public static void dispatch(HttpServletRequest peticion, HttpServletResponse respuesta, String nombre)
    throws ServletException, IOException {
        RequestDispatcher rd = peticion.getRequestDispatcher(nombre);
        rd.forward(peticion, respuesta);
    }
}
