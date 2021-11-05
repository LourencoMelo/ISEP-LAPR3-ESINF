package lapr.project.model;

public class Ship {

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
    private int IMO;
    /**
     * Number of Energy Generators present in the Ship
     */
    private int numberEnergyGenerator;
    /**
     * PowerOutput of the Ship
     */
    private int powerOutput;
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
     * Maximum Capacity of the ship
     */
    private int maximumCapacity;
    /**
     * Draft of the Ship
     */
    private double draft;

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                               CONSTRUCTOR
     * -------------------------------------------------------------------------------------------------------------
     */
    public Ship(int MMSI, String name, int IMO, int numberEnergyGenerator, int powerOutput, String callSign, int vesselType, double length, double width, int maximumCapacity, double draft) {
       setMMSI(MMSI);
       setName(name);
       setIMO(IMO);
       setNumberEnergyGenerator(numberEnergyGenerator);
       setPowerOutput(powerOutput);
       setCallSign(callSign);
       setVesselType(vesselType);
       setLength(length);
       setWidth(width);
       setMaximumCapacity(maximumCapacity);
       setDraft(draft);
    }

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                              GETS AND SETS
     * -------------------------------------------------------------------------------------------------------------
     */


    /**
     * Returns MMSI of the Ship
     * @return MMSI
     */

    public int getMMSI() {
        return MMSI;
    }

    /**
     * Sets the MMSI of the Ship
     * @param MMSI
     */
    public void setMMSI(int MMSI) {
        this.MMSI = MMSI;
    }

    /**
     * Returns the Name of the Ship
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Name of the Ship
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the IMO of the Ship
     * @return IMO
     */
    public int getIMO() {
        return IMO;
    }

    /**
     * Sets the IMO of the Ship
     * @param IMO
     */
    public void setIMO(int IMO) {
        this.IMO = IMO;
    }

    /**
     * Returns the Number of Energy Generators present in the Ship
     * @return numberEnergyGenerator
     */
    public int getNumberEnergyGenerator() {
        return numberEnergyGenerator;
    }

    /**
     * Sets the Number of Energy Generators present in the Ship
     * @param numberEnergyGenerator
     */
    public void setNumberEnergyGenerator(int numberEnergyGenerator) {
        this.numberEnergyGenerator = numberEnergyGenerator;
    }

    /**
     * Returns the PowerOutput of the Ship
     * @return powerOutput
     */
    public int getPowerOutput() {
        return powerOutput;
    }

    /**
     * Sets the PowerOutput of the Ship
     * @param powerOutput
     */
    public void setPowerOutput(int powerOutput) {
        this.powerOutput = powerOutput;
    }

    /**
     * Returns the CallSign of the Ship
     * @return callSign
     */
    public String getCallSign() {
        return callSign;
    }

    /**
     * Sets the CallSign of the Ship
     * @param callSign
     */
    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    /**
     * Returns the VesselType of the Ship
     * @return vesselType
     */
    public int getVesselType() {
        return vesselType;
    }

    /**
     * Sets the VesselType of the Ship
     * @param vesselType
     */
    public void setVesselType(int vesselType) {
        this.vesselType = vesselType;
    }

    /**
     * Returns the Length of the Ship
     * @return length
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets the Length of the Ship
     * @param length
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Returns the Width of the Ship
     * @return width
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the Width of the Ship
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Returns the MaximumCapacity of the Ship
     * @return maximumCapacity
     */
    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    /**
     * Sets the MaximumCapacity of the Ship
     * @param maximumCapacity
     */
    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    /**
     * Returns the Draft of the Ship
     * @return draft
     */
    public double getDraft() {
        return draft;
    }

    /**
     * Sets the Draft of the Ship
     * @param draft
     */
    public void setDraft(double draft) {
        this.draft = draft;
    }
}
