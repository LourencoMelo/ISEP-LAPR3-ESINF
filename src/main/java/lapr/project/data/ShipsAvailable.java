package lapr.project.data;

import lapr.project.model.Ship;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ShipsAvailable {

    CallableStatement myStm = null;
    DatabaseConnection databaseConnection = null;


    public ShipsAvailable() {
    }

    public List<Ship> getShipsAvailable(String date) throws SQLException {

        //Get a connection to database
        try {
            databaseConnection = ConnectionFactory.getInstance().getDatabaseConnection();


            assert databaseConnection != null;
            System.out.println("Connected to the database!");


            //Prepare the stored procedure call
            myStm = databaseConnection.getConnection().prepareCall("{call ships_available(?)}");

            //Set the parameters
            myStm.setString(1, date);

            //Call stored procedure
            System.out.println("\n\n Calling stored procedure. ships_available(" + date + ")");
            myStm.execute();
            System.out.println("Finished calling stored procedure.");


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return Collections.emptyList();
    }
}
