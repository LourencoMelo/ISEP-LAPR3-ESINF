package lapr.project.model;

import lapr.project.utils.TreeOfPositionData;

import java.time.LocalDateTime;

public abstract class Ship implements Comparable<Ship> {

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                  INFORMATION ABOUT THE SHIP
     * -------------------------------------------------------------------------------------------------------------
     */

    /**
     * MMSI of the Ship
     */
    private int MMSI;
    /**
     * Name of the Ship
     */
    private String name;
    /**
     * IMO of the Ship
     */
    private String IMO;

    /**
     * CallSign of the Ship
     */
    private String callSign;

    /**
     * Vessel Type of the Ship
     */
    private int vesselType;

    /**
     * Length of the ship
     */
    private double length;

    /**
     * With of the ship
     */
    private double width;

    /**
     * Draft of the Ship
     */
    private double draft;

    /**
     * Tree of PositionData
     */
    private TreeOfPositionData treeOfPositionData;

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                               CONSTRUCTOR
     * -------------------------------------------------------------------------------------------------------------
     */


    /**
     * Constructor of the class Ship
     *
     * @param MMSI       MMSI of the Ship
     * @param name       Name of the Ship
     * @param IMO        IMO of the Ship
     * @param callSign   CallSign of the Ship
     * @param vesselType Vessel Type of the Ship
     * @param length     Length of the ship
     * @param width      With of the ship
     * @param draft      Draft of the Ship
     */
    public Ship(int MMSI, String name, String IMO, String callSign, int vesselType, double length, double width, double draft) {
        setMMSI(MMSI);
        setName(name);
        setIMO(IMO);
        setCallSign(callSign);
        setVesselType(vesselType);
        setLength(length);
        setWidth(width);
        setDraft(draft);
        treeOfPositionData = new TreeOfPositionData();
    }

    /**
     * Empty constructor
     */
    public Ship() {

    }

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                              GETS AND SETS
     * -------------------------------------------------------------------------------------------------------------
     */


    /**
     * Returns MMSI of the Ship
     *
     * @return MMSI
     */

    public int getMMSI() {
        return MMSI;
    }

    /**
     * Sets the MMSI of the Ship
     *
     * @param MMSI new MMSI
     */
    public void setMMSI(int MMSI) {
        if (MMSI >= 100000000 && MMSI <= 999999999) {
            this.MMSI = MMSI;
        } else {
            throw new IllegalArgumentException("MMSI needs to be a 9 digits unique number.");
        }
    }

    /**
     * Returns the Name of the Ship
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Name of the Ship
     *
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the IMO of the Ship
     *
     * @return IMO
     */
    public String getIMO() {
        return IMO;
    }

    /**
     * Sets the IMO of the Ship
     *
     * @param IMO new IMO
     */
    public void setIMO(String IMO) {
        if (IMO.length() == 10) {
            this.IMO = IMO;
        } else {
            throw new IllegalArgumentException("IMO needs to be a 10 digits unique number.");
        }
    }


    /**
     * Returns the CallSign of the Ship
     *
     * @return callSign
     */
    public String getCallSign() {
        return callSign;
    }

    /**
     * Sets the CallSign of the Ship
     *
     * @param callSign new CallSign
     */
    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    /**
     * Returns the VesselType of the Ship
     *
     * @return vesselType
     */
    public int getVesselType() {
        return vesselType;
    }

    /**
     * Sets the VesselType of the Ship
     *
     * @param vesselType new vessel type
     */
    public void setVesselType(int vesselType) {
        this.vesselType = vesselType;
    }

