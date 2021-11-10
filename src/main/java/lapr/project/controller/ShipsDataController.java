package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.App;

import java.time.LocalDateTime;

public class ShipsDataController {

    private Company company;

    public ShipsDataController() {
        this(App.getInstance().getCompany());
    }

    public ShipsDataController(Company company) {
        this.company = company;
    }

    /**
     * Getter method for Vessel Name
     *
     * @param ship vessel to return info
     * @return vessel name
     */
    public String getVesselName(Ship ship) {
        return ship.getName();
    }

    /**
     * Getter method for Start Base Date Time
     *
     * @param ship vessel to return info
     * @return Start Base Date Time
     */
    public LocalDateTime getStartBaseDateTime(Ship ship) {
        return ship.getTreeOfPositionData().initialDate();
    }

    /**
     * Getter method for End Base Date Time
     *
     * @param ship vessel to return info
     * @return End Base Date Time
     */
    public LocalDateTime getEndBaseDateTime(Ship ship) {
        return ship.getTreeOfPositionData().finalDate();
    }

    /**
     * Getter method for Total Movement Time in seconds
     *
     * @param ship vessel to return info
     * @return Total Movement Time
     */
    public long getTotalMovementTime(Ship ship) {
        return ship.getTreeOfPositionData().getTotalMovementTime();
    }


    /**
     * Getter method for Total Number of Movements
     *
     * @param ship vessel to return info
     * @return Total Number of Movements
     */
    public int getTotalNumberOfMovements(Ship ship) {
        return ship.getTreeOfPositionData().getTotalMovements();
    }


    /**
    * Getter method for Max SOG
     *
     *@param ship vessel to return info
     *@return Max SOG
     */
    public double getMaxSOG(Ship ship) {
        return  ship.getTreeOfPositionData().maxSOG();
    }

    /**
     * Getter method for Mean SOG
     *
     * @param ship vessel to return info
     * @return Mean SOG
     */
    public double getMeanSOG(Ship ship) {
        return ship.getTreeOfPositionData().meanSOG();
    }

    /**
     * Getter method for Max COG
     *
     * @param ship vessel to return info
     * @return Max COG
     */
    public double getMaxCOG(Ship ship) {
        return ship.getTreeOfPositionData().maxCOG();
    }

    /**
     * Getter method for Mean COG
     *
     * @param ship vessel to return info
     * @return MeanCOG
     */
    public double getMeanCOG(Ship ship) {
        return ship.getTreeOfPositionData().meanCOG();
    }

    /**
     * Getter method for Departure Latitude
     *
     * @param ship vessel to return info
     * @return Departure Latitude
     */
    public double getDepartureLatitude(Ship ship) {
        return ship.getTreeOfPositionData().departureLatitude();
    }


    /**
     * Getter method for Departure Longitude
     *
     * @param ship vessel to return info
     * @return Departure Longitude
     */
    public double getDepartureLongitude(Ship ship) {
        return ship.getTreeOfPositionData().departureLongitude();
    }

    /**
     * Getter method for Arrival Latitude
     *
     * @param ship vessel to return info
     * @return Arrival Latitude
     */
    public double getArrivalLatitude(Ship ship) {
        return ship.getTreeOfPositionData().arrivalLatitude();
    }

    /**
     * Getter method for Arrival Longitude
     *
     * @param ship vessel to return info
     * @return Arrival Longitude
     */
    public double getArrivalLongitude(Ship ship) {
        return ship.getTreeOfPositionData().arrivalLongitude();
    }

    /**
     * Getter method for Travelled Distance
     *
     * @param ship vessel to return info
     * @return Travelled Distance
     */
    public double getTravelledDistance(Ship ship) {
        return ship.getTreeOfPositionData().travelledDistance();
    }

    /**
     * Getter method for Delta Distance
     *
     * @param ship vessel to return info
     * @return Delta Distance
     */
    public double getDeltaDistance(Ship ship) {
        return ship.getTreeOfPositionData().getDeltaDistance();
    }
}
