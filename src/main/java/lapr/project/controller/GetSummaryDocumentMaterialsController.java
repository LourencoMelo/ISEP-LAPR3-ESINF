package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

import java.util.List;

public class GetSummaryDocumentMaterialsController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     *  Constructor of GetSetOfMaterialsToContainerAtSevenController
     */
    public GetSummaryDocumentMaterialsController(){
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of GetSetOfMaterialsToContainerAtSevenController
     */
    public GetSummaryDocumentMaterialsController(Company company){
        this.company = company;
    }

    /**
     * Returns the summary of document
     * the choice of materials considered for the two types of containers considered,
     * and their thermal resistances.
     */
    public List<String> getSummaryDocumentMaterialsController(){
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
