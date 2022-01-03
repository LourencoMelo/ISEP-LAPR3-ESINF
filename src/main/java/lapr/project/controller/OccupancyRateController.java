package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

import java.util.List;

public class OccupancyRateController {
    /**
     * Creates instance of company
     */
    Company company;

    /**
     *  Constructor of OccupancyRateController
     */
    public OccupancyRateController(){
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of OccupancyRateController
     */
    public OccupancyRateController(Company company){
        this.company = company;
    }

    /**
     * Returns the company instance
     * @return company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Occupancy Rate of each warehouse
     * @return route of container
     */
    public List<String> getOccupancyRate(){
        return null;
    }
}
