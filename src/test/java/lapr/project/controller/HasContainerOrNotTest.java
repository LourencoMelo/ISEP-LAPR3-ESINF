package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.PositionData;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.ui.HasContainerOrNotUI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HasContainerOrNotTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of GetTotalNumberOccupiedSlotsController
     */
    HasContainerOrNotController hasContainerOrNotController = new HasContainerOrNotController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void HasContainerOrNotController(){
        Company company = App.getInstance().getCompany();

        HasContainerOrNotController hasContainerOrNotController = new HasContainerOrNotController();

        assertEquals(company, hasContainerOrNotController.getCompany());
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
    void hasContainerOrNot() {
        String callSign = null;
        int year = 2020;
        int month = 12;
        int dayOfMonth =4 ;
        int hour = 12;
        int minute = 32;
        double latitude = 0;
        double longitude = 0;
        double sog = 8;
        double cog = 9;
        double heading = 6;
        String position  = "x";
        String transceiver = "y";
        String containerId = "null";
        assertEquals(null, hasContainerOrNotController.hasContainerOrNot(callSign, new PositionData(LocalDateTime.of(year,month,dayOfMonth,hour,minute), latitude, longitude, sog, cog ,heading, position, transceiver), containerId));
    }
}
