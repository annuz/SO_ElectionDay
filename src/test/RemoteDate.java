package test;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;


public interface RemoteDate extends Remote {
	public Date getDate() throws RemoteException;
}
