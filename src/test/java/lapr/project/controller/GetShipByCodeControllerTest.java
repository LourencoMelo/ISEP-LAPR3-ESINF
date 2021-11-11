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

import static org.junit.jupiter.api.Assertions.assertEquals;

class GetShipByCodeControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = App.getInstance().getCompany();

    /**
     * Creates an instance of GetShipByCodeController
     */
    GetShipByCodeController getShipByCodeController = new GetShipByCodeController(company);

    /**
     * Tests if the Company object gives the same result as the App
     */
    @Test
    void companyObjectVerifier() {
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        assertEquals(App.getInstance().getCompany().getShipPositionMessagesOrderByDate(shipTest), company.getShipPositionMessagesOrderByDate(shipTest));
    }


    @Test
    void getShipByCode() {

        company.getTreeOfShips().createTreeMMSI(new File("Files/testImport.csv"));
        company.getTreeOfShipsIMO().createTreeIMO(new File("Files/testImport.csv"));
        company.getTreeOfShipsCallSign().createTreeCallSign(new File("Files/testImport.csv"));

        Ship shipTest = company.getTreeOfShips().inOrder().iterator().next();
        Ship shipTest2 = company.getTreeOfShipsIMO().inOrder().iterator().next();
        Iterator<Ship> iterator = company.getTreeOfShipsCallSign().inOrder().iterator();
        iterator.next();
        Ship shipTest3 = iterator.next();

        PositionData positionDataTestCompare1 = new PositionData(formatter("31/12/2020 17:19"), 42.97875, -66.97001, 12.9, 13.1, 355, "NA", "B");

        shipTest.addPositionData(positionDataTestCompare1);

        assertEquals(shipTest, getShipByCodeController.getShipByCode("210950000"));
        assertEquals(shipTest2, getShipByCodeController.getShipByCode("IMO9395044"));
        assertEquals(shipTest3, getShipByCodeController.getShipByCode("C4SQ2"));
    }

    LocalDateTime formatter(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(str, formatter);
    }



}