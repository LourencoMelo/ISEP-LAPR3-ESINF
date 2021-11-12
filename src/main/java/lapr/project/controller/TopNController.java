package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.App;

import java.time.LocalDateTime;
import java.util.*;

public class TopNController {

    Company company;

    public TopNController() {
        this(App.getInstance().getCompany());
    }

    public TopNController(Company company){
        this.company = company;
    }


    public Map<Ship, Double> getTopShipsWithMostKmByVesselType(LocalDateTime date1, LocalDateTime date2, int n, int vType){
        return company.getTopShipsWithMostKmByVesselType(date1,date2,n,vType);
    }

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
