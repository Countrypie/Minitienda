package carrito;

import java.util.Objects;
import java.util.StringTokenizer;

//Objeto que almacena información
public class Cd{

    private String descripcion;     //Texto que describe al cd
    private Float precio;           //Precio individual de cada cd
    private Integer cantidad;       //Número de cds agrupados en este objeto

    //Constructor
    public Cd(){
        this.descripcion =null;
        this.precio =null;
        this.cantidad =null;
    }

    //Constructor
    public Cd(String descripcion, Integer cantidad){

        this.descripcion =descripcion;
        this.cantidad =cantidad;

        StringTokenizer t = new StringTokenizer(descripcion,"|");
        t.nextToken();
        t.nextToken();
        t.nextToken();
        String precioString = t.nextToken();
        precioString = precioString.replace('$',' ').trim();

        this.precio = Float.parseFloat(precioString);
        
    }

    //Getters para obtener datos
    public String getDescripcion(){
        return this.descripcion;
    }

    public Integer getCantidad(){
        return this.cantidad;
    }

    public Float getImporte(){
        return this.precio*this.cantidad;
    }

    //Setter para modificar cantidad
    public void setCantidad(Integer cantidad){
        this.cantidad=cantidad;
    }

    //Funciones para comparar
    @Override
    public int hashCode() {
        return Objects.hash(descripcion);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cd)) return false;
        Cd other = (Cd) obj;
        return Objects.equals(this.descripcion, other.descripcion);
    }
}
