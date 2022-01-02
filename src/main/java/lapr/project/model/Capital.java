package lapr.project.model;

import java.util.Objects;

public class Capital implements PortAndCapital{

    /**
     * Name of the capital
     */
    private String name;

    /**
     * Latitude of the capital
     */
    private double latitude;

    /**
     * Longitude of the capital
     */
    private double longitude;

    /**
     * Continent of the capital
     */
    private String continent;

    /**
     * Constructor for a capital
     * @param name name of the capital
     * @param latitude latitude of the capital
     * @param longitude longitude of the capital
     */
    public Capital(String name, double latitude, double longitude, String continent) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        setContinent(continent);
    }

    /**
     * Empty constructor
     */
    public Capital() {
    }

    /**
     * Getter for the name
     * @return name of capital
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for the latitude
     * @return latitude of the capital
     */
    @Override
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
     * Getter of the longitude
     * @return longitude of the capital
     */
    @Override
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
     * Getter for the continent of the capital
     * @return continent of capital
     */
    @Override
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Compares two objects
     * @param o object to compare
     * @return true if equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Capital capital = (Capital) o;
        return Double.compare(capital.latitude, latitude) == 0 && Double.compare(capital.longitude, longitude) == 0 && name.equals(capital.name);
    }

    /**
     * Hash code method
     * @return int value
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, latitude, longitude);
    }

    /**
     * Description of capital object
     * @return textual description of object
     */
    @Override
    public String toString() {
        return "\nCapital{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}' + '\n';
    }
}
