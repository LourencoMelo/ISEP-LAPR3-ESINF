package lapr.project.ui;

import lapr.project.data.ConnectionFactory;
import lapr.project.data.DatabaseConnection;
import lapr.project.model.Company;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    private final Company company;

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

        DatabaseConnection databaseConnection = null;

        try {
            databaseConnection = ConnectionFactory.getInstance().getDatabaseConnection();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        assert databaseConnection != null;
        Connection connection = databaseConnection.getConnection();

        System.out.println("Connected to the database!");

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

