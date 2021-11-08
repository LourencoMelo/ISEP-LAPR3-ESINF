package lapr.project.model;

public class PortAndWareHouse {

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                  INFORMATION ABOUT PORTS AND WAREHOUSES
     * -------------------------------------------------------------------------------------------------------------
     */

    /**
     * Continent of the port or warehouse
     */

    private String continent;

    /**
     * Country of the port or warehouse
     */

    private String country;

    /**
     * Code of the port or warehouse
     */

    private int code;

    /**
     * Name of the port or warehouse
     */

    private String port;

    /**
     * Latitude of the port or warehouse
     */

    private double lat;

    /**
     * Longitude of the port or warehouse
     */

    private double log;

    /**
     * Constructor
     */

    /**
     *
     * @param continent continent of the port
     * @param country country of the port
     * @param code code pf the port
     * @param port name of the port
     * @param lat latitude of the port
     * @param log longitude of the port
     */
    public PortAndWareHouse(String continent, String country, int code,String port,double lat, double log){
        setContinent(continent);
        setCountry(country);
        setCode(code);
        setPort(port);
        setLat(lat);
        setLog(log);
    }

    /**
     * Sets the code of the port
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Sets the continent of the port
     * @param continent
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Sets the country of the port
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Sets the latitude of the port
     * @param lat
     */
    public void setLat(double lat) {
        this.lat = lat;
    }

    /**
     * Sets the longitude of the port
     * @param log
     */
    public void setLog(double log) {
        this.log = log;
    }

    /**
     * Sets the name of the port
     * @param port
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * Returns the code
     * @return code
     */
    public int getCode() {
        return code;
    }

    /**
     * Returns the continent
     * @return continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Returns the latitude
     * @return latitude
     */
    public double getLat() {
        return lat;
    }

    /**
     * Returns the longitude
     * @return longitude
     */
    public double getLog() {
        return log;
    }

    /**
     * Returns the country
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Returns the name
     * @return port
     */
    public String getPort() {
        return port;
    }

    /*@Override
    public boolean equal(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        PortAndWareHouse portAndWareHouse = (PortAndWareHouse) o;
        return code == portAndWareHouse.code;
    }*/

    /**
     * Tos String
     */
    @Override
    public String toString() {
        return "PortAndWareHouse{" +
                "continent='" + continent + '\'' +
                ", country='" + country + '\'' +
                ", code=" + code +
                ", port='" + port + '\'' +
                ", lat=" + lat +
                ", log=" + log +
                '}';
    }
}