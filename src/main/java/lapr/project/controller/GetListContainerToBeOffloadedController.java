package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Container;
import lapr.project.utils.App;

import java.util.List;

public class GetListContainerToBeOffloadedController {

    /**
     * Company instance
     */
    private Company company;

    /**
     * Constructor to get the same company as the other controllers
     */
    public GetListContainerToBeOffloadedController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor to associate the company of this controller to the company received with parameter
     * @param company instace
     */
    public GetListContainerToBeOffloadedController(Company company) {
        this.company = company;
    }

    public List<Container> getListContainerToBeOffloaded() {
        return null;
    }

    public Company getCompany() {
        return company;
    }
}
