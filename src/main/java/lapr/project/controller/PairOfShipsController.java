package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Pair;
import lapr.project.model.Ship;
import lapr.project.utils.App;


import java.util.List;

public class PairOfShipsController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     * Constructor of PairOfShipsController
     */
    public PairOfShipsController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor of PairOfShipsController
     * @param company
     */
    public PairOfShipsController(Company company){
        this.company = company;
    }

    /**
     * Gets Pair Of Ships of the company
     *
     * @return list
     */
    public List<Pair<Ship, Ship>> getPairShips(){
        return company.getPairShips();
    }

    /**
     * Gets company
     * @return company
     */
    public Company getCompany(){
        return company;
    }

}
