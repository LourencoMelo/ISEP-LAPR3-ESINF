package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class HowMuchShipSinkControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates instance of HowMuchShipSinkControllerTest
     */
    HowMuchShipSinkController howMuchShipSinkController = new HowMuchShipSinkController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void HowMuchShipSinkController(){
        Company company = App.getInstance().getCompany();

        HowMuchShipSinkController howMuchShipSinkController = new HowMuchShipSinkController();

        assertEquals(company, howMuchShipSinkController.getCompany());
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
     * Testing if the calculations are return in the same form
     * In the company and the respective controller
     */
    @Test
    void calculateTotalMassController() {
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        company.containerImport(new File("Files/containerFew.csv"), shipTest);

        assertEquals(company.calculateTotalMass(shipTest), howMuchShipSinkController.calculateTotalMassController(shipTest));
    }

    @Test
    void calculateDiffHeightsController() {
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        company.containerImport(new File("Files/containerFew.csv"), shipTest);

        assertEquals(company.calculateDiffHeights(shipTest, 5000.0, 3000.0, 1), howMuchShipSinkController.calculateDiffHeightsController(shipTest, 5000.0, 3000.0,1));
    }

    @Test
    void calculatePressureOnWaterController() {
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        company.containerImport(new File("Files/containerFew.csv"), shipTest);

        assertEquals(company.calculatePressureOnWater(shipTest,5000.0, 1), howMuchShipSinkController.calculatePressureOnWaterController(shipTest, 5000.0,1));
    }
}