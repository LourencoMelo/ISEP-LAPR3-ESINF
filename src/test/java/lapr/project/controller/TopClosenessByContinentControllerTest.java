package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.ui.TopClosenessByContinentUI;
import lapr.project.utils.App;
import lapr.project.utils.GraphGenerator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TopClosenessByContinentControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates instance of TopClosenessByContinentController
     */
    TopClosenessByContinentController topClosenessByContinentController = new TopClosenessByContinentController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void TopClosenessByContinentControllerTest(){
        Company company = App.getInstance().getCompany();

        TopClosenessByContinentController topClosenessByContinentController = new TopClosenessByContinentController();

        assertEquals(company, topClosenessByContinentController.getCompany());
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
    void topClosenessByContinentController() {
        List<Country> countryList = new ArrayList<>(); //Creates new List to be filled with countries from the file

        List<PortAndWareHouse> portList = new ArrayList<>();

        Company company = new Company();

        GraphGenerator graphGenerator = new GraphGenerator();

        company.getTreeOfPorts().generateKDTREEOfPorts(new File("Files/bports.csv"));

        graphGenerator.importCountries(new File("Files/countries.csv"), countryList); //Imports the countries from the file

        graphGenerator.generateCapitalVertex(countryList); //Generates vertex for all capital from all countries

        graphGenerator.addEdgesFromBorders(new File("Files/borders.csv"), countryList); //Add new edges from the file

        graphGenerator.colourMap(countryList);

        graphGenerator.importSeaDists(new File("Files/seadists.csv"),portList );

        Map<Double, PortAndCapital> lastMap = new LinkedHashMap<>();

        Capital capital1 = new Capital("Reykjavik", 64.15, -21.95, "Europe");
        Capital capital2 = new Capital("Dublin", 53.31666667, -6.233333, "Europe");

        lastMap.put(0.0, capital1);
        lastMap.put(10.07113308750532, capital2);

        assertEquals(company.getGraphGenerator().topClosenessByContinent(2,"Europe"), topClosenessByContinentController.topClosenessByContinentController(2, "Europe"));
    }

}