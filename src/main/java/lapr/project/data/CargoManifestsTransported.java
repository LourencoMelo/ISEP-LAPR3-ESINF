package lapr.project.data;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class CargoManifestsTransported {

    CallableStatement myStm = null;
    DatabaseConnection databaseConnection = null;


    public CargoManifestsTransported() {
    }

    public void getCargoManifestInfoByYear(int year) throws SQLException {

        //Get a connection to database
        try {
            databaseConnection = ConnectionFactory.getInstance().getDatabaseConnection();


            assert databaseConnection != null;
            System.out.println("Connected to the database!");


            //Prepare the stored procedure call
            myStm = databaseConnection.getConnection().prepareCall("{call cargo_manifests_by_year(?)}");

            //Set the parameters
            myStm.setInt(1, year);

            //Call stored procedure
            System.out.println("\n\n Calling stored procedure. cargo_manifests_by_year('" + year + ")");
            myStm.execute();
            System.out.println("Finished calling stored procedure.");


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
