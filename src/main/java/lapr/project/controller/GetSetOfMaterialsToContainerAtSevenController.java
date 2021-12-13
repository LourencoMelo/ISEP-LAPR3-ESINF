package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

import java.util.List;

public class GetSetOfMaterialsToContainerAtSevenController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     *  Constructor of GetSetOfMaterialsToContainerAtSevenController
     */
    public GetSetOfMaterialsToContainerAtSevenController(){
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of GetSetOfMaterialsToContainerAtSevenController
     */
    public GetSetOfMaterialsToContainerAtSevenController(Company company){
        this.company = company;
    }

    public List<String> getSetOfMaterialsToContainerAtSevenController(){
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

