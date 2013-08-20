
/**
 *
 * @author PadronePavilion
 */
public abstract class RMIStarter {
    public RMIStarter(Class<?> clazzToAddToServerCodebase) {
        //Classi del pacchetto comune che serviranno al server nel codebase
        System.setProperty("java.rmi.server.codebase", clazzToAddToServerCodebase.getProtectionDomain().getCodeSource().getLocation().toString());
        //Rintraccia la security policy
        System.setProperty("java.security.policy", PolicyFileLocator.getLocationOfPolicyFile());
        //Cerca il SecurityManager e lo crea se non esiste
        if(System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        
        doCustomRmiHandling();
    }

    /**
     * extend this class and do RMI handling here
     */
    public abstract void doCustomRmiHandling();
}