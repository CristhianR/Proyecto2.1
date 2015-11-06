
package servidor;

// Bibliotecas importadas
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import json.Curso;
import json.JSONArray;
import json.JSONObject;


/**
 * Se crea la clase del cliente, el cual se comunica con el servidor.
 * @author cristhian
 * @version 6/11/15
 */


public class Cliente {

    public static void main(String[] args) {
        
        String res = null;
        int num[] = new int[3];
        JSONObject x;
     
        //Se instancia la clase Curso, encargada de crear las lista de datos.
    Curso c1 = new Curso();
    c1.setNombre("Esteban");
    c1.setCarne("2014159933");
    c1.setTelefono("88538823");
    
    Curso c2 = new Curso();
    c2.setNombre("Cristhian");
    c2.setCarne("2014159932");
    c2.setTelefono("88438823");
    
    //Se meten los datos dentro de un array.
    List<Curso> clientes = new ArrayList<Curso>();
    clientes.add(c1);
    clientes.add(c2);
    System.out.println(clientes);
    
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
        x = objEstudiantes;
        System.out.println(x.toString());
        
        
        
            
            String host = "localhost";
            // Socket servidor 
            Socket sc = new Socket(host, 2500); 

            OutputStream ostream = sc.getOutputStream();
            ObjectOutput s = new ObjectOutputStream(ostream);

            num[2] = 10;
            num[0] = 5;
            num[1] = 15; 
            //Prepara la petición
            s.writeUTF(x.toString());
            s.flush();

            ObjectInputStream istream = new ObjectInputStream(sc.getInputStream());
            res = istream.readUTF();
            
            String z = res;
            String[] b = z.split(":");
            System.out.println(b[0]);
            
            for(int i = 0; i < b.length; i++){
                
                
                
                
            }
            
            /*int posicion;
            posicion = res.indexOf("Estudiante");
            
            if (posicion > -1)
                System.out.println("La palabra está en la posición " + posicion);
            else
                System.out.println("No se encuentra la palabra");*/
            
            
            // Pasamos la respuesta de servidor a un objeto Json
            JSONObject r = new JSONObject(res);
            
            System.out.println(res);
            
           System.out.println("El largo " + r);
            
            
            }
    

        catch (Exception e) {
            System.err.println("exepcion" + e.toString());
            e.printStackTrace();
        }

    }
   
    

    private static JSONObject JSONObject(String res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
