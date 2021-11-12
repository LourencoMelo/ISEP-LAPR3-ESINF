package lapr.project.model;

import lapr.project.controller.ImportFileController;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    Company company = new Company();
    ImportFileController importFileController = new ImportFileController(company);

    @Test
    void printMovementsTravelledAndDeltaDistance() {
    }

    @Test
    void getTreeOfShips() {
    }

    @Test
    void getTreeOfShipsIMO() {
    }

    @Test
    void getTreeOfShipsCallSign() {
    }

    @Test
    void getTopShipsWithMostKmByVesselType() {
    }

    /**
     * Test to check the HashMap Return if its equal
     */
    @Test
    void getShipPositionMessagesOrderByDateYear() {
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);

        PositionData positionDataTestCompare1 = new PositionData(LocalDateTime.of(2012, 11, 8, 13, 39), 11, 2, 2, 2, 4, "1", "S1");
        PositionData positionDataTestCompare2 = new PositionData(LocalDateTime.of(2013, 11, 8, 13, 39), 12, 3, 3, 4, 5, "2", "S2");
        PositionData positionDataTestCompare3 = new PositionData(LocalDateTime.of(2014, 11, 8, 13, 39), 13, 5, 1, 2, 5, "3", "S3");
        PositionData positionDataTestCompare4 = new PositionData(LocalDateTime.of(2015, 11, 8, 13, 39), 14, 6, 1, 4, 5, "4", "S4");
        PositionData positionDataTestCompare5 = new PositionData(LocalDateTime.of(2016, 11,8,13,39),15,7,3,4,3,"5","S5");
        PositionData positionDataTestCompare6 = new PositionData(LocalDateTime.of(2017, 11,8,13,39),16,8,3,4,5,"6","S6");

        shipTest.addPositionData(positionDataTestCompare1);
        shipTest.addPositionData(positionDataTestCompare2);
        shipTest.addPositionData(positionDataTestCompare3);
        shipTest.addPositionData(positionDataTestCompare4);
        shipTest.addPositionData(positionDataTestCompare5);
        shipTest.addPositionData(positionDataTestCompare6);

        HashMap<Ship, Set<PositionData>> mapTest = new HashMap<>();
        Set<PositionData> setTest = new HashSet<>();
        setTest.add(positionDataTestCompare1);
        setTest.add(positionDataTestCompare2);
        setTest.add(positionDataTestCompare3);
        setTest.add(positionDataTestCompare4);
        setTest.add(positionDataTestCompare5);
        setTest.add(positionDataTestCompare6);
        mapTest.put(shipTest, setTest);

        assertEquals(mapTest, company.getShipPositionMessagesOrderByDate(shipTest));
    }

    //A pair of ships that passes all the requirements
    @Test
    void closeDepartureArrivalTest(){
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788","Pedro",2, 5.0, 3.0, 20.9);

        //Partida ship 1
        PositionData positionDataTestCompare1 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 39), 27.86118, -78.01013, 2, 2, 4, "1", "S1");
        //Partida Ship 2
        PositionData positionDataTestCompare2 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 38), 27.86100, -78.01016, 2, 2, 4, "1", "S1");
        // Chegada Ship 1
        PositionData positionDataTestCompare3 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 39), 30.52141, -80.54852, 3, 4, 5, "2", "S2");
        // Chegada Ship 2
        PositionData positionDataTestCompare4 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 38), 30.52143, -80.54854, 3, 4, 5, "2", "S2");

        shipTest1.addPositionData(positionDataTestCompare1);
        shipTest1.addPositionData(positionDataTestCompare3);
        shipTest2.addPositionData(positionDataTestCompare2);
        shipTest2.addPositionData(positionDataTestCompare4);

        assertEquals(true, company.closeDepartureArrival(shipTest1,shipTest2));
    }

    // Dont have close departure/arrival coordinates
    @Test
    void closeDepartureArrivalTest2(){
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788","Pedro",2, 5.0, 3.0, 20.9);

        //Partida ship 1
        PositionData positionDataTestCompare1 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 39), 40.86118, -80.01013, 2, 2, 4, "1", "S1");
        //Partida Ship 2
        PositionData positionDataTestCompare2 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 38), 27.86100, -78.01016, 2, 2, 4, "1", "S1");
        // Chegada Ship 1
        PositionData positionDataTestCompare3 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 39), 30.52141, -80.54852, 3, 4, 5, "2", "S2");
        // Chegada Ship 2
        PositionData positionDataTestCompare4 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 38), 30.52143, -80.54854, 3, 4, 5, "2", "S2");

        shipTest1.addPositionData(positionDataTestCompare1);
        shipTest1.addPositionData(positionDataTestCompare3);
        shipTest2.addPositionData(positionDataTestCompare2);
        shipTest2.addPositionData(positionDataTestCompare4);


        assertEquals(false, company.closeDepartureArrival(shipTest1,shipTest2));
    }

    // The ships aren't eligible because both have the same travelled distance
    @Test
    void closeDepartureArrivalTest3(){
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788","Pedro",2, 5.0, 3.0, 20.9);

        //Partida ship 1
        PositionData positionDataTestCompare1 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 39), 27.86118, -78.01013, 2, 2, 4, "1", "S1");
        //Partida Ship 2
        PositionData positionDataTestCompare2 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 38), 27.86118, -78.01013, 2, 2, 4, "1", "S1");
        // Chegada Ship 1
        PositionData positionDataTestCompare3 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 39), 30.52141, -80.54852, 3, 4, 5, "2", "S2");
        // Chegada Ship 2
        PositionData positionDataTestCompare4 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 38), 30.52141, -80.54852, 3, 4, 5, "2", "S2");

        shipTest1.addPositionData(positionDataTestCompare1);
        shipTest1.addPositionData(positionDataTestCompare3);
        shipTest2.addPositionData(positionDataTestCompare2);
        shipTest2.addPositionData(positionDataTestCompare4);

        assertEquals(false, company.closeDepartureArrival(shipTest1,shipTest2));
    }

    // The ships aren't eligible because they don´t have at least 10km travelled
    @Test
    void closeDepartureArrivalTest4(){
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788","Pedro",2, 5.0, 3.0, 20.9);

        //Partida ship 1
        PositionData positionDataTestCompare1 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 39), 27.86118, -78.01013, 2, 2, 4, "1", "S1");
        //Partida Ship 2
        PositionData positionDataTestCompare2 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 38), 27.86100, -78.01016, 2, 2, 4, "1", "S1");
        // Chegada Ship 1
        PositionData positionDataTestCompare3 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 39), 27.86120, -78.01015, 3, 4, 5, "2", "S2");
        // Chegada Ship 2
        PositionData positionDataTestCompare4 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 38), 27.86102, -78.01020, 3, 4, 5, "2", "S2");

        shipTest1.addPositionData(positionDataTestCompare1);
        shipTest1.addPositionData(positionDataTestCompare3);
        shipTest2.addPositionData(positionDataTestCompare2);
        shipTest2.addPositionData(positionDataTestCompare4);

        assertEquals(false, company.closeDepartureArrival(shipTest1,shipTest2));
    }

    //The ships have close departure but not arrival
    @Test
    void closeDepartureArrivalTest5(){
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788","Pedro",2, 5.0, 3.0, 20.9);

        //Partida ship 1
        PositionData positionDataTestCompare1 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 39), 27.86118, -78.01013, 2, 2, 4, "1", "S1");
        //Partida Ship 2
        PositionData positionDataTestCompare2 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 38), 27.86100, -78.01016, 2, 2, 4, "1", "S1");
        // Chegada Ship 1
        PositionData positionDataTestCompare3 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 39), 30.52141, -80.54852, 3, 4, 5, "2", "S2");
        // Chegada Ship 2
        PositionData positionDataTestCompare4 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 38), 40.52143, -81.54854, 3, 4, 5, "2", "S2");

        shipTest1.addPositionData(positionDataTestCompare1);
        shipTest1.addPositionData(positionDataTestCompare3);
        shipTest2.addPositionData(positionDataTestCompare2);
        shipTest2.addPositionData(positionDataTestCompare4);

        assertEquals(false, company.closeDepartureArrival(shipTest1,shipTest2));
    }

    //The pair has close arrival but not departure
    @Test
    void closeDepartureArrivalTest6(){
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788","Pedro",2, 5.0, 3.0, 20.9);

        //Partida ship 1
        PositionData positionDataTestCompare1 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 39), 27.86118, -78.01013, 2, 2, 4, "1", "S1");
        //Partida Ship 2
        PositionData positionDataTestCompare2 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 38), 30.86100, -80.01016, 2, 2, 4, "1", "S1");
        // Chegada Ship 1
        PositionData positionDataTestCompare3 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 39), 30.52141, -80.54852, 3, 4, 5, "2", "S2");
        // Chegada Ship 2
        PositionData positionDataTestCompare4 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 38), 30.52143, -80.54854, 3, 4, 5, "2", "S2");

        shipTest1.addPositionData(positionDataTestCompare1);
        shipTest1.addPositionData(positionDataTestCompare3);
        shipTest2.addPositionData(positionDataTestCompare2);
        shipTest2.addPositionData(positionDataTestCompare4);

        assertEquals(false, company.closeDepartureArrival(shipTest1,shipTest2));
    }

    // The ships aren't eligible because one of them don't have 10km travelled
    @Test
    void closeDepartureArrivalTest7(){
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788","Pedro",2, 5.0, 3.0, 20.9);

        //Partida ship 1
        PositionData positionDataTestCompare1 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 39), 27.86118, -78.01013, 2, 2, 4, "1", "S1");
        //Partida Ship 2
        PositionData positionDataTestCompare2 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 38), 27.86100, -78.01016, 2, 2, 4, "1", "S1");
        // Chegada Ship 1
        PositionData positionDataTestCompare3 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 39), 27.86120, -78.01015, 3, 4, 5, "2", "S2");
        // Chegada Ship 2
        PositionData positionDataTestCompare4 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 38), 27.86102, -78.01020, 3, 4, 5, "2", "S2");

        PositionData positionDataTestCompare5 = new PositionData(LocalDateTime.of(2021, 11, 8, 14, 38), 30.86102, -75.01020, 3, 4, 5, "2", "S2");

        shipTest1.addPositionData(positionDataTestCompare1);
        shipTest1.addPositionData(positionDataTestCompare5);
        shipTest1.addPositionData(positionDataTestCompare3);
        shipTest2.addPositionData(positionDataTestCompare2);
        shipTest2.addPositionData(positionDataTestCompare4);

        assertEquals(false, company.closeDepartureArrival(shipTest1,shipTest2));
    }

    @Test
    void travelDistanceDifferenceTest(){
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788","Pedro",2, 5.0, 3.0, 20.9);

        //Partida ship 1
        PositionData positionDataTestCompare1 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 39), 27.86118, -78.01013, 2, 2, 4, "1", "S1");
        //Partida Ship 2
        PositionData positionDataTestCompare2 = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 38), 27.86118, -78.01013, 2, 2, 4, "1", "S1");
        // Chegada Ship 1
        PositionData positionDataTestCompare3 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 39), 30.86120, -80.01015, 3, 4, 5, "2", "S2");
        // Chegada Ship 2
        PositionData positionDataTestCompare4 = new PositionData(LocalDateTime.of(2021, 11, 8, 16, 38), 31.86120, -81.01015, 3, 4, 5, "2", "S2");

        shipTest1.addPositionData(positionDataTestCompare1);
        shipTest1.addPositionData(positionDataTestCompare3);
        shipTest2.addPositionData(positionDataTestCompare2);
        shipTest2.addPositionData(positionDataTestCompare4);

        Pair<Ship, Ship> test = Pair.of(shipTest1,shipTest2);
        double expected = 144.7276176940785;
        double result = company.travelDistanceDifference(test);
        assertEquals(expected,result);
    }

    @Test
    void getPairShips(){
        importFileController.import_ships(new File("Files/pairsTest.csv"));

        Boolean result = false;

        if(company.getPairShips().size() == 2) result = true;

        assertTrue(result);
    }

    @Test
    void getVesselType() {
        importFileController.import_ships(new File("Files/pairsTest.csv"));

        List<Integer> expected = new ArrayList<>();
        expected.add(70);
        expected.add(80);
        expected.add(79);

        List<Integer>  result = company.getVesselTypes();
        assertEquals(expected,result);
    }



    @Test
    void getTopShipsWithMostKm() {
    }
}