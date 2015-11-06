/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

/**
 * Se crea la clase Curso, la cual se utiliza para crear las tablas (prueba).
 * @author cristhian
 * @version 6/11/15
 */
public class Curso {
 
    private String carne;
    private String nombre;
    private String telefono;
 
    // Los siguentes son métodos set y get, los cuales sirven para obetener y otorgar datos.
    public String getCarne() {
        return carne;
    }
 
    public void setCarne(String carne) {
        this.carne = carne;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getTelefono() {
        return telefono;
    }
 
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}