package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

public class PairOfShipsController {

    public Company company;

    public PairOfShipsController() {
        this(App.getInstance().getCompany());
    }

    public PairOfShipsController(Company company){
        this.company = company;
    }

    public void getPairShips(){
        company.getPairShips();
    }
}
