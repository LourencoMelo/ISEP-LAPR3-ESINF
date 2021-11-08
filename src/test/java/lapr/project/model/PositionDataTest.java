package lapr.project.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PositionDataTest {
    /**
     * PositionData instance
     */
    PositionData positionDataTest = new PositionData(LocalDateTime.of(2021, 11,8,13,39),10,10,3,4,5,1,"Sopa");

    /**
     * Testing GET BaseDateTime
     */
    @Test
    void getBaseDateTime() {
        LocalDateTime localDateTimeExpected = LocalDateTime.of(2021, 11,8,13,39);
        assertEquals(localDateTimeExpected, positionDataTest.getBaseDateTime());
    }

    /**
     * Testing SET BaseDateTime
     */
    @Test
    void setBaseDateTime() {
        LocalDateTime localDateTimeExpected = LocalDateTime.of(2020, 1,8,9,30);
        positionDataTest.setBaseDateTime(localDateTimeExpected);
        assertEquals(true, positionDataTest.getBaseDateTime() == localDateTimeExpected);
    }

    /**
     * Testing GET Latitude
     */
    @Test
    void getLatitude() {
        double expected = 10;
        assertEquals(expected, positionDataTest.getLatitude());
    }

    /**
     * Testing SET Latitude
     */
    @Test
    void setLatitude() {
        double expected = 12;
        positionDataTest.setLatitude(expected);
        assertEquals(true, positionDataTest.getLatitude() == expected);
    }

    /**
     * Testing GET Longitude
     */
    @Test
    void getLongitude() {
        double expected = 10;
        assertEquals(expected, positionDataTest.getLongitude());
    }

    /**
     * Testing SET Longitude
     */
    @Test
    void setLongitude() {
        double expected = 12;
        positionDataTest.setLongitude(expected);
        assertEquals(true, positionDataTest.getLongitude() == expected);
    }

    /**
     * Testing GET Sog
     */
    @Test
    void getSog() {
        double expected = 3;
        assertEquals(expected, positionDataTest.getSog());
    }

    /**
     * Testing SET Sog
     */
    @Test
    void setSog() {
        double expected = 4;
        positionDataTest.setSog(4);
        assertEquals(true, positionDataTest.getSog() == expected);
    }

    /**
     * Testing GET Cog
     */
    @Test
    void getCog() {
        double expected = 4;
        assertEquals(expected, positionDataTest.getCog());
    }

    /**
     * Testing SET Cog
     */
    @Test
    void setCog() {
        double expected = 22;
        positionDataTest.setCog(expected);
        assertEquals(true, positionDataTest.getCog() == expected);
    }

    /**
     * Testing GET Heading
     */
    @Test
    void getHeading() {
        double expected = 5;
        assertEquals(expected, positionDataTest.getHeading());
    }

    /**
     * Testing SET Heading
     */
    @Test
    void setHeading() {
        double expected = 10;
        positionDataTest.setHeading(expected);
        assertEquals(true, positionDataTest.getHeading() == expected);
    }

    /**
     * Testing GET Position
     */
    @Test
    void getPosition() {
        int expected = 1;
        assertEquals(expected, positionDataTest.getPosition());
    }

    /**
     * Testing SET Position
     */
    @Test
    void setPosition() {
        int expected = 2;
        positionDataTest.setPosition(expected);
        assertEquals(true, positionDataTest.getPosition() == expected);
    }

    /**
     * Testing SET Transceiver
     */
    @Test
    void setTransceiver() {
        String expected = "Bebida";
        positionDataTest.setTransceiver(expected);
        assertEquals(true, positionDataTest.getTransceiver() == expected);
    }

    /**
     * Testing GET Transceiver
     */
    @Test
    void getTransceiver() {
        String expected = "Sopa";
        assertEquals(expected, positionDataTest.getTransceiver());
    }

    /**
     * Testing Equals when they are the same object
     */
    @Test
    void testEqualsSameObject() {
        assertEquals(true, positionDataTest.equals(positionDataTest));
    }

    /**
     * Testing Equals when they have the same values but different objects
     */
    @Test
    void testEqualsSameValues() {
        PositionData positionDataTest2 = new PositionData(LocalDateTime.of(2011, 11,8,13,39),10,10,3,4,5,1,"Sopa");
        assertEquals(true, positionDataTest.equals(positionDataTest2));
    }

    /**
     * Testing Equals when passes a null parameter
     */
    @Test
    void notEqualsNull(){
        assertEquals(false, positionDataTest.equals(null));
    }

    /**
     * Testing Equals when the objects have different values
     */
    @Test
    void notEqualsDifferentValues(){
        PositionData positionDataTestCompare3 = new PositionData(LocalDateTime.of(2020, 11, 8, 13, 39), 11, 10, 5, 4, 2, 1, "Sopa");
        PositionData positionDataTestCompare4 = new PositionData(LocalDateTime.of(2019, 11, 8, 13, 39), 10, 3, 3, 4, 5, 1, "Sopa");
        assertEquals(false, positionDataTestCompare3.equals(positionDataTestCompare4));
    }

    /**
     * Testing toString() of the PositionData
     */
    @Test
    void toStringTest() {
        String expected = "PositionData{" +
                "baseDateTime=" + positionDataTest.getBaseDateTime() +
                ", latitude=" + positionDataTest.getLatitude() +
                ", longitude=" + positionDataTest.getLongitude() +
                ", sog=" + positionDataTest.getSog() +
                ", cog=" + positionDataTest.getCog() +
                ", heading=" + positionDataTest.getHeading() +
                ", position=" + positionDataTest.getPosition() +
                '}';
        assertEquals(true, positionDataTest.toString() == expected);
    }

    /**
     * Comparing when positions have the same LOCALDATETIME
     */
    @Test
    void compareToEqual() {
        /**
         * When the positions are at the sime time
         */
        PositionData positionDataTestCompare1 = new PositionData(LocalDateTime.of(2019, 11, 8, 13, 39), 10, 10, 3, 4, 5, 1, "Sopa");
        PositionData positionDataTestCompare2 = new PositionData(LocalDateTime.of(2019, 11, 8, 13, 39), 10, 10, 3, 4, 5, 1, "Sopa");
        assertEquals(0, positionDataTestCompare1.compareTo(positionDataTestCompare2));
    }

    /**
     * Comparing when positions have Different LOCALDATETIME
     */
    @Test
    void compareToAfter() {
        /**
         * Position 3 is after in time Postion 4
         */
        PositionData positionDataTestCompare3 = new PositionData(LocalDateTime.of(2020, 11, 8, 13, 39), 10, 10, 3, 4, 5, 1, "Sopa");
        PositionData positionDataTestCompare4 = new PositionData(LocalDateTime.of(2019, 11, 8, 13, 39), 10, 10, 3, 4, 5, 1, "Sopa");
        assertEquals(1, positionDataTestCompare3.compareTo(positionDataTestCompare4));
    }

    /**
     * Comparing when positions have the same LOCALDATETIME
     */
    @Test
    void compareToBefore() {
        /**
         * Position 5 is before in time than Position 6
         */
        PositionData positionDataTestCompare5 = new PositionData(LocalDateTime.of(2018, 11,8,13,39),10,10,3,4,5,1,"Sopa");
        PositionData positionDataTestCompare6 = new PositionData(LocalDateTime.of(2019, 11,8,13,39),10,10,3,4,5,1,"Sopa");
        assertEquals(-1, positionDataTestCompare5.compareTo(positionDataTestCompare6));
    }
}