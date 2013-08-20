import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author PadronePavilion
 */
public interface RMIInterface extends Remote{
   
    //Nome del server
    public static final String SERVICE_NAME = "Hello";
    //Funzione saluto
    public String getHello() throws RemoteException;
    
    public byte[] downloadFile() throws RemoteException;
}