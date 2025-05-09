import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

import carrito.CarritoBean;

//Clase auxiliar para la sesion
public class AyudanteSesion {

    //Metodo para obtener el carrito desde la sesion. Tambien lo registra si hace falta
    public static CarritoBean obtenerCarrito(HttpServletRequest peticion){
        HttpSession sesion=peticion.getSession();
        CarritoBean carrito=(CarritoBean)sesion.getAttribute("carrito");

        if(carrito==null){
            carrito= new CarritoBean();
            sesion.setAttribute("carrito",carrito);
        }

        return carrito;
    }
}