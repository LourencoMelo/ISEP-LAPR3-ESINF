package lapr.project.model;

import lapr.project.utils.TREE;
import lapr.project.utils.TreeOfPositionData;

import java.util.Comparator;
import java.util.Objects;

public class Ship implements  Comparable<Ship> {

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
     * Number of Energy Generators present in the Ship
     */
    //private int numberEnergyGenerator;
    /**
     * PowerOutput of the Ship
     */
    //private int powerOutput;
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
    //private int maximumCapacity;
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
     * @param MMSI MMSI of the Ship
     * @param name Name of the Ship
     * @param IMO IMO of the Ship
     * @param callSign CallSign of the Ship
     * @param vesselType Vessel Type of the Ship
     * @param length Length of the ship
     * @param width With of the ship
     * @param draft Draft of the Ship
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
     * -------------------------------------------------------------------------------------------------------------
     *                                              GETS AND SETS
     * -------------------------------------------------------------------------------------------------------------
     */


    //Method that adds to the tree when reading the file

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
        if(MMSI >= 100000000 && MMSI <= 999999999){
            this.MMSI = MMSI;
        }else{
            throw new IllegalArgumentException("MMSI needs to be a 9 digits unique number.");
        }
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
    public String getIMO() {
        return IMO;
    }

    /**
     * Sets the IMO of the Ship
     * @param IMO
     */
    public void setIMO(String IMO) {
        if(IMO.length() == 10){
            this.IMO = IMO;
        }else{
            throw new IllegalArgumentException("IMO needs to be a 10 digits unique number.");
        }
    }

    /**
     * Returns the Number of Energy Generators present in the Ship
     * @return numberEnergyGenerator

    public int getNumberEnergyGenerator() {
        return numberEnergyGenerator;
    }

    /**
     * Sets the Number of Energy Generators present in the Ship
     * @param numberEnergyGenerator

    public void setNumberEnergyGenerator(int numberEnergyGenerator) {
        this.numberEnergyGenerator = numberEnergyGenerator;
    }

    /**
     * Returns the PowerOutput of the Ship
     * @return powerOutput

    public int getPowerOutput() {
        return powerOutput;
    }

    /**
     * Sets the PowerOutput of the Ship
     * @param powerOutput

    public void setPowerOutput(int powerOutput) {
        this.powerOutput = powerOutput;
    }
    */
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

    public int getMaximumCapacity() {
        return maximumCapacity;
    }
*/

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

    /**
     * Adds to the position data AVL tree a new position data
     * @param positionData position data to add
     */
    public void addPositionData(PositionData positionData){
        this.treeOfPositionData.insert(positionData);
    }

    /**
     * Returns the tree of Position Data
     * @return tree of position Data
     */
    public TreeOfPositionData getTreeOfPositionData() {
        return treeOfPositionData;
    }

    /**
     * Returns total of movements of a ship
     * @return total of movements
     */
    public Integer getTotalMovements() {
        return treeOfPositionData.getTotalMovements();
    }
    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                              TO STRING
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
                '}' +  '\n' + treeOfPositionData;
    }

    @Override
    public int compareTo(Ship o) {
        return Integer.compare(this.MMSI, o.MMSI);
    }

//    /**
//     * Compares its two arguments for order.  Returns a negative integer,
//     * @param o1 the first object to be compared.
//     * @param o2 the second object to be compared.
//     * @return a negative integer, zero, or a positive integer as the
//     * first argument is less than, equal to, or greater than the
//     * second.
//     * @throws NullPointerException if an argument is null and this
//     *                              comparator does not permit null arguments
//     * @throws ClassCastException   if the arguments' types prevent them from
//     *                              being compared by this comparator.
//     */
//    @Override
//    public int compare(Ship o1, Ship o2) {
//        return 0;
//    }



    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                              COMPARE TO
     * -------------------------------------------------------------------------------------------------------------
     */





}
