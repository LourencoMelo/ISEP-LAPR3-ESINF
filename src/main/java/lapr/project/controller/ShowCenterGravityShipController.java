package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.App;

import java.util.List;

public class ShowCenterGravityShipController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     * Contructor of ShowCenterGravityShipController
     * @param company
     */
    public ShowCenterGravityShipController(Company company){
        this.company = company;
    }

    /**
     * Contructor of ShowCenterGravityShipController
     */
    public ShowCenterGravityShipController(){
        this(App.getInstance().getCompany());
    }

    public List<String[][]> centerOfGravityEmptyShipController(Ship ship){
        return company.centerOfGravityEmptyShip(ship);
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }
}
