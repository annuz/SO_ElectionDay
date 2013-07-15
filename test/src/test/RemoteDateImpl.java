package test;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;


@SuppressWarnings("serial")
public class RemoteDateImpl extends UnicastRemoteObject implements RemoteDate {

	protected RemoteDateImpl() throws RemoteException {
		super();
	}

	public static void main(String[] args) {
		
		 try {
	         java.rmi.registry.LocateRegistry.createRegistry(1099);
	         System.out.println("RMI registry ready.");
	      } catch (Exception e) {
	         System.out.println("Exception starting RMI registry:");
	         e.printStackTrace();
	      } 
		
		try {
			RemoteDate dateServer = new RemoteDateImpl();
			Naming.rebind("RMIDateObject", dateServer);
		} catch(Exception e) {
			
		}
	}

	@Override
	public Date getDate() throws RemoteException {
		return new Date();
	}

}
