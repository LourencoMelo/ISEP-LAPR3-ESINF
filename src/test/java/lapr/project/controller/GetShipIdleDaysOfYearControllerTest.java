package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetShipIdleDaysOfYearControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of GetShipIdleDaysOfYearControllerTest
     */
    GetShipIdleDaysOfYearController getShipIdleDaysOfYearController = new GetShipIdleDaysOfYearController(company);


    /**
     * Test the constructor and company association
     */
    @Test
    void GetShipIdleDaysOfYearController() {
        Company company = App.getInstance().getCompany();

        GetShipIdleDaysOfYearController getShipIdleDaysOfYearController = new GetShipIdleDaysOfYearController();

        assertEquals(company, getShipIdleDaysOfYearController.getCompany());
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
     * Tests the method of getShipIdleDaysOfYearController
     */
    @Test
    void getShipIdleDaysOfYearController(){
        assertNull(getShipIdleDaysOfYearController.getShipIdleDaysOfYearController());
    }
}