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

    /**
     * Gets the closest port of a ship on a certain date
     * @param callSign ship call sign
     * @param date wanted date
     * @return closest port
     */
    public PortAndWareHouse getClosest(String callSign, LocalDateTime date){
        return company.getClosest(callSign,date);
    }

    /**
     * Returns the company instance
     * @return company
     */
    public Company getCompany() {
        return company;
    }


}
