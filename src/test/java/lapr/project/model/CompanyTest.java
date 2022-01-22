package lapr.project.model;

import lapr.project.controller.ImportFileController;
import lapr.project.controller.ImportPortsController;
import lapr.project.utils.graph.Edge;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    private static final String PATH_COUNTRIES_TEST = "Files/countries.csv";
    private static final String PATH_BORDERS_TEST = "Files/borders.csv";
    private static final String PATH_PORTS_TEST = "Files/bports.csv";
    private static final String PATH_SEADISTS_TEST = "Files/seadists.csv";

    private static final int NUMBER_OF_CLOSEST_PORTS = 4;

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
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        PositionData positionDataTestCompare1 = new PositionData(LocalDateTime.of(2012, 11, 8, 13, 39), 11, 2, 2, 2, 4, "1", "S1");
        PositionData positionDataTestCompare2 = new PositionData(LocalDateTime.of(2013, 11, 8, 13, 39), 12, 3, 3, 4, 5, "2", "S2");
        PositionData positionDataTestCompare3 = new PositionData(LocalDateTime.of(2014, 11, 8, 13, 39), 13, 5, 1, 2, 5, "3", "S3");
        PositionData positionDataTestCompare4 = new PositionData(LocalDateTime.of(2015, 11, 8, 13, 39), 14, 6, 1, 4, 5, "4", "S4");
        PositionData positionDataTestCompare5 = new PositionData(LocalDateTime.of(2016, 11, 8, 13, 39), 15, 7, 3, 4, 3, "5", "S5");
        PositionData positionDataTestCompare6 = new PositionData(LocalDateTime.of(2017, 11, 8, 13, 39), 16, 8, 3, 4, 5, "6", "S6");

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
    void closeDepartureArrivalTest() {
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788", "Pedro", 2, 5.0, 3.0, 20.9);

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
    void closeDepartureArrivalTest2() {
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788", "Pedro", 2, 5.0, 3.0, 20.9);

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
    void closeDepartureArrivalTest3() {
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788", "Pedro", 2, 5.0, 3.0, 20.9);

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
    void closeDepartureArrivalTest4() {
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788", "Pedro", 2, 5.0, 3.0, 20.9);

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
    void closeDepartureArrivalTest5() {
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788", "Pedro", 2, 5.0, 3.0, 20.9);

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
    void closeDepartureArrivalTest6() {
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788", "Pedro", 2, 5.0, 3.0, 20.9);

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
    void closeDepartureArrivalTest7() {
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788", "Pedro", 2, 5.0, 3.0, 20.9);

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
    void travelDistanceDifferenceTest() {
        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788", "Pedro", 2, 5.0, 3.0, 20.9);

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

        Pair<Ship, Ship> test = Pair.of(shipTest1, shipTest2);
        double expected = 144.7276176940785;
        double result = company.travelDistanceDifference(test);
        assertEquals(expected, result);
    }

    @Test
    void getPairShips() {
        importFileController.importShips(new File("Files/pairsTest.csv"));

        Boolean result = false;

        if (company.getPairShips().size() == 4) result = true;

        assertTrue(result);
    }

    @Test
    void getPairOfShipsTestOrder() {
        importFileController.importShips(new File("Files/pairsTest.csv"));
        List<Pair<Ship, Ship>> test = company.getPairShips();
        Boolean result = false;

        if (test.get(0).getFirst().getMMSI() > test.get(1).getFirst().getMMSI()) {
            result = true;
        }

        assertTrue(result);
    }

    @Test
    void getPairOfShipsTestOrder2() {
        importFileController.importShips(new File("Files/pairsTest.csv"));
        List<Pair<Ship, Ship>> test = company.getPairShips();
        Boolean result = false;

        for (int i = 0; i < test.size() - 1; i++) {
            int j = i + 1;
            if (test.get(i).getFirst().getMMSI() > test.get(j).getFirst().getMMSI()) {
                result = true;
            } else if (test.get(i).getFirst().getMMSI() == test.get(j).getFirst().getMMSI()) {
                result = false;
                if (company.travelDistanceDifference(test.get(i)) > company.travelDistanceDifference(test.get(j))) {
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

        List<Integer> result = company.getVesselTypes();
        assertEquals(expected, result);
    }


    @Test
    void getTopShipsWithMostKm() {
        LocalDateTime date1 = LocalDateTime.of(2020, 12, 31, 10, 0);
        LocalDateTime date2 = LocalDateTime.of(2020, 12, 31, 22, 30);

        importFileController.importShips(new File("Files/sships.csv"));

        Map<Ship, Double> expected = new LinkedHashMap<>();
        Ship shipTest1 = company.getTreeOfShips().getShipByMMSI(257881000);
        Ship shipTest2 = company.getTreeOfShips().getShipByMMSI(210950000);

        double mean1 = shipTest1.meanSOG(date1, date2);
        double mean2 = shipTest2.meanSOG(date1, date2);

        expected.put(shipTest1, mean1);
        expected.put(shipTest2, mean2);

        Map<Ship, Double> result = company.getTopShipsWithMostKmByVesselType(date1, date2, 2, 70);
        assertEquals(expected, result);
    }

    @Test
    void getTopShipsWithMostKm2() {
        LocalDateTime date1 = LocalDateTime.of(2020, 12, 31, 10, 0);
        LocalDateTime date2 = LocalDateTime.of(2020, 12, 31, 22, 30);
        List<Ship> testList = new ArrayList<>();

        importFileController.importShips(new File("Files/sships.csv"));
        Boolean result = false;

        Map<Ship, Double> map = company.getTopShipsWithMostKmByVesselType(date1, date2, 3, 70);
        for (Map.Entry<Ship, Double> topN : map.entrySet()) {
            testList.add(topN.getKey());
        }

        for (int i = 0; i < testList.size() - 1; i++) {
            int j = i + 1;
            result = false;
            if (testList.get(i).getTreeOfPositionData().travelledDistanceBtDates(date1, date2) > testList.get(j).getTreeOfPositionData().travelledDistanceBtDates(date1, date2)) {
                result = true;
            }
        }

        assertTrue(result);

    }

    @Test
    void getPositionDataByCallSignAndDateTimeTest() {
        LocalDateTime date1 = LocalDateTime.of(2020, 12, 31, 16, 14);
        String callSignTest = "C4SQ2";
        importFileController.importShips(new File("Files/sships.csv"));

        LocalDateTime datetest1 = LocalDateTime.of(2020, 12, 31, 16, 12);
        PositionData expected = new PositionData(datetest1, 42.73879, -66.97726, 13.4, 3.4, 357, "NA", "B");

        PositionData result = company.getPositionDataByCallSignAndDateTime(callSignTest, date1);

        assertEquals(expected.getBaseDateTime(), result.getBaseDateTime());
    }

    @Test
    void getPositionDataByCallSignAndDateTimeTest2() {
        LocalDateTime date1 = LocalDateTime.of(2020, 12, 31, 0, 24);
        String callSignTest = "FLSU";
        importFileController.importShips(new File("Files/sships.csv"));

        LocalDateTime datetest1 = LocalDateTime.of(2020, 12, 31, 0, 20);
        PositionData expected = new PositionData(datetest1, 28.33263, -88.82491, 11.8, 129.5, 131, "79", "B");

        PositionData result = company.getPositionDataByCallSignAndDateTime(callSignTest, date1);

        assertEquals(expected.getBaseDateTime(), result.getBaseDateTime());
    }

    @Test
    void getPositionDataByCallSignAndDateTimeTest3() {
        LocalDateTime date1 = LocalDateTime.of(2020, 12, 30, 23, 55);
        String callSignTest = "FLSU";
        importFileController.importShips(new File("Files/sships.csv"));

        PositionData result = company.getPositionDataByCallSignAndDateTime(callSignTest, date1);

        assertNull(result);
    }

    @Test
    void getPositionDataByCallSignAndDateTimeTest4() {
        LocalDateTime date1 = LocalDateTime.of(2020, 12, 31, 19, 55);
        String callSignTest = "C4SQ2";
        importFileController.importShips(new File("Files/sships.csv"));

        LocalDateTime datetest1 = LocalDateTime.of(2020, 12, 31, 18, 31);
        PositionData expected = new PositionData(datetest1, 43.22513, -66.96725, 11.7, 5.5, 355, "NA", "B");

        PositionData result = company.getPositionDataByCallSignAndDateTime(callSignTest, date1);

        assertEquals(expected.getBaseDateTime(), result.getBaseDateTime());
    }

    @Test
    void getClosest1() {
        String callSignTest = "D4DD5";
        LocalDateTime dateTest = LocalDateTime.of(2020, 12, 31, 23, 45);

        importFileController.importShips(new File("Files/sships.csv"));
        importPortsController.importPorts(new File("Files/sports.csv"));

        try {
            company.getClosest(callSignTest, dateTest);
        } catch (Exception e) {
            assertEquals("The data you inserted is illegible", e.getMessage());
        }
    }

    @Test
    void getClosest2() {
        String callSignTest = "5BBA4";
        LocalDateTime dateTest = LocalDateTime.of(2020, 12, 30, 23, 45);

        importFileController.importShips(new File("Files/sships.csv"));
        importPortsController.importPorts(new File("Files/sports.csv"));

        try {
            company.getClosest(callSignTest, dateTest);
        } catch (Exception e) {
            assertEquals("The data you inserted is illegible", e.getMessage());
        }
    }

    @Test
    void getClosest3() {
        String callSignTest = "5BBA4";
        LocalDateTime dateTest = LocalDateTime.of(2020, 12, 31, 21, 49);

        importFileController.importShips(new File("Files/sships.csv"));
        importPortsController.importPorts(new File("Files/sports.csv"));

        String expected = "Cartagena";

        assertEquals(expected, company.getClosest(callSignTest, dateTest).getName());
    }

    @Test
    void getClosest4() {
        String callSignTest = "FLSU";
        LocalDateTime dateTest = LocalDateTime.of(2020, 12, 31, 0, 17);

        importFileController.importShips(new File("Files/sships.csv"));
        importPortsController.importPorts(new File("Files/sports.csv"));

        String expected = "Cartagena";

        assertEquals(expected, company.getClosest(callSignTest, dateTest).getName());
    }

    @Test
    void getClosest5() {
        String callSignTest = "C4SQ2";
        LocalDateTime dateTest = LocalDateTime.of(2020, 12, 31, 17, 07);

        importFileController.importShips(new File("Files/sships.csv"));
        importPortsController.importPorts(new File("Files/sports.csv"));

        String expected = "Halifax";

        assertEquals(expected, company.getClosest(callSignTest, dateTest).getName());
    }

    @Test
    void generateGraphTest() {

        importPortsController.importPorts(new File(PATH_PORTS_TEST)); //Imports all porters from file

        company.generateGraph(new File(PATH_COUNTRIES_TEST), new File(PATH_BORDERS_TEST), new File(PATH_SEADISTS_TEST), NUMBER_OF_CLOSEST_PORTS); //Generates graph

        //Test for country list
        assertEquals(68, company.getCountryList().size());

        //Test for subTreeOfPorts

        //Test for Capital Vertices

        int capital_counter = 0;

        for (Object vertex : company.getGraphGenerator().getGraph().vertices()) {

            if (vertex instanceof Capital) capital_counter++;

        }

        assertEquals(68, capital_counter);

        //Test for edges between capitals with Borders

        int edges_between_capitals = 0;

        for (Edge<PortAndCapital, Double> edge : company.getGraphGenerator().getGraph().edges()) {

            if (edge.getVOrig() instanceof Capital && edge.getVDest() instanceof Capital) edges_between_capitals++;

        }

        assertEquals(238, edges_between_capitals);

        //Test for Edges between ports from the same country

        //Test for the edge between capital and closest port

        //Test for all edges
        //System.out.println(company.getGraphGenerator().getGraph().edges());

        //System.out.println(company.getGraphGenerator().getSeaDistancesMap());
        assertEquals(988, company.getGraphGenerator().getGraph().numEdges());

    }

    @Test
    void generateGraphTest2() {

        //Objects creation
        Capital capital1 = new Capital("Lisbon", 38.71666667, -9.133333, "Europe");
        Capital capital2 = new Capital("Madrid", 40.4, -3.683333, "Europe");
        Capital capital3 = new Capital("London", 51.5, -0.083333, "Europe");

        PortAndWareHouse portAndWareHouse1 = new PortAndWareHouse("Europe", "Portugal", 18476, "Ponta Delgada", 37.73333333, -25.66666667);
        PortAndWareHouse portAndWareHouse2 = new PortAndWareHouse("Europe", "Portugal", 23428, "Funchal", 32.65, -16.91666667);
        PortAndWareHouse portAndWareHouse3 = new PortAndWareHouse("Europe", "Spain", 17386, "Barcelona", 41.33333333, 2.166666667);
        PortAndWareHouse portAndWareHouse4 = new PortAndWareHouse("Europe", "Spain", 18937, "Valencia", 39.45, -0.3);
        PortAndWareHouse portAndWareHouse5 = new PortAndWareHouse("Europe", "United Kingdom", 29002, "Liverpool", 53.46666667, -3.033333333);

        Edge<PortAndCapital, Double> edge1 = new Edge<>(capital1, portAndWareHouse2, Distance.distance(capital1.getLatitude(), capital1.getLongitude(), portAndWareHouse2.getLatitude(), portAndWareHouse2.getLongitude()));
        Edge<PortAndCapital, Double> edge2 = new Edge<>(capital2, portAndWareHouse4, Distance.distance(capital2.getLatitude(), capital2.getLongitude(), portAndWareHouse4.getLatitude(), portAndWareHouse4.getLongitude()));
        Edge<PortAndCapital, Double> edge3 = new Edge<>(capital3, portAndWareHouse5, Distance.distance(capital3.getLatitude(), capital3.getLongitude(), portAndWareHouse5.getLatitude(), portAndWareHouse5.getLongitude()));

        Edge<PortAndCapital, Double> edge4 = new Edge<>(capital1, capital2, Distance.distance(capital1.getLatitude(), capital1.getLongitude(), capital2.getLatitude(), capital2.getLongitude()));
        Edge<PortAndCapital, Double> edge5 = new Edge<>(capital2, capital1, Distance.distance(capital2.getLatitude(), capital2.getLongitude(), capital1.getLatitude(), capital1.getLongitude()));

        Edge<PortAndCapital, Double> edge6 = new Edge<>(portAndWareHouse1, portAndWareHouse2, Distance.distance(portAndWareHouse1.getLatitude(), portAndWareHouse1.getLongitude(), portAndWareHouse2.getLatitude(), portAndWareHouse2.getLongitude()));
        Edge<PortAndCapital, Double> edge7 = new Edge<>(portAndWareHouse2, portAndWareHouse1, Distance.distance(portAndWareHouse2.getLatitude(), portAndWareHouse2.getLongitude(), portAndWareHouse1.getLatitude(), portAndWareHouse1.getLongitude()));
        Edge<PortAndCapital, Double> edge8 = new Edge<>(portAndWareHouse3, portAndWareHouse4, Distance.distance(portAndWareHouse3.getLatitude(), portAndWareHouse3.getLongitude(), portAndWareHouse4.getLatitude(), portAndWareHouse4.getLongitude()));
        Edge<PortAndCapital, Double> edge9 = new Edge<>(portAndWareHouse4, portAndWareHouse3, Distance.distance(portAndWareHouse4.getLatitude(), portAndWareHouse4.getLongitude(), portAndWareHouse3.getLatitude(), portAndWareHouse3.getLongitude()));

        SeaDist seaDist1 = new SeaDist(portAndWareHouse2, portAndWareHouse4, 995.0);
        SeaDist seaDist2 = new SeaDist(portAndWareHouse2, portAndWareHouse3, 1123.0);
        SeaDist seaDist3 = new SeaDist(portAndWareHouse2, portAndWareHouse5, 1429.0);

        SeaDist seaDist4 = new SeaDist(portAndWareHouse4, portAndWareHouse5, 1653.0);

        SeaDist seaDist5 = new SeaDist(portAndWareHouse3, portAndWareHouse4, 164.0);
        SeaDist seaDist6 = new SeaDist(portAndWareHouse3, portAndWareHouse5, 1781.0);

        SeaDist seaDist7 = new SeaDist(portAndWareHouse1, portAndWareHouse2, 530.0);
        SeaDist seaDist8 = new SeaDist(portAndWareHouse1, portAndWareHouse5, 1358.0);
        SeaDist seaDist9 = new SeaDist(portAndWareHouse1, portAndWareHouse4, 1369.0);
        SeaDist seaDist10 = new SeaDist(portAndWareHouse1, portAndWareHouse3, 1497.0);


        //Expected lists
        List<Capital> expectedCapitals = new ArrayList<>();
        List<PortAndWareHouse> expectedPorts = new ArrayList<>();
        List<Edge<PortAndCapital, Double>> expectedEdgesClosestPortToCapital = new ArrayList<>();
        List<Edge<PortAndCapital, Double>> expectedEdgesBetweenCapitals = new ArrayList<>();
        List<Edge<PortAndCapital, Double>> expectedEdgesBetweenPortsSameCountry = new ArrayList<>();
        Collection<SeaDist> collection1 = new ArrayList<>();
        Collection<SeaDist> collection2 = new ArrayList<>();
        Collection<SeaDist> collection3 = new ArrayList<>();
        Collection<SeaDist> collection4 = new ArrayList<>();
        Map<PortAndWareHouse, List<SeaDist>> expectedMap = new HashMap<>();


        //Actual lists
        ArrayList<Capital> actualCapitals = new ArrayList<>();
        ArrayList<PortAndWareHouse> actualPorts = new ArrayList<>();
        ArrayList<Edge<PortAndCapital, Double>> actualEdgesClosestPortToCapital = new ArrayList<>();
        ArrayList<Edge<PortAndCapital, Double>> actualEdgesBetweenCapitals = new ArrayList<>();
        ArrayList<Edge<PortAndCapital, Double>> actualEdgesBetweenPortsSameCountry = new ArrayList<>();


        //Expected filling
        expectedCapitals.add(capital1);
        expectedCapitals.add(capital2);
        expectedCapitals.add(capital3);

        expectedPorts.add(portAndWareHouse1);
        expectedPorts.add(portAndWareHouse2);
        expectedPorts.add(portAndWareHouse3);
        expectedPorts.add(portAndWareHouse4);
        expectedPorts.add(portAndWareHouse5);

        expectedEdgesClosestPortToCapital.add(edge1);
        expectedEdgesClosestPortToCapital.add(edge2);
        expectedEdgesClosestPortToCapital.add(edge3);

        expectedEdgesBetweenCapitals.add(edge4);
        expectedEdgesBetweenCapitals.add(edge5);

        expectedEdgesBetweenPortsSameCountry.add(edge6);
        expectedEdgesBetweenPortsSameCountry.add(edge7);
        expectedEdgesBetweenPortsSameCountry.add(edge8);
        expectedEdgesBetweenPortsSameCountry.add(edge9);

        collection1.add(seaDist1);
        collection1.add(seaDist2);
        collection1.add(seaDist3);

        collection2.add(seaDist4);

        collection3.add(seaDist5);
        collection3.add(seaDist6);

        collection4.add(seaDist7);
        collection4.add(seaDist8);
        collection4.add(seaDist9);
        collection4.add(seaDist10);

        importPortsController.importPorts(new File("Files/portsTest.csv")); //Imports all porters from file

        company.generateGraph(new File("Files/countriesTest2File.csv"), new File(PATH_BORDERS_TEST), new File(PATH_SEADISTS_TEST), 2); //Generates graph

        System.out.println(company.getGraphGenerator().getGraph().numEdges());

        /////////////////////////////////////////////////////////////////NUMBER_OF_CAPITALS TEST////////////////////////////////////////////////////////////////////////////////////////


        int capital_counter = 0;

        for (Object vertex : company.getGraphGenerator().getGraph().vertices()) {

            if (vertex instanceof Capital) {
                capital_counter++;
                actualCapitals.add((Capital) vertex);
            }

        }

        assertEquals(3, capital_counter); //Checks if the capital vertices number is correct
        assertTrue(expectedCapitals.containsAll(actualCapitals) && actualCapitals.containsAll(expectedCapitals)); //Checks if the content is the same

        /////////////////////////////////////////////////////////////////NUMBER_OF_PORTS TEST////////////////////////////////////////////////////////////////////////////////////////

        int ports_counter = 0;

        for (Object vertex : company.getGraphGenerator().getGraph().vertices()) {

            if (vertex instanceof PortAndWareHouse) {
                ports_counter++;
                actualPorts.add((PortAndWareHouse) vertex);
            }

        }

        assertEquals(5, ports_counter); //Checks if the capital vertices number is correct
        assertTrue(expectedPorts.containsAll(actualPorts) && actualPorts.containsAll(expectedPorts)); //Checks if the content is the same

        /////////////////////////////////////////////////////////////////NUMBER_OF_EDGES_PORTANDCAPITAL TEST////////////////////////////////////////////////////////////////////////////////////////


        int edges_portCapital_counter = 0;

        for (Edge<PortAndCapital, Double> edge : company.getGraphGenerator().getGraph().edges()) {
            if (edge.getVOrig() instanceof Capital && edge.getVDest() instanceof PortAndWareHouse) {
                edges_portCapital_counter++;
                actualEdgesClosestPortToCapital.add(edge);
            }
        }

        assertEquals(3, edges_portCapital_counter);
        assertTrue(expectedEdgesClosestPortToCapital.containsAll(actualEdgesClosestPortToCapital) && actualEdgesClosestPortToCapital.containsAll(expectedEdgesClosestPortToCapital));

        /////////////////////////////////////////////////////////////////NUMBER_OF_EDGES_BETWEENCAPITALS TEST////////////////////////////////////////////////////////////////////////////////////////

        int edges_betweentCapitals_counter = 0;

        for (Edge<PortAndCapital, Double> edge : company.getGraphGenerator().getGraph().edges()) {
            if (edge.getVOrig() instanceof Capital && edge.getVDest() instanceof Capital) {
                edges_betweentCapitals_counter++;
                actualEdgesBetweenCapitals.add(edge);
            }
        }

        assertEquals(2, edges_betweentCapitals_counter);
        assertTrue(expectedEdgesBetweenCapitals.containsAll(actualEdgesBetweenCapitals) && actualEdgesBetweenCapitals.containsAll(expectedEdgesBetweenCapitals));

        /////////////////////////////////////////////////////////////////NUMBER_OF_EDGES_BETWEEN PORTS SAME COUNTRY TEST////////////////////////////////////////////////////////////////////////////////////////

        int edges_between_ports_same_country = 0;

        for (Edge<PortAndCapital, Double> edge : company.getGraphGenerator().getGraph().edges()) {
            if (edge.getVOrig() instanceof PortAndWareHouse && edge.getVDest() instanceof PortAndWareHouse) {

                String country1 = ((PortAndWareHouse) edge.getVOrig()).getCountry();
                String country2 = ((PortAndWareHouse) edge.getVDest()).getCountry();

                if (country1.equalsIgnoreCase(country2)) {
                    edges_between_ports_same_country++;
                    actualEdgesBetweenPortsSameCountry.add(edge);
                }
            }
        }

        assertEquals(4, edges_between_ports_same_country);
        assertTrue(expectedEdgesBetweenPortsSameCountry.containsAll(actualEdgesBetweenPortsSameCountry) && actualEdgesBetweenPortsSameCountry.containsAll(expectedEdgesBetweenPortsSameCountry));

        /////////////////////////////////////////////////////////////////NUMBER_OF_EDGES_BETWEEN N CLOSEST PORTS ////////////////////////////////////////////////////////////////////////////////////////

        expectedMap.put(portAndWareHouse1, new ArrayList<>(collection4));
        expectedMap.put(portAndWareHouse2, new ArrayList<>(collection1));
        expectedMap.put(portAndWareHouse4, new ArrayList<>(collection2));
        expectedMap.put(portAndWareHouse3, new ArrayList<>(collection3));

        expectedMap.values().forEach(Collections::sort);

        //**************


        List<Integer> expectedPortsID = new ArrayList<>();
        List<Integer> actualPortsID = new ArrayList<>();

        for (PortAndWareHouse portAndWareHouse : expectedMap.keySet()) {
            expectedPortsID.add(portAndWareHouse.getCode());
        }

        for (PortAndWareHouse portAndWareHouse : company.getGraphGenerator().getSeaDistancesMap().keySet()) {
            actualPortsID.add(portAndWareHouse.getCode());
        }

        Collection<List<SeaDist>> expectedLists = expectedMap.values();
        Collection<List<SeaDist>> actualLists = company.getGraphGenerator().getSeaDistancesMap().values();


        assertTrue(expectedPortsID.containsAll(actualPortsID) && actualPortsID.containsAll(expectedPortsID));

        assertTrue(expectedLists.containsAll(actualLists) && actualLists.containsAll(expectedLists));
    }

    @Test
    void nBiggerThanPortsExistent() {

        importPortsController.importPorts(new File("Files/bports.csv")); //Imports all ports from file

        company.generateGraph(new File("Files/countries.csv"), new File("Files/borders.csv"), new File("Files/seadists.csv"), 0); //Generates graph

        assertEquals(77, company.getGraphGenerator().listOfNPortsCentrality(300).size());

    }

    @Test
    void centralityTest() {

        Company company1 = new Company();
        ImportPortsController importPortsController = new ImportPortsController(company1);

        importPortsController.importPorts(new File("Files/portsTest.csv")); //Imports all ports from file

        company1.generateGraph(new File("Files/us303countries.csv"), new File("Files/us303borders.csv"), new File("Files/us303seadists.csv"), 0); //Generates graph

        Map<PortAndWareHouse, Integer> expected_map = new LinkedHashMap<>(); //Map with expected results

        PortAndWareHouse portAndWareHouse1 = new PortAndWareHouse("Europe","Portugal",18476,"Ponta Delgada",37.73333333,-25.66666667);
        PortAndWareHouse portAndWareHouse2 = new PortAndWareHouse("Europe","Portugal",23428,"Funchal",32.65,-16.91666667);
        PortAndWareHouse portAndWareHouse3 = new PortAndWareHouse("Europe","Spain",17386,"Barcelona",41.33333333,2.166666667);
        PortAndWareHouse portAndWareHouse4 = new PortAndWareHouse("Europe","Spain",18937,"Valencia",39.45,-0.3);

        expected_map.put(portAndWareHouse4, 19);
        expected_map.put(portAndWareHouse2, 19);
        expected_map.put(portAndWareHouse1, 11);
        expected_map.put(portAndWareHouse3, 11);

        assertEquals(expected_map.toString(), company1.getGraphGenerator().listOfNPortsCentrality(4).toString());
    }

    @Test
    void fileErrorsImportingContainers(){
        String expected = "File Not Found!";
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        try{
            company.containerImport(new File("error"), shipTest);
        }catch (Exception e){
            assertEquals(expected, e.getMessage());
        }

        try{
            company.containerImport(new File("Files/containerError.csv"), shipTest);
        }catch (IllegalArgumentException illegalArgumentException){
            assertEquals(expected, illegalArgumentException.getMessage());
        }

    }

    /**
     *==================   US 419 & US 420 =====================
     */

    /**
     * Tests if the Containres are correctly imported
     */
    @Test
    void fileImportingContainers(){
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        company.containerImport(new File("Files/containerFew.csv"), shipTest);
        String expected = "[Container{containerID='74272480223', checkDigit=3, iso='4309', gross=30480, tare=3697, payload=6958, maxVolume=2, repairRecommendation=10}, Container{containerID='83410851157', checkDigit=7, iso='4056', gross=30480, tare=3528, payload=22146, maxVolume=1, repairRecommendation=1}, Container{containerID='41154073316', checkDigit=6, iso='4776', gross=30480, tare=3312, payload=16219, maxVolume=2, repairRecommendation=5}, Container{containerID='33221151821', checkDigit=1, iso='8860', gross=30480, tare=3348, payload=21889, maxVolume=1, repairRecommendation=1}, Container{containerID='94277554381', checkDigit=1, iso='3206', gross=30480, tare=2606, payload=17660, maxVolume=1, repairRecommendation=2}, Container{containerID='67374762847', checkDigit=7, iso='8363', gross=30480, tare=3168, payload=12183, maxVolume=2, repairRecommendation=7}, Container{containerID='26610961779', checkDigit=9, iso='2379', gross=30480, tare=3718, payload=25135, maxVolume=1, repairRecommendation=2}, Container{containerID='45609614550', checkDigit=0, iso='8433', gross=30480, tare=2745, payload=16059, maxVolume=2, repairRecommendation=8}, Container{containerID='52284563239', checkDigit=9, iso='8822', gross=30480, tare=3361, payload=13769, maxVolume=2, repairRecommendation=5}, Container{containerID='60675276575', checkDigit=5, iso='4967', gross=30480, tare=3007, payload=44, maxVolume=1, repairRecommendation=10}]";

        assertEquals(expected, shipTest.getLinkedListContainers().toString());
    }

    /**
     * Testing if the matrix values are the same
     */
    @Test
    void allocatingContainers(){
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        company.containerImport(new File("Files/containerFew.csv"), shipTest);

        Map<Integer, double[][]> matrixLevelsTest = new LinkedHashMap<>();

        double matrix[][] = new double[5][3];

        matrix[0][0] = 10655.0;
        matrix[0][1] = 25674.0;
        matrix[0][2] = 19531.0;
        matrix[1][0] = 25237.0;
        matrix[1][1] = 20266.0;
        matrix[1][2] = 15351.0;
        matrix[2][0] = 28853.0;
        matrix[2][1] = 18804.0;
        matrix[2][2] = 17130.0;
        matrix[3][0] = 3051.0;
        matrix[3][1] = 0.0;
        matrix[3][2] = 0.0;
        matrix[4][0] = 0.0;
        matrix[4][1] = 0.0;
        matrix[4][2] = 0.0;

        matrixLevelsTest.put(0,matrix);

        Map<Integer, double[][]> matrixLevelsCompany = company.allocatingContainers(shipTest);

        for(Map.Entry<Integer, double[][]> mapObject : matrixLevelsCompany.entrySet()){
            double matrixTest[][] = mapObject.getValue();
            for(int i = 0; i <5; i++){
                for(int j = 0; j < 3; j++){
                    assertEquals(matrix[i][j], matrixTest[i][j]);
                }
            }
        }
    }

    /**
     * Testing Calculating Center Gravity
     */
    @Test
    void calculateCenterGravity(){
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        company.containerImport(new File("Files/containerFew.csv"), shipTest);

        Map<Integer, double[][]> matrixLevelsCompany = company.allocatingContainers(shipTest);

        List<Double> list = new ArrayList<>();
        list.add(-0.08552603060384065);
        list.add(0.918564957302007);

        assertEquals(list.toString(), company.calculateCenterGravity(shipTest, matrixLevelsCompany).toString());
    }

    /**
     * Testing
     */
    @Test
    void showCenterOfGravity(){
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        company.containerImport(new File("Files/containerFew.csv"), shipTest);

        Map<Integer, double[][]> matrixLevelsCompany = company.allocatingContainers(shipTest);

        Map<List<Double>, String[][]> mapTest = new HashMap<>();

        List<Double> list = new ArrayList<>();
        list.add(-0.08552603060384065);
        list.add(0.918564957302007);

        int length = (int) shipTest.getLength();
        int width = (int) shipTest.getWidth();

        String[][] matrixTest = new String[length][width];
        for(String[] row : matrixTest){
            Arrays.fill(row, "0");
        }

        matrixTest[1][1] = "X";

        Map<List<Double>, String[][]> mapCompany = company.showCenterOfGravity(shipTest, matrixLevelsCompany);
        String[][] matrixCompany = mapCompany.get(list);

        //Checking if the lists are equal
        for(List<Double> keyTest : mapTest.keySet()){
            for(List<Double> keyCompany : mapCompany.keySet()){
                assertEquals(keyTest, keyCompany);
            }
        }

        //Checking if the matrix are equal
        for(int i = 0 ; i < length; i++){
            for(int j = 0; j < width; j++){
                assertEquals(matrixTest[i][j], matrixCompany[i][j]);
            }
        }

    }

    /**
     * Calculates the total Mass of the ship when has the containers
     */
    @Test
    void calculateTotalMass(){
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        company.containerImport(new File("Files/containerFew.csv"), shipTest);

        double expected = 5000;

        assertEquals(expected, company.calculateTotalMass(shipTest));
    }

    /**
     * Calculates the height Difference when the containers are loaded
     * Compared with they are not loaded
     */
    @Test
    void calculateHeightDifference(){
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        company.containerImport(new File("Files/containerFew.csv"), shipTest);

        double diff = -0.5745674504759337;

        double diff1 = -0.5819888974716112;

        assertEquals(diff, company.calculateDiffHeights(shipTest,5000.0,3000.0,1));
        assertEquals(diff1, company.calculateDiffHeights(shipTest,5000.0,3000.0,2));
    }

    @Test
    void calculatePressureOnWater(){
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        company.containerImport(new File("Files/containerFew.csv"), shipTest);

        double pressure = 1715.5466653814824;
        double pressure1 = 1692.1785319900937;

        assertEquals(pressure, company.calculatePressureOnWater(shipTest,5000.0,1));
        assertEquals(pressure1, company.calculatePressureOnWater(shipTest,5000.0,2));

    }

    /////////////////////////////////// LAND SHORTEST PATHS TESTS

    @Test
    void shortestLandPath(){
        Company company1 = new Company();
        ImportPortsController importPortsController = new ImportPortsController(company1);

        importPortsController.importPorts(new File("Files/bports.csv")); //Imports all ports from file

        company1.generateGraph(new File("Files/countries.csv"), new File("Files/borders.csv"), new File("Files/seadists.csv"), 0); //Generates graph

        PortAndCapital lc1 = company1.getVerticesByName("Setubal");
        PortAndCapital lc2 = company1.getVerticesByName("Barcelona");

        List<PortAndCapital> actual = new LinkedList<PortAndCapital>();
        List<PortAndCapital> expected = new LinkedList<>();

        expected.add(lc1);
        expected.add(company1.getVerticesByName("Lisbon"));
        expected.add(company1.getVerticesByName("Madrid"));
        expected.add(company1.getVerticesByName("Valencia"));
        expected.add(lc2);

        actual = company1.closestPathLandOrSea(lc1,lc2);

        assertEquals(expected,actual);
    }

    @Test
    void shortestLandPath2(){
        Company company1 = new Company();
        ImportPortsController importPortsController = new ImportPortsController(company1);

        importPortsController.importPorts(new File("Files/bports.csv")); //Imports all ports from file

        company1.generateGraph(new File("Files/countries.csv"), new File("Files/borders.csv"), new File("Files/seadists.csv"), 0); //Generates graph

        PortAndCapital lc1 = company1.getVerticesByName("Valletta");
        PortAndCapital lc2 = company1.getVerticesByName("Barcelona");

        List<PortAndCapital> actual = new LinkedList<PortAndCapital>();
        List<PortAndCapital> expected = new LinkedList<>();

        actual = company1.closestPathLandOrSea(lc1,lc2);

        assertEquals(expected,actual);
    }

    @Test
    void shortestLandPath3() {

        Company company1 = new Company();
        ImportPortsController importPortsController = new ImportPortsController(company1);

        importPortsController.importPorts(new File("Files/bports.csv")); //Imports all ports from file

        company1.generateGraph(new File("Files/countries.csv"), new File("Files/borders.csv"), new File("Files/seadists.csv"), 0); //Generates graph

        PortAndCapital lc1 = company1.getVerticesByName("Lisbon");
        PortAndCapital lc2 = company1.getVerticesByName("Rome");

        List<PortAndCapital> actual = new LinkedList<PortAndCapital>();
        List<PortAndCapital> expected = new LinkedList<>();

        expected.add(lc1);
        expected.add(company1.getVerticesByName("Madrid"));
        expected.add(company1.getVerticesByName("Paris"));
        expected.add(lc2);

        actual = company1.closestLandPath(lc1, lc2);

        assertEquals(expected, actual);
    }

    /////////////////////// LAND OR SEA PATHS TESTS

    @Test
    void closestPathLandOrSea(){
        Company company1 = new Company();
        ImportPortsController importPortsController = new ImportPortsController(company1);

        importPortsController.importPorts(new File("Files/bports.csv")); //Imports all ports from file

        company1.generateGraph(new File("Files/countries.csv"), new File("Files/borders.csv"), new File("Files/seadists.csv"), 0); //Generates graph

        PortAndCapital lc1 = company1.getVerticesByName("Ponta Delgada");
        PortAndCapital lc2 = company1.getVerticesByName("Setubal");

        List<PortAndCapital> actual = new LinkedList<PortAndCapital>();
        List<PortAndCapital> expected = new LinkedList<>();

        expected.add(lc1);
        expected.add(lc2);

        actual = company1.closestPathLandOrSea(lc1,lc2);

        assertEquals(expected,actual);
    }

    @Test
    void closestPathLandOrSea2(){
        Company company1 = new Company();
        ImportPortsController importPortsController = new ImportPortsController(company1);

        importPortsController.importPorts(new File("Files/bports.csv")); //Imports all ports from file

        company1.generateGraph(new File("Files/countries.csv"), new File("Files/borders.csv"), new File("Files/seadists.csv"), 0); //Generates graph

        PortAndCapital lc1 = company1.getVerticesByName("Rome");
        PortAndCapital lc2 = company1.getVerticesByName("Setubal");

        List<PortAndCapital> actual = new LinkedList<PortAndCapital>();
        List<PortAndCapital> expected = new LinkedList<>();

        expected.add(lc1);
        expected.add(company1.getVerticesByName("Paris"));
        expected.add(company1.getVerticesByName("Madrid"));
        expected.add(company1.getVerticesByName("Lisbon"));
        expected.add(lc2);

        actual = company1.closestPathLandOrSea(lc1,lc2);

        assertEquals(expected,actual);
    }

    @Test
    void closestPathLandOrSea3(){
        Company company1 = new Company();
        ImportPortsController importPortsController = new ImportPortsController(company1);

        importPortsController.importPorts(new File("Files/bports.csv")); //Imports all ports from file

        company1.generateGraph(new File("Files/countries.csv"), new File("Files/borders.csv"), new File("Files/seadists.csv"), 0); //Generates graph

        PortAndCapital lc1 = company1.getVerticesByName("Valletta");
        PortAndCapital lc2 = company1.getVerticesByName("Barcelona");

        List<PortAndCapital> actual = new LinkedList<PortAndCapital>();
        List<PortAndCapital> expected = new LinkedList<>();

        actual = company1.closestLandPath(lc1,lc2);

        assertEquals(expected,actual);
    }

    /////////////////////// SEA PATHS TESTS

    @Test
    void closestPathSea(){
        Company company1 = new Company();
        ImportPortsController importPortsController = new ImportPortsController(company1);

        importPortsController.importPorts(new File("Files/bports.csv")); //Imports all ports from file

        company1.generateGraph(new File("Files/countries.csv"), new File("Files/borders.csv"), new File("Files/seadists.csv"), 0); //Generates graph

        PortAndCapital lc1 = company1.getVerticesByName("Ponta Delgada");
        PortAndCapital lc2 = company1.getVerticesByName("Setubal");

        List<PortAndWareHouse> actual = new LinkedList<>();
        List<PortAndWareHouse> expected = new LinkedList<>();

        expected.add((PortAndWareHouse)lc1);
        expected.add((PortAndWareHouse)lc2);

        actual = company1.closestPathMaritime((PortAndWareHouse) lc1,(PortAndWareHouse) lc2);

        assertEquals(expected,actual);
    }

}