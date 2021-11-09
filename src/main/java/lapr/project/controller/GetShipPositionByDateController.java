package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.PositionData;
import lapr.project.model.Ship;
import lapr.project.utils.App;

import java.util.HashMap;
import java.util.Set;

public class GetShipPositionByDateController {

    Company company;

    public GetShipPositionByDateController(){
        this(App.getInstance().getCompany());
    }

    public GetShipPositionByDateController(Company company){
        this.company = company;
    }

    public HashMap<Ship, Set<PositionData>> getShipPositionMessagesOrderByDateController(Ship ship){
        return this.company.getShipPositionMessagesOrderByDate(ship);
    }
}
