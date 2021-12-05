package lapr.project.data;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class OccupancyRateByCargoManifest {

    CallableStatement myStm = null;
    DatabaseConnection databaseConnection = null;


    public OccupancyRateByCargoManifest() {
    }

    public void getOccupationRate(int MMSI, int cargo_id) throws SQLException {

        //Get a connection to database
        try {
            databaseConnection = ConnectionFactory.getInstance().getDatabaseConnection();


            assert databaseConnection != null;
            System.out.println("Connected to the database!");


            //Prepare the stored procedure call
            myStm = databaseConnection.getConnection().prepareCall("{call occupation_rate_cargo_manifest(?,?)}");

            //Set the parameters
            myStm.setInt(1, MMSI);
            myStm.setInt(1,cargo_id);

            //Call stored procedure
            System.out.println("\n\n Calling stored procedure. occupation_rate_cargo_manifest(" + MMSI + "," + cargo_id + ")");
            myStm.execute();
            System.out.println("Finished calling stored procedure.");


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
