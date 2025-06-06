package carrito;

import java.io.Serializable;
import java.util.*;

//Clase para almacenar propiedades
public class CarritoBean implements Serializable{

    private HashMap<String, Cd> cds;    //Lista de cds en el carrito
    private String propietario;                 //Propietario del carrito
    private Integer pedido;                     //Identificador de la compra

    //Constructor
    public CarritoBean(){
        cds= new HashMap<String, Cd>();
        propietario=null;
        pedido=null;
    }

    //Getters y setters
    public HashMap<String, Cd> getCds(){
        return this.cds;
    }

    public void setCds(HashMap<String, Cd> cds){

        this.cds=cds;
    }   
    
    public String getPropietario(){
        return this.propietario;
    }

    public void setPropietario(String propietario){

        this.propietario=propietario;
    }    

    public Integer getPedido(){
        return this.pedido;
    }

    public void setPedido(Integer pedido){

        this.pedido=pedido;
    }    

    //Funcion para obtener el importe de todos los cds
    public float getImporte(){

        float importe=0;
        for(Map.Entry<String, Cd> entrada : cds.entrySet()){
            importe+=entrada.getValue().getImporte();
        }

        return importe;
    }
}
