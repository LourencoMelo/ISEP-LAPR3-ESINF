package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

import java.io.File;

public class ImportPortsController {

    /**
     * Creates instance of company
     */
    private final Company company;


    /**
     * Empty constructor
     */
    public ImportPortsController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor
     * @param company company instance
     */
    public ImportPortsController(Company company) {
        this.company = company;
    }

    /**
     * Imports ports from txt file
     * @param file file with data
     */
    public void importPorts(File file){
        this.company.getTreeOfPorts().generateKDTREEOfPorts(file);
    }

    /**
     * Inormation printed
     * @return string with tree of ports
     */
    public String getKdTreeOfPorts(){
        return this.company.getTreeOfPorts().toString();
    }

    /**
     * getter method for company
     * @return company instance
     */
    public Company getCompany() {
        return company;
    }
}
