package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BorderTest {

    Country mexico = new Country("South America", "ME", "MEX", "Mexico", 0.85, "Cidade do mexico", 22,22);
    Country portugal = new Country("Europe", "PO", "POR", "Portugal", 0.90, "Lisboa", 20,20);
    Country espanha = new Country("Europe","ES","ESP","Spain",46.53,"Madrid",40.4,-3.683333);

    Border border = new Border(portugal, mexico);
    Border border2 = new Border(portugal, espanha);
    Border border3 = new Border(portugal, mexico);
    Border border4 = new Border();

    @Test
    void getCountry1() {
        assertEquals(portugal, border.getCountry1());
    }

    @Test
    void setCountry1() {
        border2.setCountry1(mexico);

        assertEquals(mexico, border2.getCountry1());
    }

    @Test
    void getCountry2() {
        assertEquals(mexico, border.getCountry2());
    }

    @Test
    void setCountry2() {
        border2.setCountry2(portugal);

        assertEquals(portugal, border2.getCountry2());
    }

    @Test
    void equalsTest() {
        assertEquals(border,border3);
    }

    @Test
    void NotEquals() {
        assertNotEquals(border,border2);
    }


    @Test
    void hashCodeTest() {
        assertEquals(border.hashCode(), border3.hashCode());
    }

    @Test
    void toStringTest() {
        String expected = "Border{" +
                "country1=" + border.getCountry1() +
                ", country2=" + border.getCountry2() +
                '}';

        assertEquals(expected, border.toString());
    }
}