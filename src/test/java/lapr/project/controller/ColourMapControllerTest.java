package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Country;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import lapr.project.utils.GraphGenerator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ColourMapControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of TopNController
     */
    ColourMapController colourMapController = new ColourMapController(company);

    /**
     * Creates an instance of GraphGenerator
     */
    GraphGenerator graphGenerator = new GraphGenerator();

    /**
     * Test the constructor and company association
     */
    @Test
    void ColourMapController() {
        Company company = App.getInstance().getCompany();

        ColourMapController colourMapController = new ColourMapController();

        assertEquals(company, colourMapController.getCompany());
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
    void colourMap(){
        List<Country> countryList = new ArrayList<>(); //Creates new List to be filled with countries from the file

        graphGenerator.importCountries(new File("Files/countries.csv"), countryList); //Imports the countries from the file

        graphGenerator.generateCapitalVertex(countryList); //Generates vertex for all capital from all countries

        graphGenerator.addEdgesFromBorders(new File("Files/borders.csv"), countryList); //Add new edges from the file

        graphGenerator.colourMap(countryList);

        List<Country> list1 = company.getCountryList();

        company.colourMap(countryList);

        List<Country> list2 = company.getCountryList();

        assertEquals(list1,list2);
    }

}