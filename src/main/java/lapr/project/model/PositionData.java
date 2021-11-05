package lapr.project.model;

import java.util.Date;

public class PositionData {

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                  INFORMATION ABOUT THE POSITION
     * -------------------------------------------------------------------------------------------------------------
     */

    /**
     * BaseDate Time of the Ship
     */
    private Date baseDateTime;
    /**
     * Latitude of the Ship(Position)
     */
    private double latitude;
    /**
     * Longitude of the Ship(Position)
     */
    private double longitude;
    /**
     * Sog of the Ship(Position)
     */
    private double sog;
    /**
     * Cog of the Ship(Position)
     */
    private double cog;
    /**
     * Heading of the Ship(Position)
     */
    private double heading;
    /**
     * Position of the Ship(Position)
     */
    private int position;

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                          CONSTRUCTOR
     * -------------------------------------------------------------------------------------------------------------
     */

    public PositionData(Date baseDateTime, double latitude, double longitude, double sog, double cog, double heading, int position) {
        setBaseDateTime(baseDateTime);
        setLatitude(latitude);
        setLongitude(longitude);
        setSog(sog);
        setCog(cog);
        setHeading(heading);
        setPosition(position);
    }

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                          GETS AND SETS
     * -------------------------------------------------------------------------------------------------------------
     */


    /**
     * Returns the baseDatTime of the Ship
     * @return baseDateTime
     */
    public Date getBaseDateTime() {
        return baseDateTime;
    }

    /**
     * Set the baseDatTime of the Ship
     * @param baseDateTime
     */
    public void setBaseDateTime(Date baseDateTime) {
        this.baseDateTime = baseDateTime;
    }

    /**
     * Returns the Latitude of the Ship
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the Latitude of the Ship
     * @param latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Returns the Longitude of the Ship
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the Longitude of the Ship
     * @param longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Returns the Sog of the Ship
     * @return sog
     */
    public double getSog() {
        return sog;
    }

    /**
     * Sets the Sog of the Ship
     * @param sog
     */
    public void setSog(double sog) {
        this.sog = sog;
    }

    /**
     * Returns the Cog of the Ship
     * @return cog
     */
    public double getCog() {
        return cog;
    }

    /**
     * Sets the Cog of the Ship
     * @param cog
     */
    public void setCog(double cog) {
        this.cog = cog;
    }

    /**
     * Returns the Heading of the Ship
     * @return heading
     */
    public double getHeading() {
        return heading;
    }

    /**
     * Sets the Heading of the Ship
     * @param heading
     */
    public void setHeading(double heading) {
        this.heading = heading;
    }

    /**
     * Returns the position of the Ship
     * @return position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Sets the position of the Ship
     * @param position
     */
    public void setPosition(int position) {
        this.position = position;
    }
}
