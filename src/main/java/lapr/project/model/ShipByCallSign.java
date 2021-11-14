package lapr.project.model;

public class ShipByCallSign extends Ship{


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
    public ShipByCallSign(int MMSI, String name, String IMO, String callSign, int vesselType, double length, double width, double draft) {
        super(MMSI, name, IMO, callSign, vesselType, length, width, draft);
    }

    /**
     * Empty Constructor
     */
    public ShipByCallSign() {
    }

    /**
     * Compare to of the class
     * @param o ship to compare with
     * @return int
     */
    @Override
    public int compareTo(Ship o) {
        return this.getCallSign().compareTo(o.getCallSign());
    }
}
