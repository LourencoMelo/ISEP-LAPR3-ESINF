package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PortAndWareHouseTest {

    @Test
    void constructor() {
        new PortAndWareHouse("Europe","United Kingdom",29002,"Liverpool",53.46666667,-3.033333333);
    }

    PortAndWareHouse portAndWareHouse = new PortAndWareHouse("Europe","United Kingdom",29002,"Liverpool",53.46666667,-3.033333333);

    @Test
    void getCode() {
        assertEquals(29002,portAndWareHouse.getCode());
    }

    @Test
    void getContinent() {
        assertEquals("Europe",portAndWareHouse.getContinent());
    }

    @Test
    void getLat() {
        assertEquals(53.46666667,portAndWareHouse.getLatitude());
    }

    @Test
    void getLog() {
        assertEquals(-3.033333333,portAndWareHouse.getLongitude());
    }

    @Test
    void getCountry() {
        assertEquals("United Kingdom",portAndWareHouse.getCountry());
    }

    @Test
    void getPort() {
        assertEquals("Liverpool",portAndWareHouse.getPort());
    }

    @Test
    void equals() {
        PortAndWareHouse portAndWareHouse1 = new PortAndWareHouse("Europe","United Kingdom",29002,"Liverpool",53.46666667,-3.033333333);

        Ship shipTestCompare1 = new ShipByMMSI(123000788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        PortAndWareHouse portAndWareHouse2 = new PortAndWareHouse("ola","ola",29002,"ola",1,-2);

        PortAndWareHouse portAndWareHouse3 = new PortAndWareHouse("ola","ola",29001,"ola",1,-2);


        PortAndWareHouse portAndWareHouse4 = null;

        assertEquals(portAndWareHouse1, portAndWareHouse1);
        assertNotEquals(portAndWareHouse1, portAndWareHouse3);
        assertEquals(portAndWareHouse1, portAndWareHouse2);
        assertNotEquals(portAndWareHouse1, shipTestCompare1);
        assertNotEquals(portAndWareHouse1, portAndWareHouse4);


    }

    @Test
    void testToString() {
        String expected = "PortAndWareHouse{" +
                "continent='" + portAndWareHouse.getContinent() + '\'' +
                ", country='" + portAndWareHouse.getCountry() + '\'' +
                ", code=" + portAndWareHouse.getCode() +
                ", port='" + portAndWareHouse.getPort() + '\'' +
                ", lat=" + portAndWareHouse.getLatitude() +
                ", log=" + portAndWareHouse.getLongitude() +
                '}';

        assertEquals(expected,portAndWareHouse.toString());
    }
}