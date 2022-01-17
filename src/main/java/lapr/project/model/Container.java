package lapr.project.model;

public class Container{

/**
 * -------------------------------------------------------------------------------------------------------------
 *                                  INFORMATION ABOUT THE CONTAINER
 * -------------------------------------------------------------------------------------------------------------
 */

    /**
     * ContainerID of the Container
     */
    private String containerID;
    /**
     * CheckDigit of the Container
     */
    private int checkDigit;
    /**
     * ISO of the Container
     */
    private String iso;
    /**
     * Gross of the Container
     */
    private int gross;
    /**
     * Tare of the Container
     */
    private int tare;
    /**
     * Payload of the Container
     */
    private int payload;
    /**
     * MaxVolume of the Container
     */
    private int maxVolume;
    /**
     * RepairRecommendation of the Container
     */
    private int repairRecommendation;

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                               CONSTRUCTORS
     * -------------------------------------------------------------------------------------------------------------
     */

    /**
     * Container Constructor
     * @param containerID ContainerID of the Container
     * @param iso ISO of the Container
     * @param gross Gross of the Container
     * @param tare Tare of the Container
     * @param payload Payload of the Container
     * @param maxVolume MaxVolume of the Container
     * @param repairRecommendation RepairRecommendation of the Container
     */
    public Container(String containerID,String iso, int gross, int tare, int payload, int maxVolume, int repairRecommendation){
        setContainerID(containerID);
        setCheckDigit(containerID);
        setIso(iso);
        setGross(gross);
        setTare(tare);
        setPayload(payload);
        setMaxVolume(maxVolume);
        setRepairRecommendation(repairRecommendation);
    }

    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                              GETS AND SETS
     * -------------------------------------------------------------------------------------------------------------
     */

    /**
     * Returns the container ID
     * @return containerID
     */
    public String getContainerID() {
        return containerID;
    }

    /**
     * Sets the Container ID
     * @param containerID containerID
     */
    public void setContainerID(String containerID) {
        if(containerID.length() == 11){
            this.containerID = containerID;
            setCheckDigit(containerID);
        }else{
            throw new IllegalArgumentException("The container ID is invalid");
        }

    }

    /**
     * Returns the CheckDigit
     * @return checkDigit
     */
    public int getCheckDigit() {
        return checkDigit;
    }

    /**
     * Sets the CheckDigit
     * @param containerID
     */
    public void setCheckDigit(String containerID) {
        this.checkDigit = Integer.valueOf(containerID.substring(containerID.length()-1));
    }

    /**
     * Returns the ISO
     * @return iso
     */
    public String getIso() {
        return iso;
    }

    /**
     * Sets the ISO
     * @param iso
     */
    public void setIso(String iso) {
        if(iso.length() == 4){
            this.iso = iso;
        }else{
            throw new IllegalArgumentException("ISO needs to be a 4 alphanumeric unique number");
        }
    }

    /**
     * Returns the Gross
     * @return gross
     */
    public int getGross() {
        return gross;
    }

    /**
     * Sets the Gross
     * @param gross
     */
    public void setGross(int gross) {
        if(gross >= 0){
            this.gross = gross;
        }else{
            throw new IllegalArgumentException("Gross needs to be 0 or a positive number");
        }

    }

    /**
     * Returns the Tare
     * @return tare
     */
    public int getTare() {
        return tare;
    }

    /**
     * Sets the Tare
     * @param tare
     */
    public void setTare(int tare) {
        if(tare >= 0){
            this.tare = tare;
        }else{
            throw new IllegalArgumentException("Tare needs to be 0 or a positive number");
        }
    }

    /**
     * Returns the Payload
     * @return payload
     */
    public int getPayload() {
        return payload;
    }

    /**
     * Sets the payload
     * @param payload
     */
    public void setPayload(int payload) {
        if(payload >= 0 && payload <= 30480){
            this.payload = payload;
        }else{
            throw new IllegalArgumentException("That's not a valid payload. Can't be a negative number or exceed 30480 kg");
        }
    }

    /**
     * Returns the MaxVolume
     * @return maxVolume
     */
    public int getMaxVolume() {
        return maxVolume;
    }

    /**
     * Sets the MaxVolume
     * @param maxVolume
     */
    public void setMaxVolume(int maxVolume) {
        this.maxVolume = maxVolume;
    }

    /**
     * Returns the repairRecommendation
     * @return repairRecommendation
     */
    public int getRepairRecommendation() {
        return repairRecommendation;
    }

    /**
     * Sets the repairRecommendation
     * @param repairRecommendation
     */
    public void setRepairRecommendation(int repairRecommendation) {
        this.repairRecommendation = repairRecommendation;
    }


    /**
     * -------------------------------------------------------------------------------------------------------------
     *                                              TO STRING
     * -------------------------------------------------------------------------------------------------------------
     */

    /**
     * To String
     * @return string with all the container info
     */
    @Override
    public String toString() {
        return "Container{" +
                "containerID='" + containerID + '\'' +
                ", checkDigit=" + checkDigit +
                ", iso='" + iso + '\'' +
                ", gross=" + gross +
                ", tare=" + tare +
                ", payload=" + payload +
                ", maxVolume=" + maxVolume +
                ", repairRecommendation=" + repairRecommendation +
                '}';
    }

}
