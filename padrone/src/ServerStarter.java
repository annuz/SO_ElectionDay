
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author PadronePavilion
 */
public class ServerStarter extends RMIStarter {
    public ServerStarter() throws RemoteException {
		super(RMIInterface.class);
    }

    public static void main(String[] args) throws RemoteException {
    	new ServerStarter();
    }

    @Override
    public void doCustomRmiHandling() {
        
        try {
        	Registry registry = LocateRegistry.createRegistry(1099);
            //java.rmi.registry.LocateRegistry.createRegistry(1099);            
            System.out.println("RMI registry ready.");
            
            try{
                RMIInterface engine = new Server();
                RMIInterface engineStub = (RMIInterface)UnicastRemoteObject.exportObject(engine,0);        
                
                registry.rebind(RMIInterface.SERVICE_NAME, engineStub);
                } catch(Exception e){
                	
                }
            
        } catch (Exception e) {
            System.out.println("Exception starting RMI registry:");
            e.printStackTrace();
        }
        
        
    }
        
}