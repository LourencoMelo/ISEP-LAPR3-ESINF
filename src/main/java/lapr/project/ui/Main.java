package lapr.project.ui;

import lapr.project.model.Company;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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

        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Do Login", new AuthUI()));
        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n===================================== Main Menu =====================================");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        }
        while (option != -1);

    }

    public Company getCompany() {
        return company;
    }
}

