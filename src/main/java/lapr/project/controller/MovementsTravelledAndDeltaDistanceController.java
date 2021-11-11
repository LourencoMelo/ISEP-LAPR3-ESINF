package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.App;

import java.util.List;

public class MovementsTravelledAndDeltaDistanceController {

    /**
     * Company instance
     */
    private Company company;

    /**
     * Constructor to get the same company as the other controllers
     */
    public MovementsTravelledAndDeltaDistanceController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor to associate the company of this controller to the company received with parameter
     * @param company instace
     */
    public MovementsTravelledAndDeltaDistanceController(Company company) {
        this.company = company;
    }

    /**
     * Return the list of Ships ordered by travelled distance and number of movements (descending/ascending)
     * @return list of ships
     */
    public List<Ship> listMovementsTravelledAndDeltaDistance() {
        return this.company.printMovementsTravelledAndDeltaDistance();
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }
}
