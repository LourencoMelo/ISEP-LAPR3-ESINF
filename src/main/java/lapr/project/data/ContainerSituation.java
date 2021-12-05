package lapr.project.data;


import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class ContainerSituation {


    CallableStatement myStm = null;
    DatabaseConnection databaseConnection = null;


    public void getCurrentSituation(String containerID, String dateFormatted) throws SQLException {

        //Get a connection to database
        try {
            databaseConnection = ConnectionFactory.getInstance().getDatabaseConnection();


            assert databaseConnection != null;
            System.out.println("Connected to the database!");


            //Prepare the stored procedure call
            myStm = databaseConnection.getConnection().prepareCall("{call location_by_container_id(?,?)}");

            //Set the parameters
            myStm.setString(1, containerID);
            myStm.setString(2, dateFormatted);

            //Call stored procedure
            System.out.println("\n\n Calling stored procedure. location_by_container_id('" + containerID + "'," + dateFormatted + ")");
            myStm.execute();
            System.out.println("Finished calling stored procedure.");


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
