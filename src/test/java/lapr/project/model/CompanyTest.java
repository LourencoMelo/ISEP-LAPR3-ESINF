package lapr.project.model;

import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    Company company = App.getInstance().getCompany();

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

    @Test
    void getTopShipsWithMostKm() {
    }
}