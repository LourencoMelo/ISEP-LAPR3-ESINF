package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.App;

import java.util.List;

public class MovementsTravelledAndDeltaDistanceController {

    private Company company;

    public MovementsTravelledAndDeltaDistanceController() {
        this(App.getInstance().getCompany());
    }

    public MovementsTravelledAndDeltaDistanceController(Company company) {
        this.company = company;
    }

    public List<Ship> listMovementsTravelledAndDeltaDistance() {
        return this.company.printMovementsTravelledAndDeltaDistance();
    }

    public Company getCompany() {
        return company;
    }
}
