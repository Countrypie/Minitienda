package carrito;

import java.io.Serializable;
import java.util.*;


public class CarritoBean implements Serializable{

    private HashMap<String, Cd> cds;
    String propietario;
    Integer pedido;

    public CarritoBean(){
        cds= new HashMap<String, Cd>();
        propietario=null;
        pedido=null;
    }

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
