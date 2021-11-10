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


        Scanner in = new Scanner(System.in);

        System.out.println("What do you wanna run? Select one of the following options: ");
        System.out.println("1 - Import Ships from CSV file into a BST.");
        System.out.println("2 - Request ship detail by code (MMSI, IMO or Call Sign)");
        System.out.println("3 - Request ship position messages ordered by date(Please introduce a code)");
        System.out.println("5 - List for all ships the MMSI, the total number of movements, Travelled Distance and Delta Distance");

        String answer = "";

        while (!answer.equalsIgnoreCase("0")) {

            answer = in.next();

            switch (answer) {
                case "1" :
                    ImportFileUI importFileUI = new ImportFileUI();

                    ImportFileController importFileController = new ImportFileController();

                    importFileUI.import_ships();

                    System.out.println("\n\n\n\n\n\n\n\n");

                    //System.out.println(importFileController.getShipByMMSI(210950000));

                    break;
                case "2" :
                    GetShipByCodeUI getShipByCodeUI = new GetShipByCodeUI();

                    getShipByCodeUI.getShipByCode();
                    break;
                case "3" :
                    GetShipPositionByDateUI getShipPositionByDateUI = new GetShipPositionByDateUI();

                    getShipPositionByDateUI.getShipPositionMessagesOrderByDate();

                    break;
                case "4" :
                    TopNController topNController = new TopNController();

                    topNController.getTopShipsWithMostKm(LocalDateTime.of(2020, 12,31, 16, 04)
                            , LocalDateTime.of(2020, 12, 31, 16, 15),3);
                    break;
                case "5" :
                    MovementsTravelledAndDeltaDistanceUI movementsTravelledAndDeltaDistanceUI = new MovementsTravelledAndDeltaDistanceUI();

                    movementsTravelledAndDeltaDistanceUI.listMovementsTravelledAndDeltaDistance();

                    break;

                default:

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

