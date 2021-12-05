package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class GetListContainerToBeLoadedControllerTest {
    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of GetShipByCodeController
     */
    GetListContainerToBeLoadedController getListContainerToBeLoadedController = new GetListContainerToBeLoadedController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void GetListContainerToBeLoadedController() {
        Company company = App.getInstance().getCompany();

        GetListContainerToBeLoadedController getListContainerToBeLoadedController = new GetListContainerToBeLoadedController();

        assertEquals(company, getListContainerToBeLoadedController.getCompany());
    }

    /**
     * Tests if the Company object gives the same result as the App
     */
    @Test
    void companyObjectVerifier() {
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        assertEquals(App.getInstance().getCompany().getShipPositionMessagesOrderByDate(shipTest), company.getShipPositionMessagesOrderByDate(shipTest));
    }

    @Test
    void GetListContainerToBeLoadedControllerTest() {
        assertEquals(Collections.emptyList(), getListContainerToBeLoadedController.getListContainerToBeLoaded());
    }

}