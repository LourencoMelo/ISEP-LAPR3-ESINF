package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.App;

import java.util.List;

public class GetListShipsAvailableMondayNextWeekController {

    /**
     * Company instance
     */
    private Company company;

    /**
     * Constructor to get the same company as the other controllers
     */
    public GetListShipsAvailableMondayNextWeekController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor to associate the company of this controller to the company received with parameter
     * @param company instace
     */
    public GetListShipsAvailableMondayNextWeekController(Company company) {
        this.company = company;
    }

    public List<Ship> getListShipsAvailableMondayNextWeek() {
        return null;
    }

    public Company getCompany() {
        return company;
    }
}