package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopNControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of TopNController
     */
    TopNController topNController = new TopNController(company);

    /**
     * Creates an istance of ImportFileController
     */
    ImportFileController importFileController = new ImportFileController(company);

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

    /**
     *Testing method getTopShipsWithMostKmByVesselType()
     */
    @Test
    void getTopShipsWithMostKmByVesselType() {
        importFileController.importShips(new File("Files/sships.csv"));
        Map<Ship, Double> map1 = topNController.getTopShipsWithMostKmByVesselType(LocalDateTime.of(2020,12,31,10,0), LocalDateTime.of(2020,12,31,22,30), 2, 70);
        Map<Ship, Double> map2 = company.getTopShipsWithMostKmByVesselType(LocalDateTime.of(2020,12,31,10,0), LocalDateTime.of(2020,12,31,22,30), 2, 70);

        assertEquals(map1, map2);
    }

    /**
     * Testing Controller method getVesselTypes
     */
    @Test
    void getVesselTypes() {
       assertEquals(topNController.getVesselTypes(), company.getVesselTypes());
    }

}
