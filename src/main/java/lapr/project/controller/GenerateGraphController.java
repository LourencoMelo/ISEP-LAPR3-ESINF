package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

import java.io.File;

public class GenerateGraphController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     * Empty Constructor
     */
    public GenerateGraphController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Contructor to initialize company
     * @param company instance of company
     */
    public GenerateGraphController(Company company) {
        this.company = company;
    }

    /**
     * Generates graph
     * @param countriesFile file path with all countries
     * @param bordersFile file path with all borders
     * @param seadists file path with all seadists
     * @param n number of closest ports connections
     */
    public void generate(File countriesFile, File bordersFile, File seadists, int n){
        company.generateGraph(countriesFile,bordersFile, seadists, n);

    }

    /**
     * Text description of graph
     * @return graph to string
     */
    public String graphToString(){
        return company.getGraphGenerator().getGraph().toString();
    }

    /**
     * Gets the company instance
     * @return company instance
     */
    public Company getCompany() {
        return company;
    }
}
