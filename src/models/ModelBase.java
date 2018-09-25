
package models;

/**
 *
 * @author Oscar
 */
public class ModelBase {
    
    String path = "C:\\Users\\Oscar\\Documents\\pruebas\\base.csv";
    String nombre;
    String correo;

    public String getNombre() {
        return nombre;
    }

    public String getPath() {
        return path;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String [] getArray(){
           String [] datos = {getNombre(),getCorreo()};
           return datos;
       }
}
