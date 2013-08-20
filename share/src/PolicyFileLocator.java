

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author PadronePavilion
 */
class PolicyFileLocator {
    public static final String POLICY_FILE_NAME = "/allow_all.policy";
    //Classe che cerca e crea se non esiste un file di policy per garantire l'accesso
    //a tutti i client, serve un file chiamato allow_all.policy nel pacchetto comune
    public static String getLocationOfPolicyFile() {
        try {
            File tempFile = File.createTempFile("comune", ".policy");
            InputStream is = PolicyFileLocator.class.getResourceAsStream(POLICY_FILE_NAME);
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            int read = 0;
            while((read = is.read()) != -1) {
                writer.write(read);
            }
            writer.close();
            tempFile.deleteOnExit();
            return tempFile.getAbsolutePath();
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Se true, file ok.
    public static void main(String[] args) {
        System.out.println(new File(getLocationOfPolicyFile()).exists());
    }
}