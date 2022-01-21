package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.PortAndWareHouse;
import lapr.project.utils.App;

import java.util.List;
import java.util.Map;

public class ListNCentralityPortsController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     * Empty contructor
     */
    public ListNCentralityPortsController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor
     * @param company company object
     */
    public ListNCentralityPortsController(Company company) {
        this.company = company;
    }

    /**
     * Gets the n ports with greater centrality
     * @param n number of ports wanted
     * @return n ports
     */
    public Map<PortAndWareHouse, Integer> getNPorts(int n) {
        return this.company.getGraphGenerator().listOfNPortsCentrality(n);
    }

    /**
     * Getter for company object
     * @return company
     */
    public Company getCompany() {
        return company;
    }
}
