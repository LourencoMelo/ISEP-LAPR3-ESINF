package lapr.project.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShipTest {
    /**
     * Ship instance
     */
    Ship shipTest = new Ship(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);

    /**
     * Testing Get MMSI
     */
    @Test
    void getMMSI() {
        int expected = 123456788;
        int actual = shipTest.getMMSI();
        assertEquals(expected, actual);
    }

    /**
     * Testing SET MMSI
     */
    @Test
    void setMMSI() {
        int expected = 881234567;
        shipTest.setMMSI(881234567);
        int actual = shipTest.getMMSI();
        assertEquals(expected, actual);
    }

    /**
     * Testing GET NAME
     */
    @Test
    void getName() {
        String expected = "WarCraft";
        String actual = shipTest.getName();
        assertEquals(expected,actual);
    }

    /**
     * Testing SET Name
     */
    @Test
    void setName() {
        String excepted = "SpaceCraft";
        shipTest.setName("SpaceCraft");
        String actual = shipTest.getName();
        assertEquals(excepted, actual);
    }
    /**
     * Testing GET IMO
     */
    @Test
    void getIMO() {
        String expected = "1023456787";
        String actual = shipTest.getIMO();
        assertEquals(expected, actual);
    }
    /**
     * Testing SET IMO
     */
    @Test
    void setIMO() {
        String expected = "1234102345";
        shipTest.setIMO("1234102345");
        String actual = shipTest.getIMO();
        assertEquals(expected, actual);
    }

    /**
     * Testing GET CallSign
     */
    @Test
    void getCallSign() {
        String expected = "Roger";
        String actual = shipTest.getCallSign();
        assertEquals(expected, actual);
    }

    /**
     * Testing SET CallSign
     */
    @Test
    void setCallSign() {
        String expected = "Copy";
        shipTest.setCallSign("Copy");
        String actual = shipTest.getCallSign();
        assertEquals(expected, actual);
    }

    /**
     * Testing GET VesselType
     */
    @Test
    void getVesselType() {
        int expected = 2;
        int actual  = shipTest.getVesselType();
        assertEquals(expected, actual);
    }

    /**
     * Testing SET VesselType
     */
    @Test
    void setVesselType() {
        int expected = 3;
        shipTest.setVesselType(3);
        int actual = shipTest.getVesselType();
        assertEquals(expected,actual);
    }

    /**
     * Testing GET Length
     */
    @Test
    void getLength() {
        double expeceted = 5.0;
        double actual = shipTest.getLength();
        assertEquals(expeceted,actual);
    }

    /**
     * Testing SET Length
     */
    @Test
    void setLength() {
        double expected = 20.0;
        shipTest.setLength(20.0);
        double actual = shipTest.getLength();
        assertEquals(expected, actual);
    }

    /**
     * Testing GET Width
     */
    @Test
    void getWidth() {
        double expected = 3.0;
        double actual =  shipTest.getWidth();
        assertEquals(expected, actual);
    }

    /**
     * Testing SET Width
     */
    @Test
    void setWidth() {
        double expected = 66.0;
        shipTest.setWidth(66.0);
        double actual = shipTest.getWidth();
        assertEquals(expected, actual);
    }

    /**
     * Testing GET Draft
     */
    @Test
    void getDraft() {
        double expected = 20.9;
        double actual = shipTest.getDraft();
        assertEquals(expected, actual);
    }

    /**
     * Testing SET Draft
     */
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

//    /**
//     * Testing toString() of the Ship
//     */
//    @Test
//    void testToString() {
//        PositionData positionDataTest2 = new PositionData(LocalDateTime.of(2011, 11,8,13,39),10,10,3,4,5,1,"Sopa");
//        shipTest.addPositionData(positionDataTest2);
//        String expected = "Ship{" +
//                "MMSI=" + shipTest.getMMSI() +
//                ", name='" + shipTest.getName() + '\'' +
//                ", IMO=" + shipTest.getIMO() +
//                ", callSign='" + shipTest.getCallSign() + '\'' +
//                ", vesselType=" + shipTest.getVesselType() +
//                ", length=" + shipTest.getLength() +
//                ", width=" + shipTest.getWidth() +
//                ", draft=" + shipTest.getDraft() +
//                '}' + positionDataTest2;
//        String actual = shipTest.toString();
//        assertEquals(expected, actual);
//    }

    /**
     * Comparing ships when they have the same MMSI
     */
    @Test
    void compareToEqual() {
        /**
         * When they are equal
         */
        Ship shipTestCompare1 = new Ship(123000788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTestCompare2 = new Ship(123000788, "Soup", "1023456782", "Roger123", 3, 5.0, 3.3, 20.9);
        assertEquals(0, shipTestCompare1.compareTo(shipTestCompare2));
    }

    /**
     * Comparing ships when the Ship 3 is smaller than Ship 4 in MMSI perspective
     */
    @Test
    void compareToSmaller() {
        /**
         * Ship 3 is smaller than Ship 4
         */
        Ship shipTestCompare3 = new Ship(123000782, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTestCompare4 = new Ship(123000788, "Soup", "1023456782", "Roger123", 3, 5.0, 3.3, 20.9);
        assertEquals(-1, shipTestCompare3.compareTo(shipTestCompare4));
    }

    /**
     * Comparing ships when the Ship 5 is bigger than Ship 6 in MMSI perspective
     */
    @Test
    void compareToBigger(){
        /**
         * Ship 5 is bigger than Ship 6
         */
        Ship shipTestCompare5 = new Ship(123000789, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        Ship shipTestCompare6 = new Ship(123000788, "Soup", "1023456782","Roger123",3, 5.0, 3.3, 20.9);
        assertEquals(1, shipTestCompare5.compareTo(shipTestCompare6));
    }
}