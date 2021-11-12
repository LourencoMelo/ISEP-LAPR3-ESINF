package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    @Test
    void testToString() {

        Ship shipTest1 = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        Ship shipTest2 = new ShipByMMSI(123456789, "Carlos", "1023456788","Pedro",2, 5.0, 3.0, 20.9);

        String expected = "(" + shipTest1 + ", " + shipTest2 + ")";

        Pair<Ship,Ship> pair = Pair.of(shipTest1,shipTest2);

        assertEquals(expected,pair.toString());
    }
}