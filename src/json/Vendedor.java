
package json;

import java.util.List;
import json.Curso;
 
/**
 *Esta es otra clase, para la prueba.
 * @author cristhian
 * @version 6/11/15
 */
public class Vendedor {
 
    private int edad;
    private String nombre;
    private String apellido;
    private List<Curso> clientes;
 
    public String getApellido() {
        return apellido;
    }
 
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
 
    public List<Curso> getClientes() {
        return clientes;
    }
 
    public void setClientes(List<Curso> clientes) {
        this.clientes = clientes;
    }
 
    public int getEdad() {
        return edad;
    }
 
    public void setEdad(int edad) {
        this.edad = edad;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
