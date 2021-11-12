package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Pair;
import lapr.project.model.Ship;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.io.File;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PairOfShipsControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    ImportFileController importFileController = new ImportFileController(company);

    /**
     * Creates an instance of PairOfShipController
     */
    PairOfShipsController pairOfShipsController = new PairOfShipsController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void PairOfShipsControllerTest(){
        Company company = App.getInstance().getCompany();

        PairOfShipsController pairOfShipsController = new PairOfShipsController();

        assertEquals(company, pairOfShipsController.getCompany());
    }

    /**
     * Tests if the Company object gives the same result as the App
     */
    @Test
    void companyObjectVerifier(){
        importFileController.importShips(new File("Files/pairsTest.csv"));

        Company company1 = App.getInstance().getCompany();

        assertEquals(App.getInstance().getCompany().getPairShips(), company1.getPairShips());
    }

    @Test
    void getPairShips() {
        importFileController.importShips(new File("Files/pairsTest.csv"));
        List<Pair<Ship, Ship>> list1 = pairOfShipsController.getPairShips();
        List<Pair<Ship, Ship>> list2 = company.getPairShips();

        assertEquals(list1.toString(), list2.toString());
    }
}