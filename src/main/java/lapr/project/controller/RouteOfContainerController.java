package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

import java.util.List;

public class RouteOfContainerController {
    /**
     * Creates instance of company
     */
    Company company;

    /**
     *  Constructor of RouteOfContainerController
     */
    public RouteOfContainerController(){
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of RouteOfContainerController
     */
    public RouteOfContainerController(Company company){
        this.company = company;
    }

    /**
     * Returns the company instance
     * @return company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Route of a specific container
     * @param container container
     * @return route of container
     */
    public List<String> getRouteOfContainer(String container){
        return null;
    }
}
