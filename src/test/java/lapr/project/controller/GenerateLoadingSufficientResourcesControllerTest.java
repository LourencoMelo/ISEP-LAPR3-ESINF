package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenerateLoadingSufficientResourcesControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of GenerateLoadingSufficientResourcesController
     */
    GenerateLoadingSufficientResourcesController generateLoadingSufficientResourcesController = new GenerateLoadingSufficientResourcesController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void GetInfoContainGenerateLoadingSufficientResourcesControllererController(){
        Company company = App.getInstance().getCompany();

        GenerateLoadingSufficientResourcesController generateLoadingSufficientResourcesController = new GenerateLoadingSufficientResourcesController();

        assertEquals(company, generateLoadingSufficientResourcesController.getCompany());
    }

    /**
     * Tests if the Company object gives the same result as the App /////// Needs to be changed in the future
     */
    @Test
    void companyObjectVerifier() {
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        assertEquals(App.getInstance().getCompany().getShipPositionMessagesOrderByDate(shipTest), company.getShipPositionMessagesOrderByDate(shipTest));
    }

    @Test
    void generateLoadingSufficientResourcesController() {
        assertNull(generateLoadingSufficientResourcesController.generateLoadingSufficientResourcesController());
    }

}