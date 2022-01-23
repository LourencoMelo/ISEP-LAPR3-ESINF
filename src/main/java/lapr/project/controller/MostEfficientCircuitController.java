package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.PortAndCapital;
import lapr.project.model.PositionData;
import lapr.project.utils.App;

import java.util.LinkedList;

public class MostEfficientCircuitController {

    /**
     * Company instance
     */
    private Company company;

    /**
     * Constructor to get the same company as the other controllers
     */
    public MostEfficientCircuitController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor to associate the company of this controller to the company received with parameter
     * @param company instance
     */
    public MostEfficientCircuitController(Company company) {
        this.company = company;
    }

    /**
     * Find hamiltonian path
     * @param start starting vertex
     * @return final path
     */
    public LinkedList<PortAndCapital> getMostEfficientCircuit(String start) {
         return this.company.getGraphGenerator().getMostEfficientCircuit(company.getGraphGenerator().getVerticesByName(start));
    }

    /**
     * Get company instance
     * @return company instace
     */
    public Company getCompany() {
        return company;
    }
}
