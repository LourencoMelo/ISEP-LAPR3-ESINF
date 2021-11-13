package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.App;

import java.time.LocalDateTime;
import java.util.*;

public class TopNController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     * Constructor of TopNController
     */
    public TopNController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor of TopNController
     * @param company
     */
    public TopNController(Company company){
        this.company = company;
    }

    /**
     * getTopShipsWithMostKmByVesselType in controller
     *
     * @param date1
     * @param date2
     * @param n
     * @param vType
     * @return map
     */
    public Map<Ship, Double> getTopShipsWithMostKmByVesselType(LocalDateTime date1, LocalDateTime date2, int n, int vType){
        return company.getTopShipsWithMostKmByVesselType(date1,date2,n,vType);
    }

    /**
     * getVesselTypes
     *
     * @return list
     */
    public List<Integer> getVesselTypes(){
        return company.getVesselTypes();
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }

}
