package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

public class GetOccupancyRateCargoManifestController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     * Contructor of GetOccupancyRateCargoManifestController
     * @param company
     */
    public GetOccupancyRateCargoManifestController(Company company){
        this.company = company;
    }
    /**
     * Contructor of GetOccupancyRateCargoManifestController
     */
    public GetOccupancyRateCargoManifestController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Returns the occupancy rate (percentage) of a given ship for a given cargo manifest
     * Occupancy rate is the ratio between total number of containers
     * in the ship coming from a given manifest and the total capacity of the ship, i.e., the
     * maximum number of containers the ship can load.
     * @return percentage
     */
    public double getOccupancyRateCargoManifestController(String cargoManifestId){
        return 0;
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }
}
