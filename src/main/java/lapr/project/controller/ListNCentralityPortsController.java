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

    public ListNCentralityPortsController() {
        this(App.getInstance().getCompany());
    }

    public ListNCentralityPortsController(Company company) {
        this.company = company;
    }

    public Map<PortAndWareHouse, Integer> getNPorts(int n) {
        return this.company.getGraphGenerator().listOfNPortsCentrality(n);
    }

}
