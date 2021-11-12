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
        assertEquals(53.46666667,portAndWareHouse.getLat());
    }

    @Test
    void getLog() {
        assertEquals(-3.033333333,portAndWareHouse.getLog());
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
    void testToString() {
        String expected = "PortAndWareHouse{" +
                "continent='" + portAndWareHouse.getContinent() + '\'' +
                ", country='" + portAndWareHouse.getCountry() + '\'' +
                ", code=" + portAndWareHouse.getCode() +
                ", port='" + portAndWareHouse.getPort() + '\'' +
                ", lat=" + portAndWareHouse.getLat() +
                ", log=" + portAndWareHouse.getLog() +
                '}';

        assertEquals(expected,portAndWareHouse.toString());
    }
}