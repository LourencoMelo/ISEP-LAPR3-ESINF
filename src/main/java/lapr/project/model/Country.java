package lapr.project.model;

import java.util.Objects;

public class Country {

    /**
     * Continent of the country
     */
    private String continent;

    /**
     * Alphanumeric code with 2 digits
     */
    private String alpha2;

    /**
     * Alphanumeric code with 3 digits
     */
    private String alpha3;

    /**
     * Name of the country
     */
    private String name;

    /**
     * Population of the country
     */
    private double population;

    /**
     * Capital of the country
     */
    private String capital;

    /**
     * Latitude of the country's capital
     */
    private double latitude;

    /**
     * Longitude of the country´s capital
     */
    private double longitude;


    /**
     * Constructor for country
     * @param continent continent of the country
     * @param alpha2 alphanumeric code
     * @param alpha3 alphanumeric code
     * @param name name of the country
     * @param population population of the country
     * @param capital capital of the country
     * @param latitude latitude of the country
     * @param longitude longitude of the country
     */
    public Country(String continent, String alpha2, String alpha3, String name, double population, String capital, double latitude, double longitude) {
        setContinent(continent);
        setAlpha2(alpha2);
        setAlpha3(alpha3);
        setName(name);
        setPopulation(population);
        setCapital(capital);
        setLatitude(latitude);
        setLongitude(longitude);
    }

    /**
     * Empty constructor
     */
    public Country() {
    }

    /**
     * Getter for continent
     * @return continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Changes the continent
     * @param continent new continent
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Getter for alpha2 code
     * @return alpha2 code
     */
    public String getAlpha2() {
        return alpha2;
    }

    /**
     * Changes the alpha2 code
     * @param alpha2 new alpha2 code
     */
    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    /**
     * Getter for alpha3
     * @return alpha3
     */
    public String getAlpha3() {
        return alpha3;
    }

    /**
     * Changes the alpha3 code
     * @param alpha3 new alpha3 code
     */
    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }

    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the population
     * @return popolation
     */
    public double getPopulation() {
        return population;
    }

    /**
     * Changes the population
     * @param population new population
     */
    public void setPopulation(double population) {
        this.population = population;
    }

    /**
     * Getter for the capital
     * @return capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Changes the capital
     * @param capital new capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    /**
     * Getter for the latitude
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Changes the latitude
     * @param latitude new latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Getter for the longitude
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Changes the longitude
     * @param longitude new longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Equal method
     * @param o object to compare
     * @return boolean result. true if objects are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return alpha2.equals(country.alpha2) && alpha3.equals(country.alpha3) && name.equals(country.name);
    }

    /**
     * Generates hascode
     * @return hascode
     */
    @Override
    public int hashCode() {
        return Objects.hash(alpha2, alpha3, name);
    }

    /**
     * Description of the country
     * @return description
     */
    @Override
    public String toString() {
        return "Country{" +
                "continent='" + continent + '\'' +
                ", alpha2='" + alpha2 + '\'' +
                ", alpha3='" + alpha3 + '\'' +
                ", name='" + name + '\'' +
                ", population='" + population + '\'' +
                ", capital='" + capital + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
