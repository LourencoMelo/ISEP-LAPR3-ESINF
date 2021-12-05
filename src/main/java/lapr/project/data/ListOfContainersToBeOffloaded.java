package lapr.project.data;

import lapr.project.model.Container;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ListOfContainersToBeOffloaded {

    CallableStatement myStm = null;
    DatabaseConnection databaseConnection = null;


    public ListOfContainersToBeOffloaded() {
    }

    public List<Container> getContainersList(String portID) throws SQLException {

        //Get a connection to database
        try {
            databaseConnection = ConnectionFactory.getInstance().getDatabaseConnection();


            assert databaseConnection != null;
            System.out.println("Connected to the database!");


            //Prepare the stored procedure call
            myStm = databaseConnection.getConnection().prepareCall("{call list_of_Containers(?)}");

            //Set the parameters
            myStm.setString(1, portID);

            //Call stored procedure
            System.out.println("\n\n Calling stored procedure. list_of_Containers('" + portID + ")");
            myStm.execute();
            System.out.println("Finished calling stored procedure.");


        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return Collections.emptyList();
    }

}
