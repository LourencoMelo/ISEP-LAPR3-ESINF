package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

public class GetNumberOfFreeOccupiedSlotsController {


    /**
     * Company instance
     */
    private Company company;

    /**
     * Constructor to get the same company as the other controllers
     */
    public GetNumberOfFreeOccupiedSlotsController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor to associate the company of this controller to the company received with parameter
     * @param company instance
     */
    public GetNumberOfFreeOccupiedSlotsController(Company company) {
        this.company = company;
    }

    //to develelop with the ARQCP students.
    public String getNumberOfFreeOccupiedSlots(String callSign) {
        return null;
    }

    public Company getCompany() {
        return company;
    }
}
