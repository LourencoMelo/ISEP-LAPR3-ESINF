package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetListShipsAvailableMondayNextWeekControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of GetShipByCodeController
     */
    GetListShipsAvailableMondayNextWeekController getListShipsAvailableMondayNextWeekController = new GetListShipsAvailableMondayNextWeekController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void GetListShipsAvailableMondayNextWeekController() {
        Company company = App.getInstance().getCompany();

        GetListShipsAvailableMondayNextWeekController getListShipsAvailableMondayNextWeekController = new GetListShipsAvailableMondayNextWeekController();

        assertEquals(company, getListShipsAvailableMondayNextWeekController.getCompany());
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
    void getListShipsAvailableMondayNextWeekController() {
        assertEquals(Collections.emptyList(), getListShipsAvailableMondayNextWeekController.getListShipsAvailableMondayNextWeek());
    }

}
