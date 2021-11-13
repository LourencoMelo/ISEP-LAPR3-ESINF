package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.PositionData;
import lapr.project.model.Ship;
import lapr.project.utils.App;

import java.util.HashMap;
import java.util.Set;

public class GetShipPositionByDateController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     *  Constructor of GetShipPositionByDateController
     */
    public GetShipPositionByDateController(){
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of GetShipPositionByDateController
     */
    public GetShipPositionByDateController(Company company){
        this.company = company;
    }

    /**
     * Gets Ship Position Messages Ordered by Date in the company
     * @param ship
     * @return hashmap
     */
    public HashMap<Ship, Set<PositionData>> getShipPositionMessagesOrderByDateController(Ship ship){
        return this.company.getShipPositionMessagesOrderByDate(ship);
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }
}
