package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopNControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of GetShipByCodeController
     */
    TopNController topNController = new TopNController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void TopNController() {
        Company company = App.getInstance().getCompany();

        TopNController topNController = new TopNController();

        assertEquals(company, topNController.getCompany());
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
    void GetTopShipsWithMostKmByVesselType() {

    }

    @Test
    void GetVesselTypes() {
        /*company.getTreeOfShips().createTreeMMSI(new File("Files/sships.csv"));



        assertEquals(,topNController.getVesselTypes());


         */
    }

}
