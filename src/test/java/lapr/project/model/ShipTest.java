package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShipTest {

    Ship shipTest = new Ship(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
    Ship shipTest2 = new Ship(123456000, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);

    @Test
    void getMMSI() {
        int expected = 123456788;
        int actual = shipTest.getMMSI();
        assertEquals(expected, actual);
    }

    @Test
    void setMMSI() {
        int expected = 881234567;
        shipTest.setMMSI(881234567);
        int actual = shipTest.getMMSI();
        assertEquals(expected, actual);
    }

    @Test
    void getName() {
        String expected = "WarCraft";
        String actual = shipTest.getName();
        assertEquals(expected,actual);
    }

    @Test
    void setName() {
        String excepted = "SpaceCraft";
        shipTest.setName("SpaceCraft");
        String actual = shipTest.getName();
        assertEquals(excepted, actual);
    }

    @Test
    void getIMO() {
        String expected = "1023456787";
        String actual = shipTest.getIMO();
        assertEquals(expected, actual);
    }

    @Test
    void setIMO() {
        String expected = "1234102345";
        shipTest.setIMO("1234102345");
        String actual = shipTest.getIMO();
        assertEquals(expected, actual);
    }

    @Test
    void getCallSign() {
        String expected = "Roger";
        String actual = shipTest.getCallSign();
        assertEquals(expected, actual);
    }

    @Test
    void setCallSign() {
        String expected = "Copy";
        shipTest.setCallSign("Copy");
        String actual = shipTest.getCallSign();
        assertEquals(expected, actual);
    }

    @Test
    void getVesselType() {
        int expected = 2;
        int actual  = shipTest.getVesselType();
        assertEquals(expected, actual);
    }

    @Test
    void setVesselType() {
        int expected = 3;
        shipTest.setVesselType(3);
        int actual = shipTest.getVesselType();
        assertEquals(expected,actual);
    }

    @Test
    void getLength() {
        double expeceted = 5.0;
        double actual = shipTest.getLength();
        assertEquals(expeceted,actual);
    }

    @Test
    void setLength() {
        double expected = 20.0;
        shipTest.setLength(20.0);
        double actual = shipTest.getLength();
        assertEquals(expected, actual);
    }

    @Test
    void getWidth() {
        double expected = 3.0;
        double actual =  shipTest.getWidth();
        assertEquals(expected, actual);
    }

    @Test
    void setWidth() {
        double expected = 66.0;
        shipTest.setWidth(66.0);
        double actual = shipTest.getWidth();
        assertEquals(expected, actual);
    }

    @Test
    void getDraft() {
        double expected = 20.9;
        double actual = shipTest.getDraft();
        assertEquals(expected, actual);
    }

    @Test
    void setDraft() {
        double expected = 20.0;
        shipTest.setDraft(20.0);
        double actual = shipTest.getDraft();
        assertEquals(expected, actual);
    }

    @Test
    void addPositionData() {

    }

    /**
     * Error because how can we get the treeOfPositionData ????

    @Test
    void testToString() {
        String expected = "Ship{" +
                "MMSI=" + shipTest.getMMSI() +
                ", name='" + shipTest.getName() + '\'' +
                ", IMO=" + shipTest.getIMO() +
                ", callSign='" + shipTest.getCallSign() + '\'' +
                ", vesselType=" + shipTest.getVesselType() +
                ", length=" + shipTest.getLength() +
                ", width=" + shipTest.getWidth() +
                ", draft=" + shipTest.getDraft() +
                '}' ;
        String actual = shipTest.toString();
        assertEquals(expected, actual);
    }
    */

    @Test
    void compareToBigger() {
        assertEquals(shipTest.compareTo(shipTest2), 1);
    }

    @Test
    void compareToAllPossibilities() {
        /**
         * When they are equal
         */
        Ship shipTestCompare1 = new Ship(123000788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        Ship shipTestCompare2 = new Ship(123000788, "Soup", "1023456782","Roger123",3, 5.0, 3.3, 20.9);
        assertEquals(0, shipTestCompare1.compareTo(shipTestCompare2));
        /**
         * Ship 3 is smaller than Ship 4
         */
        Ship shipTestCompare3 = new Ship(123000782, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        Ship shipTestCompare4 = new Ship(123000788, "Soup", "1023456782","Roger123",3, 5.0, 3.3, 20.9);
        assertEquals(-1, shipTestCompare3.compareTo(shipTestCompare4));
        /**
         * Ship 5 is bigger than Ship 6
         */
        Ship shipTestCompare5 = new Ship(123000789, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        Ship shipTestCompare6 = new Ship(123000788, "Soup", "1023456782","Roger123",3, 5.0, 3.3, 20.9);
        assertEquals(1, shipTestCompare5.compareTo(shipTestCompare6));
    }
}