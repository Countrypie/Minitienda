import carrito.CarritoBean;
import carrito.Cd;

//Clase auxiliar para manejar el carrito
public class AyudanteCarrito {

    //Metodo para anadir cds al carrito
    public static void anadirCarrito(CarritoBean carrito, String descripcion, Integer cantidad){
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
    public static void eliminarCd(CarritoBean carrito, String cd){
        carrito.getCds().remove(cd);
    }

    //Metodo para vaciar todo el contenido del carrito
    public static void vaciar(CarritoBean carrito){
        carrito.getCds().clear();
    }
}
