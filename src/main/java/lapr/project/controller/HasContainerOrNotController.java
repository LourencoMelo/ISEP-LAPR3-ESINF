package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.PositionData;
import lapr.project.utils.App;

public class HasContainerOrNotController {

    /**
     * Company instance
     */
    private Company company;

    /**
     * Constructor to get the same company as the other controllers
     */
    public HasContainerOrNotController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor to associate the company of this controller to the company received with parameter
     * @param company instance
     */
    public HasContainerOrNotController(Company company) {
        this.company = company;
    }

    //to develelop with the ARQCP students.
    public String hasContainerOrNot(String callSign, PositionData positionData, String containerId) {
        return null;
    }

    public Company getCompany() {
        return company;
    }

}
