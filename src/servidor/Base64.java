/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;





/**
 *
 * @author cristhian
 */
public class Base64 {
    
     /**
* @param args
*/
    public static void main(String[] args) {
    
    
       Base64 base64 = new Base64();



/*----------------ARCHIVOS------------------*/
          File file = new File("C:\\archivo.txt");
          byte[] fileArray = new byte[(int) file.length()];
          InputStream inputStream;
          String encodedFile = "";
         
        try {
             inputStream = new FileInputStream(file);
              inputStream.read(fileArray);
                encodedFile = base64.encodeToString(fileArray);
                
        } catch (Exception e) {
            
              // Manejar Error
}
    System.out.println(encodedFile);
    
    
/*----------------CADENAS------------------*/
        String cadena = "Cadena";
        String encodedString = "";
        encodedString = base64.encodeToString(cadena.getBytes());
        System.out.println(encodedString);
}

    private String encodeToString(byte[] fileArray) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
