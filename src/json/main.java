/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import java.util.ArrayList;
import java.util.List;
import json.Curso;




/**
 *
 * @author cristhian
 */
public class main {
    
        
        public static void main(String[] args) {
    
    Curso c1 = new Curso();
    c1.setNombre("Esteban");
    c1.setCarne("2014159933");
    c1.setTelefono("88538823");
    
    List<Curso> clientes = new ArrayList<Curso>();
    clientes.add(c1);
    
    //CREAMOS EL OBJETO JSON
    JSONArray objClientes = new JSONArray();
    try {
        for (Curso cliente : clientes) {
            JSONObject objCliente = new JSONObject();
            objCliente.put("nombre", cliente.getNombre());
            objCliente.put("carne", cliente.getCarne());
            objCliente.put("telefono", cliente.getTelefono());
            objClientes.put(objCliente);
        }
        JSONObject objEstudiantes = new JSONObject();
        objEstudiantes.put("Estudiantes:", objClientes);
        JSONObject x = objEstudiantes;
        System.out.println(x);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
        
        
        
  
        
        
     