    /**
     * Returns the Length of the Ship
     *
     * @return length
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets the Length of the Ship
     *
     * @param length new length
     */
    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            throw new IllegalArgumentException("Length needs to be a positive number.");
        }
    }

    /**
     * Returns the Width of the Ship
     *
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the Width of the Ship
     *
     * @param width new width
     */
    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            throw new IllegalArgumentException("Width needs to be a positive number.");
        }
    }


    /**
     * Returns the Draft of the Ship
     *
     * @return draft
     */
    public double getDraft() {
        return draft;
    }

    /**
     * Sets the Draft of the Ship
     *
     * @param draft draft of the ship
     */
    public void setDraft(double draft) {
        this.draft = draft;
    }

    /**
     * Adds to the position data AVL tree a new position data
     *
     * @param positionData position data to add
     */
    public void addPositionData(PositionData positionData) {
        this.treeOfPositionData.insert(positionData);
    }

    /**
     * Returns the tree of Position Data
     *
     * @return tree of position Data
     */
    public TreeOfPositionData getTreeOfPositionData() {
        return treeOfPositionData;
    }


    //////////////////////////////////////////////////////////// SHIP INFO ///////////////////////////////////////////////////////////////////////


    /**
     * Getter for the Start Base Date Time
     *
     * @return initial time
     */
    public LocalDateTime initialDate() {
        return treeOfPositionData.initialDate();
    }

    /**
     * Getter for the End Base Date Time
     *
     * @return end time
     */
    public LocalDateTime finalDate() {
        return treeOfPositionData.finalDate();
    }

    /**
     * Getter for the total movement time
     *
     * @return total movement time in seconds
     */
    public long totalMovementTime() {
        return treeOfPositionData.getTotalMovementTime();
    }

    /**
     * Getter for total Number of movements of a ship
     *
     * @return total Number of movements
     */
    public Integer getTotalMovements() {
        return treeOfPositionData.getTotalMovements();
    }

    /**
     * Getter for maximum SOG
     *
     * @return maximum SOG
     */
    public double getMaxSOG() {
        return treeOfPositionData.maxSOG();
    }

    /**
     * Getter for mean SOG
     *
     * @return mean SOG
     */
    public double getMeanSOG() {
        return treeOfPositionData.meanSOG();
    }

    /**
     * Getter for the max COG
     *
     * @return max COG
     */
    public double getMaxCOG() {
        return treeOfPositionData.maxCOG();
    }

    /**
     * Getter for the mean COG
     *
     * @return mean COG
     */
    public double getMeanCOG() {
        return treeOfPositionData.meanCOG();
    }

    /**
     * Calculates the departure latitude of a vessel
     *
     * @return double departure latitude
     */
    public double departureLatitude() {
        return treeOfPositionData.departureLatitude();
    }

    /**
     * Calculates the departure longitude of a vessel
     *
     * @return double departure longitude
     */
    public double departureLongitude() {
        return treeOfPositionData.departureLongitude();
    }

    /**
     * Calculates the arrival latitude of a vessel
     *
     * @return double arrival latitude
     */
    public double arrivalLatitude() {
        return treeOfPositionData.arrivalLatitude();
    }

    /**
     * Calculates the arrival longitude of a vessel
     *
     * @return double arrival longitude
     */
    public double arrivalLongitude() {
        return treeOfPositionData.arrivalLongitude();
    }

    /**
     * Getter for the travelled distance
     * @return travelled distance
     */
    public double travelledDistance() {
        return treeOfPositionData.travelledDistance();
    }

    /**
     * Getter for the delta distance
     * @return delta distance
     */
    public double getDeltaDistance() {
        return treeOfPositionData.getDeltaDistance();
    }

    public double meanSOG(LocalDateTime date1, LocalDateTime date2) {
        return treeOfPositionData.meanSOG(date1, date2);
    }

    /**
     * Methods of Tree Of Position Data
     */
    public double travelledDistanceBtDates(LocalDateTime date1, LocalDateTime date2) {
        return treeOfPositionData.travelledDistanceBtDates(date1, date2);
    }

    public boolean atLeastTwo(LocalDateTime date1, LocalDateTime date2) {
        return treeOfPositionData.atLeastTwo(date1, date2);
    }



    /**
     * -------------------------------------------------------------------------------------------------------------
     * TO STRING
     * -------------------------------------------------------------------------------------------------------------
     */

    @Override
    public String toString() {
        return "Ship{" +
                "MMSI=" + MMSI +
                ", name='" + name + '\'' +
                ", IMO=" + IMO +
                ", callSign='" + callSign + '\'' +
                ", vesselType=" + vesselType +
                ", length=" + length +
                ", width=" + width +
                ", draft=" + draft +
                '}' + '\n' + treeOfPositionData;
    }

    public String toStringMMSIMovementsTravelledDistanceDeltaDistance() {
        return String.format("Ship{MMSI= %d, Total number of movements='%d', Travelled Distance='%.2f', Delta Distance='%.2f'}", this.getMMSI(), this.getTotalMovements(), this.travelledDistance(), this.getDeltaDistance());
    }

    /**
     * Compare method
     * @param o ship to compare with
     * @return in value
     */
    @Override
    public abstract int compareTo(Ship o);


}
