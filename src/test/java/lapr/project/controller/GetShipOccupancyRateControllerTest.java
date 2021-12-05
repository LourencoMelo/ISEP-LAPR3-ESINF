package lapr.project.controller;


import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


import static org.junit.jupiter.api.Assertions.*;

public class GetShipOccupancyRateControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of GetShipOccupancyRateController
     */
    GetShipOccupancyRateController getShipOccupancyRateController = new GetShipOccupancyRateController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void GetShipOccupancyRateController(){
        Company company = App.getInstance().getCompany();

        GetShipOccupancyRateController getShipOccupancyRateController = new GetShipOccupancyRateController();

        assertEquals(company, getShipOccupancyRateController.getCompany());
    }

    /**
     * Tests if the Company object gives the same result as the App /////// Needs to be changed in the future
     */
    @Test
    void CompanyObjectVerifier(){
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        assertEquals(App.getInstance().getCompany().getShipPositionMessagesOrderByDate(shipTest), company.getShipPositionMessagesOrderByDate(shipTest));
    }

    /**
     * Tests the last result of the controller
     */
    @Test
    void getShipOccupancyRateController(){
        int shipMMSI = 100000000;
        LocalDateTime date = LocalDateTime.of(2001, 10, 12, 12, 10);
        double result = 0.0;

        assertEquals(result, getShipOccupancyRateController.getShipOccupancyRateController(shipMMSI, date));

    }

}
