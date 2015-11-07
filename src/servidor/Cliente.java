package servidor;

// Bibliotecas importadas
import java.io.*;
import java.net.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import json.Curso;
import json.JSONArray;
import json.JSONObject;

/**
 * Se crea la clase del cliente, el cual se comunica con el servidor.
 *
 * @author cristhian
 * @version 6/11/15
 */
public class Cliente {

    public static void main(String[] args) {

        String res = null;
        
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
    //System.out.println(clientes);

        //CREAMOS EL OBJETO JSON
        JSONArray objClientes = new JSONArray();
        
        while(!"OK".equals(res)) {

        try {

            for (Curso cliente : clientes) {
                JSONObject objCliente = new JSONObject();
                objCliente.put("nombre", cliente.getNombre());
                objCliente.put("carne", cliente.getCarne() + " ");
                objCliente.put("telefono", cliente.getTelefono()+ " ");
                objClientes.put(objCliente);
            }

            JSONObject objEstudiantes = new JSONObject();
            objEstudiantes.put("Estudiantes:", objClientes);
            x = objEstudiantes;
            String xx = x.toString();
            
       

            String host = "localhost";
            // Socket servidor 
            Socket sc = new Socket(host, 2500);

            OutputStream ostream = sc.getOutputStream();
            ObjectOutput s = new ObjectOutputStream(ostream);
            
            /* EL siguiente código se utliza para extraer el comando del JSON; sabiendo que es la primer palabra de la estructura.
            1- Se pasa el string del JSON a un charArray.
            2- Se inicializa una variable string vacia, para almacenar el futuro comando.
            3- Se crea un bucle para elimar simbolos.
            4- Como no se pueden eliminar las "" directamente se crea otro bucle para eliminarlas, sabiendo que esran simpre al final y al inicio.
            5- Finalmente se utiliza las sentecias if-else para validar el comando y así enviarlo al servidor.
            */
            // PASO 1
            char[] c = xx.toCharArray();
            // PASO 2
            String salida = "";
            
            // PASO 3: Se crea un bucle para eliminar del JSON todo aquello que no sea letras.
            for (int i = 0; i < c.length; i++) {
                if (c[i] == '{' || c[i] == '}' || c[i] == ',' || c[i] == ':' || c[i] == '[' || c[i] == ']') {

                } else {

                    char[] b = {c[i]};
                    String a = new String(b);
                    
                    salida += a;
                    
                }
                //IMPORTANTE: aqui hay que definir un rango de letras, al parecer está de entre 5 a 10 letras.
                //Lo mejor seria deifinir una de fijo; por ejemplo 8, y si un caracter no llega a 8 que lo rellene con x.
                // En este caso yo use 15, pues ese es el tamaño del string que estaba validando.
                if(i == 15){
                    break;
                }
            }
            // PASO 4
            System.out.println(salida);
            char[] b = salida.toCharArray();
            String comando = "";
            for(int i = 0 ; i < b.length ; i++){
                if(i == 0 || i+2 > b.length){
                    
                    
                }else{
                    char[] e = {b[i]};
                    String a = new String(e);
                    comando += a;
                   
                }
            }
            System.out.println("Este es el comando:   " +   comando);
            
            // PASO 5
            if("Estudiantes".equals(comando)){
                System.out.println("SI");
               
            } else {
                System.out.println("NO");
            }

            
            //Prepara la petición
            s.writeUTF(comando);
            s.flush();

            ObjectInputStream istream = new ObjectInputStream(sc.getInputStream());
            res = istream.readUTF();
            
            // Pasamos la respuesta del servidor a un objeto Json
            //JSONObject r = new JSONObject(res);

            System.out.println(res);
           //System.out.println("El largo " + r);
            
        } catch (Exception e) {
            System.err.println("exepcion" + e.toString());
            e.printStackTrace();
        }

    }
    }
    private static JSONObject JSONObject(String res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
