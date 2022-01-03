package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OccupancyRateControllerTest {
    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of occupancyRateController
     */
    OccupancyRateController occupancyRateController = new OccupancyRateController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void RouteOfContainerController(){
        Company company = App.getInstance().getCompany();

        OccupancyRateController occupancyRateController = new OccupancyRateController();

        assertEquals(company, occupancyRateController.getCompany());
    }

    /**
     * Tests if the Company object gives the same result as the App /////// Needs to be changed in the future
     */
    @Test
    void companyObjectVerifier() {
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        assertEquals(App.getInstance().getCompany().getShipPositionMessagesOrderByDate(shipTest), company.getShipPositionMessagesOrderByDate(shipTest));
    }

    /**
     * Tests the last result of the controller
     */
    @Test
    void getSetOfMaterialsToContainerAtMinus5Controller() {
        assertNull(occupancyRateController.getOccupancyRate());
    }

}