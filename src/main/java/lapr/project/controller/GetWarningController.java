package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

public class GetWarningController {
    /**
     * Creates instance of company
     */
    Company company;

    /**
     *  Constructor of GetWarningController
     */
    public GetWarningController(){
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of GetWarningController
     */
    public GetWarningController(Company company){
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
    public String getWarning(){
        return null;
    }
}
