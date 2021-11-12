package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.PositionData;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ImportFileControllerTest {

    Company company = new Company();
    ImportFileController importFileController = new ImportFileController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void ImportFileController() {
        Company company = App.getInstance().getCompany();

        ImportFileController importFileController = new ImportFileController();

        assertEquals(company, importFileController.getCompany());
    }

    @Test
    void company_Object() {
        assertEquals(App.getInstance().getCompany().getTreeOfShips(), company.getTreeOfShips());
    }

    @Test
    void import_ships() {

        importFileController.import_ships(new File("Files/testImport.csv"));

        if (company.getTreeOfShips() != null && company.getTreeOfShipsIMO() != null && company.getTreeOfShipsCallSign() != null) {

            int size1 = company.getTreeOfShips().size();
            int size2 = company.getTreeOfShipsIMO().size();
            int size3 = company.getTreeOfShipsCallSign().size();

            assertTrue(size1 == 2 && size2 == 2 && size3 == 2);
        }

    }

    /**
     * Tests if the ships were imported to an avl tree in the correct order
     */
    @Test
    void createTreeByMMSI() {

        ShipByMMSI example_ship = new ShipByMMSI(210950000, "VARAMO", "IMO9395044", "C4SQ2", 70, 166, 25, 9.5);
        PositionData positionData = new PositionData(formatter("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "NA", "B");

        example_ship.addPositionData(positionData);

        company.getTreeOfShips().createTreeMMSI(new File("Files/testImport.csv"));

        assertEquals(2, company.getTreeOfShips().size());

        Iterator<Ship> shipIterator = company.getTreeOfShips().inOrder().iterator();

        Ship actual_ship = shipIterator.next();

        assertTrue(actual_ship.getMMSI() == example_ship.getMMSI()
                && actual_ship.getTreeOfPositionData().size() == example_ship.getTreeOfPositionData().size());


    }

    @Test
    void createTreeByIMO() {

        company.getTreeOfShipsIMO().createTreeIMO(new File("Files/testImport.csv"));

        assertEquals(2, company.getTreeOfShipsIMO().size());

        System.out.println(company.getTreeOfShipsIMO().inOrder());

        Iterator<Ship> iterator = company.getTreeOfShipsIMO().inOrder().iterator();


        assertEquals("IMO9395044", iterator.next().getIMO());
        assertEquals("IMO9643544", iterator.next().getIMO());

    }

    @Test
    void createTreeByCallSign() {

        company.getTreeOfShipsCallSign().createTreeCallSign(new File("Files/testImport.csv"));

        assertEquals(2, company.getTreeOfShipsCallSign().size());

        System.out.println(company.getTreeOfShipsCallSign().inOrder());

        Iterator<Ship> iterator = company.getTreeOfShipsCallSign().inOrder().iterator();


        assertEquals("5BBA4", iterator.next().getCallSign());
        assertEquals("C4SQ2", iterator.next().getCallSign());
    }

    @Test
    void getTreeOfShips() {

        String actualMMSI = importFileController.getTreeOfShips();
        String expectedMMSI = company.getTreeOfShips().toString();

        assertEquals(actualMMSI, expectedMMSI);

    }

    @Test
    void getTreeOfShips2() {

        String actualIMO = importFileController.getTreeOfShips2();
        String expectedIMO = company.getTreeOfShips().toString();

        assertEquals(actualIMO, expectedIMO);
    }

    @Test
    void getTreeOfShips3() {

        String actualCallSign = importFileController.getTreeOfShips3();
        String expectedCallSign = company.getTreeOfShipsCallSign().toString();

        assertEquals(actualCallSign, expectedCallSign);
    }

    @Test
    void getShipByMMSI() {

        company.getTreeOfShips().createTreeMMSI(new File("Files/testImport.csv"));

        assertEquals(importFileController.getShipByMMSI(210950000), company.getTreeOfShips().inOrder().iterator().next());

    }

    LocalDateTime formatter(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(str, formatter);
    }
}