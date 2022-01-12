package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.PortAndCapital;
import lapr.project.utils.App;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class GetShipVoyagesBelowThresholdController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     *  Constructor of GetShipVoyagesBelowThresholdController
     */
    public GetShipVoyagesBelowThresholdController(){
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of GetShipVoyagesBelowThresholdController
     */
    public GetShipVoyagesBelowThresholdController(Company company){
        this.company = company;
    }

    /**
     * Ship voyages – place and date of origin and destination
     * Below threshold
     * @return
     */
    public Map<List<PortAndCapital>,List<LocalDateTime>> getShipVoyagesBelowThresholdController(){
        double thresholdDefault = 0.66;
        return null;
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }

}
