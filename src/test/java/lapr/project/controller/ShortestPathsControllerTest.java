package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShortestPathsControllerTest {
    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of TopNController
     */
    ShortestPathsController shortestPathsController = new ShortestPathsController(company);

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

        ShortestPathsController shortestPathsController = new ShortestPathsController();

        assertEquals(company, shortestPathsController.getCompany());
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
    void getVerticesByNameTest(){
        ImportPortsController importPortsController = new ImportPortsController(company);

        importPortsController.importPorts(new File("Files/bports.csv")); //Imports all ports from file

        company.generateGraph(new File("Files/countries.csv"), new File("Files/borders.csv"), new File("Files/seadists.csv"), 3); //Generates graph

        String name = "Lisbon";

        assertEquals(shortestPathsController.getVerticesByName(name), company.getVerticesByName(name));
    }

    @Test
    void getShortestPathLand(){
        ImportPortsController importPortsController = new ImportPortsController(company);

        importPortsController.importPorts(new File("Files/bports.csv")); //Imports all ports from file

        company.generateGraph(new File("Files/countries.csv"), new File("Files/borders.csv"), new File("Files/seadists.csv"), 0); //Generates graph

        PortAndCapital lc1 = company.getVerticesByName("Setubal");
        PortAndCapital lc2 = company.getVerticesByName("Barcelona");

        assertEquals(shortestPathsController.closestLandPath(lc1,lc2),company.closestLandPath(lc1,lc2));
    }

    @Test
    void closestPathLandOrSea() {
        ImportPortsController importPortsController = new ImportPortsController(company);

        importPortsController.importPorts(new File("Files/bports.csv")); //Imports all ports from file

        company.generateGraph(new File("Files/countries.csv"), new File("Files/borders.csv"), new File("Files/seadists.csv"), 0); //Generates graph

        PortAndCapital lc1 = company.getVerticesByName("Ponta Delgada");
        PortAndCapital lc2 = company.getVerticesByName("Setubal");

        assertEquals(shortestPathsController.closestPathLandOrSea(lc1, lc2), company.closestPathLandOrSea(lc1, lc2));
    }

    @Test
    void closestPathSea() {
        ImportPortsController importPortsController = new ImportPortsController(company);

        importPortsController.importPorts(new File("Files/bports.csv")); //Imports all ports from file

        company.generateGraph(new File("Files/countries.csv"), new File("Files/borders.csv"), new File("Files/seadists.csv"), 0); //Generates graph

        PortAndCapital lc1 = company.getVerticesByName("Ponta Delgada");
        PortAndCapital lc2 = company.getVerticesByName("Setubal");

        assertEquals(shortestPathsController.closestPathMaritime((PortAndWareHouse) lc1,(PortAndWareHouse) lc2), company.closestPathMaritime((PortAndWareHouse)lc1,(PortAndWareHouse) lc2));
    }

    @Test
    void closestPathThroughNPoints() {
        ImportPortsController importPortsController = new ImportPortsController(company);

        importPortsController.importPorts(new File("Files/bports.csv")); //Imports all ports from file

        company.generateGraph(new File("Files/countries.csv"), new File("Files/borders.csv"), new File("Files/seadists.csv"), 1); //Generates graph

        List<PortAndCapital> listN = new LinkedList<>();

        PortAndCapital lc1 = company.getVerticesByName("Lisbon");
        PortAndCapital lc2 = company.getVerticesByName("Zagreb");

        listN.add(company.getVerticesByName("Paris"));
        listN.add(company.getVerticesByName("Berlin"));

        assertEquals(shortestPathsController.closestPathPassingThroughNPoint(lc1,lc2,listN), company.closestPathPassingThroughNPoint(lc1,lc2,listN));
    }

    @Test
    void isPortTest() {
        ImportPortsController importPortsController = new ImportPortsController(company);

        importPortsController.importPorts(new File("Files/bports.csv")); //Imports all ports from file

        company.generateGraph(new File("Files/countries.csv"), new File("Files/borders.csv"), new File("Files/seadists.csv"), 0); //Generates graph

        PortAndCapital test = company.getVerticesByName("Lisbon");

        assertEquals(shortestPathsController.isPort(test), company.isPort(test));
    }

}