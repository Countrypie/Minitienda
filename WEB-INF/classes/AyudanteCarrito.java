import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

//Clase auxiliar para manejar el carrito
public class AyudanteCarrito {

    //Metodo para obtener el carrito desde la sesion. Tambien lo registra si hace falta
    public CarritoBean obtenerCarrito(HttpServletRequest peticion){
        HttpSession sesion=peticion.getSession();
        CarritoBean carrito=(CarritoBean)sesion.getAttribute("carrito");

        if(carrito==null){
            carrito= new CarritoBean();
            sesion.setAttribute("carrito",carrito);
        }

        return carrito;
    }

    //Metodo para anadir cds al carrito
    public void anadirCarrito(HttpServletRequest request){

        CarritoBean carrito=this.obtenerCarrito(request);
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
    }

    //Metodo para borrar un cd del carrito
    public void eliminarCd(HttpServletRequest request){
        CarritoBean carrito=this.obtenerCarrito(request);
        String cd= request.getParameter("seleccion");
        carrito.getCds().remove(cd);
    }

    //Metodo para vaciar todo el contenido del carrito
    public void vaciar(HttpServletRequest request){
        this.obtenerCarrito(request).getCds().clear();
    }
}
