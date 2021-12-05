package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Container;
import lapr.project.utils.App;

import java.util.Collections;
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

    /**
     * Return the list of containers asked
     * @return list of containers
     */
    public List<Container> getListContainerToBeOffloaded(String portCode) {
        return Collections.emptyList();
    }

    /**
     * Returns company
     * @return company
     */
    public Company getCompany() {
        return company;
    }
}
