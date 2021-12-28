package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Country;
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
     */
    public void generate(File countriesFile, File bordersFile){
        company.generateGraph(countriesFile,bordersFile);
        for (Country country : company.getCountryList()) {
            System.out.println(country.getTree_of_ports());
        }

    }

    /**
     * Text description of graph
     * @return graph to string
     */
    public String graphToString(){
        return company.getGraphGenerator().getGraph().toString();
    }

}
