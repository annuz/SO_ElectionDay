package test;

import java.rmi.Naming;


public class RMIClient {

	static final String server = "127.0.0.1";
	
	public static void main(String[] args) {
		try {
			String host = "rmi://" + server + "/RMIDateObject";
			RemoteDate dateServer = (RemoteDate) Naming.lookup(host);
			System.out.println(dateServer.getDate());
		} catch (Exception e) {
			
		}
		
	}

}
