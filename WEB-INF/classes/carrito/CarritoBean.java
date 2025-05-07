package carrito;

import java.io.Serializable;
import java.util.*;


public class CarritoBean implements Serializable{

    private HashMap<String, Cd> cds;

    public CarritoBean(){
        this.cds= new HashMap<String, Cd>();
    }

    public HashMap<String, Cd> getCds(){
        return this.cds;
    }

    public void setCds(HashMap<String, Cd> cds){

        this.cds=cds;
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
