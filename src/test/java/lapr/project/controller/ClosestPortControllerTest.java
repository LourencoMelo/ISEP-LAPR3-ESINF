package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ClosestPortControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of TopNController
     */
    ClosestPortController closestPortController = new ClosestPortController(company);

    /**
     * Creates an istance of ImportFileController
     */
    ImportFileController importFileController = new ImportFileController(company);

    /**
     * Creates an istance of ImportPort
     */
    ImportPortsController importPortsController = new ImportPortsController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void TopNController() {
        Company company = App.getInstance().getCompany();

        ClosestPortController closestPortController = new ClosestPortController();

        assertEquals(company, closestPortController.getCompany());
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
     * Tests method getClosest()
     */
    @Test
    void getClosest(){
        importFileController.importShips(new File("Files/sships.csv"));
        importPortsController.importPorts(new File("Files/sports.csv"));

        String callSignTest = "C4SQ2";
        LocalDateTime dateTest = LocalDateTime.of(2020, 12, 31, 17, 07);

        String port1 = closestPortController.getClosest(callSignTest,dateTest).getName();
        String port2 = company.getClosest(callSignTest,dateTest).getName();

        assertEquals(port1,port2);
    }




}