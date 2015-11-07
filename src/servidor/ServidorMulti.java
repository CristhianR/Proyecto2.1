
package servidor;

//Importamos las bibliotecas a utilizar
import java.io.* ;
import java.net.* ;
import java.lang.Thread;
import java.util.List;
import json.Curso;
import json.JSONObject;
import json.JSONTokener;
import json.JSONArray;


/**
 * Creamos el servidor multicliente, utilizando hilos.
 * @author cristhian
 * @version 6/11/15
 */
class clientHandler implements Runnable{
    
    private Socket socket;
    Thread t;
    
    /**
     * Este método sirve para otorgar un hilo por cliente.
     * @param socket, pues necesita seguir atendiendo otros clientes. 
     */
    public clientHandler(Socket socket){
        this.socket = socket;
        this.t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run(){
        
        int num[];
        String res;
        String x;
        
        
        
        try {
            //Se realiza el código de las funciones del servidor y comunicación.
            InputStream istream = socket.getInputStream();
            ObjectInput in = new ObjectInputStream(istream);
            System.out.println("Objeto llego");
            System.out.println("Mandando mensaje al cliente");
            x = (String) in.readUTF();
            
            // Aqui se programan las "validaciones", para que el servidor realice la petición y responda.
           if("Estudiantes".equals(x)){
               
               res = "OK";
               
           } if("Crear".equals(x)){
               
               res = "ok";
           }
           else{
               res = "Comando no existe";
           }
            
            
            
                
            
          ObjectOutputStream ostream = new ObjectOutputStream(socket.getOutputStream());
          ostream.writeUTF(res);
          ostream.flush();
          socket.close();
          
        } catch (Exception e){
            System.err.println("Error al operar con el cliente");
        }
        
    } //run
    
    
} //client handler

/**
 * Se crea la clase del servidor.
 * @author cristhian
 * @version 66/11/15
 */
public class ServidorMulti {

    
    public static void main(String[] args) {
        
        ServerSocket serverAddr = null;
        Socket sc = null;
        
        try {
            serverAddr = new ServerSocket(2500);
            while (true) {
                
                sc = serverAddr.accept(); // esperando conexión
                new clientHandler(sc);
            }
                
            } catch (Exception e) {
                    System.err.println("excepcion" + e.toString());
                    e.printStackTrace();
            }
        } //main
        
    }// servidor
    

    