package lapr.project.model;

import lapr.project.controller.ImportFileController;
import lapr.project.controller.ImportPortsController;
import org.junit.jupiter.api.Test;


import javax.security.auth.callback.LanguageCallback;
import java.io.File;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    Company company = new Company();
    ImportFileController importFileController = new ImportFileController(company);
    ImportPortsController importPortsController = new ImportPortsController(company);

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

        assertTrue(company.closeDepartureArrival(shipTest1, shipTest2));
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


        assertFalse(company.closeDepartureArrival(shipTest1, shipTest2));
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

        assertFalse(company.closeDepartureArrival(shipTest1, shipTest2));
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

        assertFalse(company.closeDepartureArrival(shipTest1, shipTest2));
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

        assertFalse(company.closeDepartureArrival(shipTest1, shipTest2));
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

        assertFalse(company.closeDepartureArrival(shipTest1, shipTest2));
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

        assertFalse(company.closeDepartureArrival(shipTest1, shipTest2));
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
        importFileController.importShips(new File("Files/pairsTest.csv"));

        Boolean result = false;

        if(company.getPairShips().size() == 4) result = true;

        assertTrue(result);
    }

    @Test
    void getPairOfShipsTestOrder(){
        importFileController.importShips(new File("Files/pairsTest.csv"));
        List<Pair<Ship, Ship>> test = company.getPairShips();
        Boolean result = false;

        if(test.get(0).getFirst().getMMSI() > test.get(1).getFirst().getMMSI()){
            result = true;
        }

        assertTrue(result);
    }

    @Test
    void getPairOfShipsTestOrder2(){
        importFileController.importShips(new File("Files/pairsTest.csv"));
        List<Pair<Ship, Ship>> test = company.getPairShips();
        Boolean result = false;

        for(int i = 0; i < test.size() - 1; i ++) {
            int j = i + 1;
            if(test.get(i).getFirst().getMMSI() > test.get(j).getFirst().getMMSI()){
                result = true;
            }else if(test.get(i).getFirst().getMMSI() == test.get(j).getFirst().getMMSI()){
                result = false;
                if(company.travelDistanceDifference(test.get(i)) > company.travelDistanceDifference(test.get(j))){
                    result = true;
                }
            }
        }

        assertTrue(result);
    }

    @Test
    void getVesselType() {
        importFileController.importShips(new File("Files/pairsTest.csv"));

        List<Integer> expected = new ArrayList<>();
        expected.add(70);
        expected.add(80);
        expected.add(79);

        List<Integer>  result = company.getVesselTypes();
        assertEquals(expected,result);
    }


    @Test
    void getTopShipsWithMostKm() {
        LocalDateTime date1 = LocalDateTime.of(2020,12,31,10,0);
        LocalDateTime date2 = LocalDateTime.of(2020,12,31,22,30);

        importFileController.importShips(new File("Files/sships.csv"));

        Map<Ship, Double> expected = new LinkedHashMap<>();
        Ship shipTest1 = company.getTreeOfShips().getShipByMMSI(257881000);
        Ship shipTest2 = company.getTreeOfShips().getShipByMMSI(210950000);

        double mean1 = shipTest1.meanSOG(date1,date2);
        double mean2 = shipTest2.meanSOG(date1,date2);

        expected.put(shipTest1, mean1);
        expected.put(shipTest2, mean2);

        Map<Ship, Double> result = company.getTopShipsWithMostKmByVesselType(date1,date2,2,70);
        assertEquals(expected, result);
    }

    @Test
    void getTopShipsWithMostKm2() {
        LocalDateTime date1 = LocalDateTime.of(2020, 12, 31, 10, 0);
        LocalDateTime date2 = LocalDateTime.of(2020, 12, 31, 22, 30);
        List<Ship> testList = new ArrayList<>();

        importFileController.importShips(new File("Files/sships.csv"));
        Boolean result = false;

        Map<Ship, Double> map = company.getTopShipsWithMostKmByVesselType(date1,date2,3,70);
        for (Map.Entry<Ship, Double> topN : map.entrySet()) {
            testList.add(topN.getKey());
        }

        for(int i = 0; i < testList.size() - 1; i ++) {
            int j = i + 1;
            result = false;
            if(testList.get(i).getTreeOfPositionData().travelledDistanceBtDates(date1,date2) >  testList.get(j).getTreeOfPositionData().travelledDistanceBtDates(date1,date2)){
                result = true;
            }
        }

        assertTrue(result);

    }

    @Test
    void getPositionDataByCallSignAndDateTimeTest(){
        LocalDateTime date1 = LocalDateTime.of(2020, 12, 31, 16, 14);
        String callSignTest = "C4SQ2";
        importFileController.importShips(new File("Files/sships.csv"));

        LocalDateTime datetest1 = LocalDateTime.of(2020, 12,31,16,12);
        PositionData expected = new PositionData(datetest1,42.73879,-66.97726,13.4,3.4,357,"NA","B");

        PositionData result = company.getPositionDataByCallSignAndDateTime(callSignTest,date1);

        assertEquals(expected.getBaseDateTime(),result.getBaseDateTime());
    }

    @Test
    void getPositionDataByCallSignAndDateTimeTest2(){
        LocalDateTime date1 = LocalDateTime.of(2020, 12, 31, 0, 24);
        String callSignTest = "FLSU";
        importFileController.importShips(new File("Files/sships.csv"));

        LocalDateTime datetest1 = LocalDateTime.of(2020, 12,31,0,20);
        PositionData expected = new PositionData(datetest1,28.33263,-88.82491,11.8,129.5,131,"79","B");

        PositionData result = company.getPositionDataByCallSignAndDateTime(callSignTest,date1);

        assertEquals(expected.getBaseDateTime(),result.getBaseDateTime());
    }

    @Test
    void getPositionDataByCallSignAndDateTimeTest3(){
        LocalDateTime date1 = LocalDateTime.of(2020, 12, 30, 23, 55);
        String callSignTest = "FLSU";
        importFileController.importShips(new File("Files/sships.csv"));

        PositionData result = company.getPositionDataByCallSignAndDateTime(callSignTest,date1);

        assertNull(result);
    }

    @Test
    void getPositionDataByCallSignAndDateTimeTest4(){
        LocalDateTime date1 = LocalDateTime.of(2020, 12, 31, 19, 55);
        String callSignTest = "C4SQ2";
        importFileController.importShips(new File("Files/sships.csv"));

        LocalDateTime datetest1 = LocalDateTime.of(2020, 12,31,18,31);
        PositionData expected = new PositionData(datetest1,43.22513,-66.96725,11.7,5.5,355,"NA","B");

        PositionData result = company.getPositionDataByCallSignAndDateTime(callSignTest,date1);

        assertEquals(expected.getBaseDateTime(),result.getBaseDateTime());
    }

    @Test
    void getClosest1(){
        String callSignTest = "D4DD5";
        LocalDateTime dateTest = LocalDateTime.of(2020, 12, 31, 23, 45);

        importFileController.importShips(new File("Files/sships.csv"));
        importPortsController.importPorts(new File("Files/sports.csv"));

        try{
            company.getClosest(callSignTest,dateTest);
        }catch (Exception e){
            assertEquals("The data you inserted is illegible",e.getMessage());
        }
    }

    @Test
    void getClosest2(){
        String callSignTest = "5BBA4";
        LocalDateTime dateTest = LocalDateTime.of(2020, 12, 30, 23, 45);

        importFileController.importShips(new File("Files/sships.csv"));
        importPortsController.importPorts(new File("Files/sports.csv"));

        try{
            company.getClosest(callSignTest,dateTest);
        }catch (Exception e){
            assertEquals("The data you inserted is illegible",e.getMessage());
        }
    }

    @Test
    void getClosest3(){
        String callSignTest = "5BBA4";
        LocalDateTime dateTest = LocalDateTime.of(2020, 12, 31, 21, 49);

        importFileController.importShips(new File("Files/sships.csv"));
        importPortsController.importPorts(new File("Files/sports.csv"));

        String expected = "Cartagena";

        assertEquals(expected,company.getClosest(callSignTest,dateTest).getPort());
    }

    @Test
    void getClosest4(){
        String callSignTest = "FLSU";
        LocalDateTime dateTest = LocalDateTime.of(2020, 12, 31, 0, 17);

        importFileController.importShips(new File("Files/sships.csv"));
        importPortsController.importPorts(new File("Files/sports.csv"));

        String expected = "Cartagena";

        assertEquals(expected,company.getClosest(callSignTest,dateTest).getPort());
    }

    @Test
    void getClosest5(){
        String callSignTest = "C4SQ2";
        LocalDateTime dateTest = LocalDateTime.of(2020, 12, 31, 17, 07);

        importFileController.importShips(new File("Files/sships.csv"));
        importPortsController.importPorts(new File("Files/sports.csv"));

        String expected = "Halifax";

        assertEquals(expected,company.getClosest(callSignTest,dateTest).getPort());
    }








}