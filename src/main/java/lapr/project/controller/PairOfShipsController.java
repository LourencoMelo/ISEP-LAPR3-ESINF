package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Pair;
import lapr.project.model.Ship;
import lapr.project.utils.App;

import javax.print.DocFlavor;
import java.util.List;

public class PairOfShipsController {

    public Company company;

    public PairOfShipsController() {
        this(App.getInstance().getCompany());
    }

    public PairOfShipsController(Company company){
        this.company = company;
    }

    public List<Pair<Ship, Ship>> getPairShips(){
        return company.getPairShips();
    }
}
