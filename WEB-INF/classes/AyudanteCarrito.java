import jakarta.servlet.*;
import jakarta.servlet.http.*;

import carrito.*;

//Clase auxiliar para manejar el carrito
public class AyudanteCarrito {

    HttpServletRequest request=null;

    //Constructor
    public AyudanteCarrito(HttpServletRequest request){
        this.request=request;
    }

    //Metodo para obtener el carrito desde la sesion. Tambien lo registra si hace falta
    public CarritoBean obtenerCarrito(){
        //Se obtiene
        HttpSession sesion=request.getSession();
        CarritoBean carrito=(CarritoBean)sesion.getAttribute("carrito");

        //Se registra si no existe
        if(carrito==null){
            carrito= new CarritoBean();
            sesion.setAttribute("carrito",carrito);
        }

        return carrito;
    }

    //Metodo para anadir cds al carrito
    public void anadirCarrito(){

        //Se obtienen el carrito y los parametros
        CarritoBean carrito=this.obtenerCarrito();
        String descripcion=request.getParameter("titulo");
        Integer cantidad=Integer.parseInt(request.getParameter("cantidad"));

        //La cantidad debe ser positiva
        if(cantidad>0){
            //Si ya estaba se incrementa el numero de cds
            if(carrito.getCds().containsKey(descripcion)){
                Cd cd=carrito.getCds().get(descripcion);
                cd.setCantidad(cd.getCantidad()+cantidad);
            //Si es nuevo se anade un nuevo cd
            }else{
                Cd cd = new Cd(descripcion, cantidad);
                carrito.getCds().put(cd.getDescripcion(), cd);
            }
        }
    }

    //Metodo para borrar un cd del carrito
    public void eliminarCd(){
        CarritoBean carrito=this.obtenerCarrito();
        String cd= request.getParameter("seleccion");
        carrito.getCds().remove(cd);
    }

    //Metodo para vaciar todo el contenido del carrito
    public void vaciar(){
        this.obtenerCarrito().getCds().clear();
    }
}
