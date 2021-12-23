package lapr.project.model;

import java.util.Objects;

public class Border {

    /**
     * Country 1 object
     */
    private Country country1;

    /**
     * Country 2 object
     */
    private Country country2;

    /**
     * Constructor for border
     * @param country1 country 1
     * @param country2 country 2
     */
    public Border(Country country1, Country country2) {
        setCountry1(country1);
        setCountry2(country2);
    }

    /**
     * Empty constructor
     */
    public Border() {
    }

    /**
     * Getter for country 1
     * @return country 1
     */
    public Country getCountry1() {
        return country1;
    }

    /**
     * Changes the country 1
     * @param country1 new country 1
     */
    public void setCountry1(Country country1) {
        this.country1 = country1;
    }

    /**
     * Getter for the country 2
     * @return country 2
     */
    public Country getCountry2() {
        return country2;
    }

    /**
     * Changes the country 2
     * @param country2 new country 2
     */
    public void setCountry2(Country country2) {
        this.country2 = country2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Border border = (Border) o;
        return country1.equals(border.country1) && country2.equals(border.country2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country1, country2);
    }

    @Override
    public String toString() {
        return "Border{" +
                "country1=" + country1 +
                ", country2=" + country2 +
                '}';
    }
}
