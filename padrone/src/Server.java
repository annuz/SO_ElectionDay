

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.RemoteException;

/**
 *
 * @author PadronePavilion
 */
public class Server implements RMIInterface {
     // Classe server che riscrive il metodo per salutare il client.
    @Override
    public String getHello() throws RemoteException {
        System.out.println("Eseguo get...");
        return "Hello";
    }
    
    public byte[] downloadFile(){
    	try {
	    	File file = new File("C:/Users/PadronePavilion/Documents/workspace/padrone/src/Invio.txt");
	    	byte[] buffer = new byte[(int)file.length()];
	    	BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
	    	input.read(buffer,0,buffer.length);
	    	input.close();
	    	return(buffer);
    	} catch(Exception e){
	    	System.out.println("FileImpl: "+e.getMessage());
	    	e.printStackTrace();
	    	return(null);
    	}
    }
}