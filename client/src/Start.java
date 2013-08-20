


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author PadronePavilion
 */
public class Start {
    

    public static void main(String[] args) {
        try {
            //Rintraccia il registry attivo
            Registry registry = LocateRegistry.getRegistry();
            RMIInterface salutami = (RMIInterface)registry.lookup(RMIInterface.SERVICE_NAME);
            //lollo:BaseInterface server = (BaseInterface) Naming.lookup("rmi://127.0.0.1/Hello");
            
            //Richiama getHello dal server
            salutami.getHello();
            System.out.println("From server: " + salutami.getHello());
            
            byte[] ricevuto = salutami.downloadFile();
            File file = new File("Ricevuto.txt");
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file.getName()));
            output.write(ricevuto,0,ricevuto.length);
            output.flush();
            output.close();
            
        }
        catch(RemoteException e) {
            e.printStackTrace();
            
        }
        catch ( NotBoundException n){
        	
        	n.printStackTrace();
        	
        } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
        	
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			
		}
        
    }
}