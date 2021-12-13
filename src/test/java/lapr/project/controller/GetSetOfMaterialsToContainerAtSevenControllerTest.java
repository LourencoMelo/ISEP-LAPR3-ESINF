package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetSetOfMaterialsToContainerAtSevenControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of GetSetOfMaterialsToContainerAtSevenController
     */
    GetSetOfMaterialsToContainerAtSevenController getSetOfMaterialsToContainerAtSevenController = new GetSetOfMaterialsToContainerAtSevenController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void GetSetOfMaterialsToContainerAtSevenController(){
        Company company = App.getInstance().getCompany();

        GetSetOfMaterialsToContainerAtSevenController getSetOfMaterialsToContainerAtSevenController = new GetSetOfMaterialsToContainerAtSevenController();

        assertEquals(company, getSetOfMaterialsToContainerAtSevenController.getCompany());
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
    void getSetOfMaterialsToContainerAtSevenController() {
        assertNull(getSetOfMaterialsToContainerAtSevenController.getSetOfMaterialsToContainerAtSevenController());
    }

}