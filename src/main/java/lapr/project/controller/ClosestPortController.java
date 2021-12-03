package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.PortAndWareHouse;
import lapr.project.utils.App;

import java.time.LocalDateTime;

public class ClosestPortController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     * Constructor of TopNController
     */
    public ClosestPortController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor of TopNController
     * @param company
     */
    public ClosestPortController(Company company){
        this.company = company;
    }

    public PortAndWareHouse getClosest(String callSign, LocalDateTime date){
        return company.getClosest(callSign,date);
    }


}
