package lapr.project.model;


import lapr.project.utils.graph.SubTreeOfPorts;

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
    private Capital capital;

    /**
     * Colour of the country
     */
    private int colour;

    /**
     * 2d tree of ports in the country
     */
    private SubTreeOfPorts tree_of_ports;

    /**
     * Constructor for country
     *
     * @param continent  continent of the country
     * @param alpha2     alphanumeric code
     * @param alpha3     alphanumeric code
     * @param name       name of the country
     * @param population population of the country
     * @param capital    capital of the country
     */
    public Country(String continent, String alpha2, String alpha3, String name, double population, Capital capital) {
        setContinent(continent);
        setAlpha2(alpha2);
        setAlpha3(alpha3);
        setName(name);
        setPopulation(population);
        setCapital(capital);
        tree_of_ports = new SubTreeOfPorts();
        this.colour = -1;
    }

    /**
     * Empty constructor
     */
    public Country() {
    }

    public int getColour() {
        return colour;
    }

    public void setColour(int colour) {
        this.colour = colour;
    }

    /**
     * Getter for continent
     *
     * @return continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Changes the continent
     *
     * @param continent new continent
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Getter for alpha2 code
     *
     * @return alpha2 code
     */
    public String getAlpha2() {
        return alpha2;
    }

    /**
     * Changes the alpha2 code
     *
     * @param alpha2 new alpha2 code
     */
    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    /**
     * Getter for alpha3
     *
     * @return alpha3
     */
    public String getAlpha3() {
        return alpha3;
    }

    /**
     * Changes the alpha3 code
     *
     * @param alpha3 new alpha3 code
     */
    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }

    /**
     * Getter for name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the population
     *
     * @return popolation
     */
    public double getPopulation() {
        return population;
    }

    /**
     * Changes the population
     *
     * @param population new population
     */
    public void setPopulation(double population) {
        this.population = population;
    }

    /**
     * Getter for the capital
     *
     * @return capital
     */
    public Capital getCapital() {
        return capital;
    }

    /**
     * Changes the capital
     *
     * @param capital new capital
     */
    public void setCapital(Capital capital) {
        this.capital = capital;
    }

    /**
     * Tree of country's ports
     *
     * @return 2d tree of ports
     */
    public SubTreeOfPorts getTree_of_ports() {
        return tree_of_ports;
    }

    /**
     * Equal method
     *
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
     *
     * @return hascode
     */
    @Override
    public int hashCode() {
        return Objects.hash(alpha2, alpha3, name);
    }

    /**
     * Description of the country
     *
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
                '}';
    }
}
