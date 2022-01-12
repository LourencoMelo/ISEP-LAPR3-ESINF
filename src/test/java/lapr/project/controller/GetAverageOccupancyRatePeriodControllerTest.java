package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class GetAverageOccupancyRatePeriodControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of GetInfoContainerController
     */
    GetAverageOccupancyRatePeriodController getAverageOccupancyRatePeriodController = new GetAverageOccupancyRatePeriodController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void GetAverageOccupancyRatePeriodController(){
        Company company = App.getInstance().getCompany();

        GetAverageOccupancyRatePeriodController getAverageOccupancyRatePeriodController = new GetAverageOccupancyRatePeriodController();

        assertEquals(company, getAverageOccupancyRatePeriodController.getCompany());
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
    void getAverageOccupancyRatePeriodController() {
        Ship ship = new ShipByMMSI(123000788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        LocalDateTime date1 = LocalDateTime.of(2020, 12,30,17,19);
        LocalDateTime date2 = LocalDateTime.of(2020, 12,30,18,29);

        assertEquals(0, getAverageOccupancyRatePeriodController.getAverageOccupancyRatePeriodController(ship, date1, date2));
    }
}