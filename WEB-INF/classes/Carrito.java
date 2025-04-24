import java.io.*;
import java.util.*;


public class Carrito {

    private HashMap<String, Integer> cds;

    //Constructor
    public Carrito(){
        this.cds= new HashMap<String, Integer>();
    }

    //Añade un cd al carrito
    public void anadirCD(String titulo, int cantidad){
        
        if(this.cds.containsKey(titulo)){
            int pedidos=this.cds.get(titulo);
            pedidos += cantidad;
            this.cds.put(titulo, pedidos);
        }else{
            this.cds.put(titulo, cantidad);
        }
    }

    //Devuelve la estructura con todos los cds
    public HashMap<String, Integer> getCds(){
        return this.getCds();
    }

    //Devuelve el importe asociado a un cd
    public float getImporte(String cd){

        StringTokenizer t = new StringTokenizer(cd,"|");
        t.nextToken();
        t.nextToken();
        t.nextToken();
        String precioString = t.nextToken();
        precioString = precioString.replace('$',' ').trim();

        float precio=Float.parseFloat(precioString);
        float cantidad=this.cds.get(cd);

        return precio*cantidad;
    }

    //Devuelve el importe total
    public float getImporteTotal(){

        float importe=0;
        for(String cd : this.cds.keySet()){
            StringTokenizer t = new StringTokenizer(cd,"|");
            t.nextToken();
            t.nextToken();
            t.nextToken();
            String precioString = t.nextToken();
            precioString = precioString.replace('$',' ').trim();

            float precio=Float.parseFloat(precioString);
            float cantidad=this.cds.get(cd);
            importe+=precio*cantidad;
        }

        return importe;
    }

    //Metodo privado para debuguear
    private void imprimirTodo(){
        System.out.println("Contenido");
        for(String cd : cds.keySet()){
            System.out.printf("\t%s, %d, %f\n",cd,cds.get(cd),this.getImporte(cd));
        }
        System.out.printf("Importe: %f\n",this.getImporteTotal());
    }
    
}
