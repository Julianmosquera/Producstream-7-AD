
package producstream;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author julian
 */
public class Producstream {

   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Product po1=new Product("cod1","parafusos",3);
        Product po2=new Product("cod2","arandelas",4);
        Product po3=new Product();
        
        File ps = new File("/home/oracle/Documents/productos.txt");

        
        ps.createNewFile();
        DataOutputStream write= new DataOutputStream(new FileOutputStream (ps));
        write.writeUTF(po1.getCodigo());
        write.writeUTF(po1.getDescripcion());
        write.writeInt(po1.getPrezo());
        write.writeUTF(po2.getCodigo());
        write.writeUTF(po2.getDescripcion());
        write.writeInt(po2.getPrezo());
        
        write.close();
        
        
        DataInputStream leer=new DataInputStream(new FileInputStream (ps));
        po3.setCodigo(leer.readUTF());
        po3.setDescripcion(leer.readUTF());
        po3.setPrezo(leer.readInt());
        
        
        System.out.println(po3.getCodigo());
        System.out.println(po3.getDescripcion());
        System.out.println(po3.getPrezo());
    }
    
}
