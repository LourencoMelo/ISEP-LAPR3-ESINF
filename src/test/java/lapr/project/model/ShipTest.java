package lapr.project.model;


import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ShipTest {

    private static final DecimalFormat df = new DecimalFormat("0.0");

    /**
     * Ship instance
     */
    Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

    PositionData positionData1 = new PositionData(formatter("31/12/2020 17:19"),42.97875,-66.97001,12.9,13.1,355,"NA","B");

    PositionData positionData2 = new PositionData(formatter("31/12/2020 22:10"),24.11445,-84.65529,11.6,113.3,110,"NA","B");


    @Test
    void emptyConstructor() {
        new ShipByMMSI();
        new ShipByIMO();
        new ShipByCallSign();
    }

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
        int expected = 100000000;
        int expected2 = 999999999;
        int expected3 = 881234567;

        shipTest.setMMSI(100000000);
        assertEquals(expected, shipTest.getMMSI());

        shipTest.setMMSI(999999999);
        assertEquals(expected2, shipTest.getMMSI());

        shipTest.setMMSI(881234567);
        assertEquals(expected3, shipTest.getMMSI());

        try {
            shipTest.setMMSI(11);
        }catch (Exception exception){
            assertEquals("MMSI needs to be a 9 digits unique number.",exception.getMessage());
        }

    }

    /**
     * Testing GET NAME
     */
    @Test
    void getName() {
        String expected = "WarCraft";
        String actual = shipTest.getName();
        assertEquals(expected, actual);
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

        try {
            shipTest.setIMO("11");
        }catch (Exception exception){
            assertEquals("IMO needs to be a 10 digits unique number.", exception.getMessage());
        }
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
        int actual = shipTest.getVesselType();
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
        assertEquals(expected, actual);
    }

    /**
     * Testing GET Length
     */
    @Test
    void getLength() {
        double expeceted = 5.0;
        double actual = shipTest.getLength();
        assertEquals(expeceted, actual);
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
        double actual = shipTest.getWidth();
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

    /**
     * Testing toString() of the Ship
     */
    @Test
    void testToString() {
        PositionData positionDataTest2 = new PositionData(LocalDateTime.of(2011, 11, 8, 13, 39), 10, 10, 3, 4, 5, "1", "Sopa");
        shipTest.addPositionData(positionDataTest2);
        String expected = "Ship{" +
                "MMSI=" + shipTest.getMMSI() +
                ", name='" + shipTest.getName() + '\'' +
                ", IMO=" + shipTest.getIMO() +
                ", callSign='" + shipTest.getCallSign() + '\'' +
                ", vesselType=" + shipTest.getVesselType() +
                ", length=" + shipTest.getLength() +
                ", width=" + shipTest.getWidth() +
                ", draft=" + shipTest.getDraft() +
                '}' + "\nPositionData{" + "baseDateTime=" + positionDataTest2.getBaseDateTime() + ", latitude=" + positionDataTest2.getLatitude() + ", longitude=" + positionDataTest2.getLongitude() + ", sog=" + positionDataTest2.getSog() + ", cog=" + positionDataTest2.getCog() + ", heading=" + positionDataTest2.getHeading() + ", position=" + positionDataTest2.getPosition() + "}\n";
        String actual = shipTest.toString();
        assertTrue(shipTest.toString().equalsIgnoreCase(expected));
    }


    /**
     * Comparing ships when they have the same MMSI
     */
    @Test
    void compareToEqual() {
        /**
         * When they are equal
         */
        Ship shipTestCompare1 = new ShipByMMSI(123000788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTestCompare2 = new ShipByMMSI(123000788, "Soup", "1023456782", "Roger123", 3, 5.0, 3.3, 20.9);

        Ship shipTestCompare3 = new ShipByIMO(123000788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTestCompare4 = new ShipByIMO(123000788, "Soup", "1023456787", "Roger123", 3, 5.0, 3.3, 20.9);

        Ship shipTestCompare5 = new ShipByCallSign(123000788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTestCompare6 = new ShipByCallSign(123000788, "Soup", "1023456782", "Roger", 3, 5.0, 3.3, 20.9);

        assertEquals(0, shipTestCompare1.compareTo(shipTestCompare2));
        assertEquals(0, shipTestCompare3.compareTo(shipTestCompare4));
        assertEquals(0, shipTestCompare5.compareTo(shipTestCompare6));
    }

    /**
     * Comparing ships when the Ship 3 is smaller than Ship 4 in MMSI perspective
     */
    @Test
    void compareToSmaller() {
        /**
         * Ship 3 is smaller than Ship 4
         */
        Ship shipTestCompare1 = new ShipByMMSI(123000787, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTestCompare2 = new ShipByMMSI(123000788, "Soup", "1023456782", "Roger123", 3, 5.0, 3.3, 20.9);

        Ship shipTestCompare3 = new ShipByIMO(123000782, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTestCompare4 = new ShipByIMO(123000788, "Soup", "1023456788", "Roger123", 3, 5.0, 3.3, 20.9);

        Ship shipTestCompare5 = new ShipByCallSign(123000782, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTestCompare6 = new ShipByCallSign(123000788, "Soup", "1023456782", "Roger1", 3, 5.0, 3.3, 20.9);


        assertEquals(-1, shipTestCompare1.compareTo(shipTestCompare2));
        assertEquals(-1, shipTestCompare3.compareTo(shipTestCompare4));
        assertEquals(-1, shipTestCompare5.compareTo(shipTestCompare6));
    }

    /**
     * Comparing ships when the Ship 5 is bigger than Ship 6 in MMSI perspective
     */
    @Test
    void compareToBigger() {
        /**
         * Ship 5 is bigger than Ship 6
         */
        Ship shipTestCompare1 = new ShipByMMSI(123000787, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTestCompare2 = new ShipByMMSI(123000786, "Soup", "1023456782", "Roger123", 3, 5.0, 3.3, 20.9);

        Ship shipTestCompare3 = new ShipByIMO(123000782, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        Ship shipTestCompare4 = new ShipByIMO(123000788, "Soup", "1023456786", "Roger123", 3, 5.0, 3.3, 20.9);

        Ship shipTestCompare5 = new ShipByCallSign(123000782, "WarCraft", "1023456787", "Roger1", 2, 5.0, 3.0, 20.9);
        Ship shipTestCompare6 = new ShipByCallSign(123000788, "Soup", "1023456782", "Roger", 3, 5.0, 3.3, 20.9);


        assertEquals(1, shipTestCompare1.compareTo(shipTestCompare2));
        assertEquals(1, shipTestCompare3.compareTo(shipTestCompare4));
        assertEquals(1, shipTestCompare5.compareTo(shipTestCompare6));

    }

    @Test
    void getInitialDate() {
        shipTest.addPositionData(positionData1);
        shipTest.addPositionData(positionData2);

        assertEquals(formatter("31/12/2020 17:19"),shipTest.initialDate());
    }

    @Test
    void getFinalDate() {
        shipTest.addPositionData(positionData1);
        shipTest.addPositionData(positionData2);

        assertEquals(formatter("31/12/2020 22:10"),shipTest.finalDate());

    }

    @Test
    void getTotalMovementTime() {
        shipTest.addPositionData(positionData1);
        shipTest.addPositionData(positionData2);

        assertEquals(17460L,shipTest.totalMovementTime());
    }

    @Test
    void getTotalMovements() {
        shipTest.addPositionData(positionData1);
        shipTest.addPositionData(positionData2);

        assertEquals(2,shipTest.getTotalMovements());
    }

    @Test
    void getMaxSOG() {
        shipTest.addPositionData(positionData1);
        shipTest.addPositionData(positionData2);

        assertEquals(12.9,shipTest.getMaxSOG());
    }

    @Test
    void getMeanSOG() {
        shipTest.addPositionData(positionData1);
        shipTest.addPositionData(positionData2);

        assertEquals(12.25,shipTest.getMeanSOG());
    }

    @Test
    void getMaxCOG() {
        shipTest.addPositionData(positionData1);
        shipTest.addPositionData(positionData2);

        assertEquals(113.3,shipTest.getMaxCOG());
    }

    @Test
    void getMeanCOG() {
        shipTest.addPositionData(positionData1);
        shipTest.addPositionData(positionData2);

        assertEquals("63,2", String.format("%.1f",shipTest.getMeanCOG()));
    }

    @Test
    void meanSOGBetweenTwoDates() {
        shipTest.addPositionData(positionData1);
        shipTest.addPositionData(positionData2);

        assertEquals(12.25,shipTest.meanSOG(formatter("31/12/2020 17:19"),formatter("31/12/2020 22:10")));
    }

    @Test
    void travelledDistanceBetweenTwoDates() {
        shipTest.addPositionData(positionData1);
        shipTest.addPositionData(positionData2);

        assertEquals("2650,0",String.format("%.1f",shipTest.travelledDistanceBtDates(formatter("31/12/2020 17:19"),formatter("31/12/2020 22:10"))));
    }

    @Test
    void toStringTest() {

        shipTest.addPositionData(positionData1);
        shipTest.addPositionData(positionData2);

        String toStringActual = "Ship{" +
                "MMSI=" + shipTest.getMMSI() +
                ", Total number of movements='" + shipTest.getTotalMovements() + '\'' +
                ", Travelled Distance=" + shipTest.travelledDistance() +
                ", Delta Distance='" + shipTest.getDeltaDistance() + '\'' +
                '}' + '\n';

        assertEquals(toStringActual,shipTest.toStringMMSIMovementsTravelledDistanceDeltaDistance());

    }

    LocalDateTime formatter(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(str, formatter);
    }
}