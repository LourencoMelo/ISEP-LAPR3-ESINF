package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

import java.time.LocalDateTime;

public class GetShipOccupancyRateController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     * Contructor of GetShipOccupancyRateController
     * @param company
     */
    public GetShipOccupancyRateController(Company company){
        this.company = company;
    }

    /**
     * Contructor of GetShipOccupancyRateController
     */
    public GetShipOccupancyRateController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Returns the occupancy rate of a given ship at a given moment.
     */
    public double getShipOccupancyRateController(int shipMMSI, LocalDateTime dateTime){
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
