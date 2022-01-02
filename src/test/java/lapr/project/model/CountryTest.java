package lapr.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {
    Capital capital1 = new Capital("Nicosia", 22, 23, "Europe");
    Capital capital = new Capital("Nycosya", 22, 23, "Europe");

    Country country = new Country("Europe","CY","CYP","Cyprus",0.85,capital1);
    Country country2 = new Country("Europe","CY","CYP","Cyprus",0.85,capital1);
    Country country3 = new Country("Europe","MT","MLT","Malta",0.44,capital1);


    @Test
    void getContinent() {
        assertEquals("Europe", country.getContinent());
    }

    @Test
    void setContinent() {
        country.setContinent("Asia");

        assertEquals("Asia", country.getContinent());
    }

    @Test
    void getAlpha2() {
        assertEquals("CY",country.getAlpha2());
    }

    @Test
    void setAlpha2() {
        country.setAlpha2("CI");

        assertEquals("CI", country.getAlpha2());
    }

    @Test
    void getAlpha3() {
        assertEquals("CYP", country.getAlpha3());
    }

    @Test
    void setAlpha3() {
        country.setAlpha3("CIP");

        assertEquals("CIP", country.getAlpha3());
    }

    @Test
    void getName() {
        assertEquals("Cyprus", country.getName());
    }

    @Test
    void setName() {
        country.setName("Ciprus");

        assertEquals("Ciprus", country.getName());
    }

    @Test
    void getPopulation() {
        assertEquals(0.85,country.getPopulation());
    }

    @Test
    void setPopulation() {
        country.setPopulation(0.82);

        assertEquals(0.82, country.getPopulation());
    }

    @Test
    void getCapital() {
        assertEquals("Nicosia", country.getCapital().getName());
    }

    @Test
    void setCapital() {
        country.setCapital(capital);

        assertEquals("Nycosya", country.getCapital().getName());
    }

    @Test
    void toStringtest() {
        String expected = "Country{" +
                "continent='" + country3.getContinent() + '\'' +
                ", alpha2='" + country3.getAlpha2() + '\'' +
                ", alpha3='" + country3.getAlpha3() + '\'' +
                ", name='" + country3.getName() + '\'' +
                ", population='" + country3.getPopulation() + '\'' +
                ", capital='" + country3.getCapital() + '\'' +
                '}';

        assertEquals(expected, country3.toString());
    }

    @Test
    void equalsTest() {
        assertEquals(country,country2);
    }

    @Test
    void notEquals() {
        assertNotEquals(country,country3);
    }

    @Test
    void hashcodeTest() {
        assertEquals(country.hashCode(),country2.hashCode());
        assertNotEquals(country.hashCode(), country3.hashCode());
    }
}