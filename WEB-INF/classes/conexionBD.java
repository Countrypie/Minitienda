/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package baseDatos;

import aplicacion.Prestamo;
import aplicacion.Ejemplar;
import aplicacion.Usuario;
import aplicacion.Categoria;
import aplicacion.Libro;
import aplicacion.Cita;
import aplicacion.Tarea;
import aplicacion.Voluntario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author basesdatos
 */
public class FachadaBaseDatos {
    private aplicacion.FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAOLibros daoLibros;
    private DAOCategorias daoCategorias;
    private DAOUsuarios daoUsuarios;
    private DAOCitas daoCitas;
    private DAOTareas daoTareas;

    public FachadaBaseDatos (aplicacion.FachadaAplicacion fa){
        
        Properties configuracion = new Properties();
        this.fa=fa;
        FileInputStream arqConfiguracion;

        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();

            Properties usuario = new Properties();
     

            String gestor = configuracion.getProperty("gestor");

            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion=java.sql.DriverManager.getConnection("jdbc:"+gestor+"://"+
                    configuracion.getProperty("servidor")+":"+
                    configuracion.getProperty("puerto")+"/"+
                    configuracion.getProperty("baseDatos"),
                    usuario);

            daoLibros = new DAOLibros(conexion, fa);
            daoCategorias = new DAOCategorias(conexion, fa);
            daoUsuarios = new DAOUsuarios(conexion, fa);
            daoCitas = new DAOCitas(conexion,fa);
            daoTareas = new DAOTareas(conexion,fa);


        } catch (FileNotFoundException f){
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i){
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } 
        catch (java.sql.SQLException e){
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
        }
        
        
        
    }
    

    public Usuario validarUsuario(String dni, String clave){
        return daoUsuarios.validarUsuario(dni, clave);
        
        
    }
    
    public java.util.List<Cita> consultarCitasP(){
        return daoCitas.consultarCitasPersonal();
    }
    
    public java.util.List<Cita> buscarCitasP(int numSucursal){
        return daoCitas.buscarCitasPersonal(numSucursal);
    }
   
    public void aceptarCita(Cita c){
        daoCitas.aceptarCita(c);
    }
    
    public void denegarCita(Cita c){
        daoCitas.denegarCita(c);
    }
    
    public java.util.List<Tarea> consultarTareasVoluntario(Voluntario v){
        return daoTareas.consultarTareasVoluntario(v);
    }
    
    public java.util.List<Tarea> consultarTareasLibres(){
        return daoTareas.consultarTareasLibres();
    }
    
    public void ficharTarea(Tarea tarea, Voluntario voluntario){
        daoTareas.ficharTarea(tarea, voluntario);
    }
    
    public void cancelarTarea(Tarea tarea, Voluntario voluntario){
        daoTareas.cancelarTarea(tarea, voluntario);
    }
    
    public void aceptarTarea(Voluntario voluntario, Tarea tarea){
        daoTareas.aceptarTarea(voluntario, tarea);
    }

}
