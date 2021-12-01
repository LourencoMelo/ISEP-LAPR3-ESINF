package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Container;
import lapr.project.utils.App;

public class GetInfoContainerController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     *  Constructor of GetInfoContainerController
     */
    public GetInfoContainerController(){
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of GetInfoContainerController
     */
    public GetInfoContainerController(Company company){
        this.company = company;
    }

    /**
     * Gets the Info of a Client's container
     * @return container
     */
    public Container getInfoContainerController(String containerID){
        return null;
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }
}
