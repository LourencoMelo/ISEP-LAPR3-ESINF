package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.App;

import java.util.Map;

public class GetShipIdleDaysOfYearController {
    /**
     * Creates instance of company
     */
    Company company;

    /**
     *  Constructor of GetShipIdleDaysOfYearController
     */
    public GetShipIdleDaysOfYearController(){
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of GetShipIdleDaysOfYearController
     */
    public GetShipIdleDaysOfYearController(Company company){
        this.company = company;
    }

    /**
     * Gets the Days the Ships as been idle on the current Year
     * @return int that represents the days
     */
    public Map<Ship, Integer> getShipIdleDaysOfYearController(){
        return null;
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany(){
        return company;
    }

}
