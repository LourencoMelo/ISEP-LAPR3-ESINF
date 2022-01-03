package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.PortAndCapital;
import lapr.project.utils.App;

import java.util.Map;

public class TopClosenessByContinentController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     * Constructor of TopClosenessByContinentController
     * @param company
     */
    public TopClosenessByContinentController(Company company){
        this.company = company;
    }

    /**
     * Constructor of TopClosenessByContinentController
     */
    public TopClosenessByContinentController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Method that returns the TopN Closeness Places by Continent
     * @param topN topN that the user wants to know
     * @param continent the continent used
     * @return map with all the information needed
     */
    public Map<Double, PortAndCapital> topClosenessByContinentController(int topN, String continent){
        return company.getGraphGenerator().topClosenessByContinent(topN, continent);
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }
}
