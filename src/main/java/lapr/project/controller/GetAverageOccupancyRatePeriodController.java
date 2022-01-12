package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.App;

import java.time.LocalDateTime;

public class GetAverageOccupancyRatePeriodController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     * Contructor of GetAverageOccupancyRatePeriodController
     */
    public GetAverageOccupancyRatePeriodController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Contructor of GetAverageOccupancyRatePeriodController
     */
    public GetAverageOccupancyRatePeriodController(Company company){
        this.company = company;
    }

    /**
     * Returns the average Occupancy Rate of a Manifest between a period of time
     * @param ship
     * @return
     */
    public double getAverageOccupancyRatePeriodController(Ship ship, LocalDateTime localDateTime, LocalDateTime localDateTime2){
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
