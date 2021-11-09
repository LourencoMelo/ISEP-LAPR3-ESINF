package lapr.project.ui;

import lapr.project.controller.ImportFileController;
import lapr.project.controller.TopNController;
import lapr.project.model.Company;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    /**
     * Logger class.
     */
    private static final Logger LOGGER = Logger.getLogger("MainLog");

    private Company company;

    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {
        this.company = new Company();
    }

    /**
     * Application main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {

        TopNController topNController = new TopNController();
        Scanner in = new Scanner(System.in);

        System.out.println("What do you wanna run? Select one of the following options: ");
        System.out.println("1 - Import Ships from CSV file into a BST.");
        System.out.println("2 - Request ship detail by code (MMSI, IMO or Call Sign)");

        String answer = "";

        while (!answer.equalsIgnoreCase("0")) {

            answer = in.next();

            if (answer.equalsIgnoreCase("1")) {

                ImportFileUI importFileUI = new ImportFileUI();

                ImportFileController importFileController = new ImportFileController();

                importFileUI.import_ships();

                System.out.println("\n\n\n\n\n\n\n\n");

                //System.out.println(importFileController.getShipByMMSI(210950000));


            } else if (answer.equalsIgnoreCase("2")) {

                GetShipByCodeUI getShipByCodeUI = new GetShipByCodeUI();

                getShipByCodeUI.getShipByCode();
            }

        }



//        if (LOGGER.isLoggable(Level.INFO)) {
//            LOGGER.log(Level.INFO, String.valueOf(value));
//        }



    }

    public Company getCompany() {
        return company;
    }
}

