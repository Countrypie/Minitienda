import java.io.*;
import java.util.*;


public class Carrito {

    private HashMap<String, Integer> cds;

    public Carrito(){
        this.cds= new HashMap<String, Integer>();
    }


    public void anadirCD(String titulo, int cantidad){
        
        if(this.cds.containsKey(titulo)){
            int pedidos=this.cds.get(titulo);
            pedidos += cantidad;
            this.cds.put(titulo, pedidos);
        }else{
            this.cds.put(titulo, cantidad);
        }

        System.out.printf("%s %d", titulo, this.cds.get(titulo));
    }
    
}
