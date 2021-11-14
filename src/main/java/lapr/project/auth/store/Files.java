package lapr.project.auth.store;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

public class Files {

    private Files(){

    }

    public static void writeToAFileAboutPasswords(String role, String email, String pass) {
        File log = new File("Files\\emails.txt");
        try {
            if (log.exists()) {

                log.delete();
            }
            log.createNewFile();
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append("Role : " + role + "\n Email : " + email + "\n Password : " + pass + "\n");
            out.close();
        } catch (IOException e) {
            Logger.getLogger("Could not Log!");
        }
    }

}
