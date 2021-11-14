package lapr.project.auth.store;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Files {

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
            System.out.println("COULD NOT LOG!!");
        }
    }

    public static void writeToAFileAboutTestValidation(String email, long testCode) {
        File log = new File("Files\\emails.txt");
        try {
            if (!log.exists()) {

                log.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            out.append("\n Email : " + email + "\n Your test : " + testCode + " is now available for you to check!\n");
            out.close();
        } catch (IOException e) {
            System.out.println("COULD NOT LOG!!");
        }
    }
}
