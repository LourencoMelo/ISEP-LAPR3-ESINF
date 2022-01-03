package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.PositionData;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccessToInfoContainersOnShipTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of GetTotalNumberOccupiedSlotsController
     */
    AccessToInfoContainersOnShipController accessToInfoContainersOnShipController = new AccessToInfoContainersOnShipController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void HasContainerOrNotController(){
        Company company = App.getInstance().getCompany();

        AccessToInfoContainersOnShipController accessToInfoContainersOnShipController = new AccessToInfoContainersOnShipController();

        assertEquals(company, accessToInfoContainersOnShipController.getCompany());
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
    void accessToInfoContainersOnShip() {

        assertEquals(null, accessToInfoContainersOnShipController.accessToInfoContainersOnShip());
    }
}
