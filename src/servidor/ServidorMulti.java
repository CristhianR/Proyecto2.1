
package servidor;

import java.io.* ;
import java.net.* ;
import java.lang.Thread;
import java.util.List;
import json.Curso;
import json.JSONObject;



class clientHandler implements Runnable{
    
    private Socket socket;
    Thread t;
    
    public clientHandler(Socket socket){
        this.socket = socket;
        this.t = new Thread(this);
        t.start();
    }
    
    @Override
    public void run(){
        
        int num[];
        String res;
        Object x;
        
        
        
        try {
            InputStream istream = socket.getInputStream();
            ObjectInput in = new ObjectInputStream(istream);
            System.out.println("Objeto llego");
            System.out.println("Mandando mensaje al cliente");
            x = (String) in.readUTF();
            //System.out.println(x);
            
            res = x.toString();
            
                
            
          ObjectOutputStream ostream = new ObjectOutputStream(socket.getOutputStream());
          ostream.writeUTF(res);
          ostream.flush();
          socket.close();
          
        } catch (Exception e){
            System.err.println("Error al operar con el cliente");
        }
        
    } //run
    
    
} //client handler


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
    

    