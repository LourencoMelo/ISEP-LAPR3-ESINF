package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

import java.util.List;

public class AuditTrailsController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     *  Constructor of AuditTrailsController
     */
    public AuditTrailsController(){
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of AuditTrailsController
     */
    public AuditTrailsController(Company company){
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
     * Returns a list of all operations performed on
     * a given container of a given manifest
     * @param container given container
     * @param cargo given cargo manifest
     * @return list of operations performed
     */
    public List<String> getAuditTrails(String container, String cargo){
        return null;
    }
}
