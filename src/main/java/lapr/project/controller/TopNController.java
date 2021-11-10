package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.AVL;
import lapr.project.utils.App;
import lapr.project.utils.TreeOfShips;

import java.time.LocalDateTime;
import java.util.*;

public class TopNController extends AVL<Ship> {

    Company company;

    public TopNController() {
        this(App.getInstance().getCompany());
    }

    public TopNController(Company company){
        this.company = company;
    }

    /**
     * For each Vessel Type this method will give the TOP-N ships with the most kilometres travelled and their respective average speed
     * @param date1 initial date
     * @param date2 final date
     * @param n N ships
     */
    public void getTopShipsWithMostKm(LocalDateTime date1, LocalDateTime date2, int n){
        company.getTopShipsWithMostKm(date1,date2,n);
    }






}
