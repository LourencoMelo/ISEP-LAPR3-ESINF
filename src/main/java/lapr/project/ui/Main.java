package lapr.project.ui;

import lapr.project.controller.ImportFileController;
import lapr.project.model.CalculatorExample;
import lapr.project.model.Company;
import lapr.project.utils.TreeOfShips;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
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
//        CalculatorExample calculatorExample = new CalculatorExample();
//        int value = calculatorExample.sum(3, 5);

//        if (LOGGER.isLoggable(Level.INFO)) {
//            LOGGER.log(Level.INFO, String.valueOf(value));
//        }

        ImportFileController importFileController = new ImportFileController();

        importFileController.import_ships(new File("Files/sships.csv"));

        System.out.println(importFileController.getTreeOfShips());

    }

    public Company getCompany() {
        return company;
    }
}

