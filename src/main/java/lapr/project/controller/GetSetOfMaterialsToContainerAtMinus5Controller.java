package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

import java.util.List;

public class GetSetOfMaterialsToContainerAtMinus5Controller {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     *  Constructor of GetSetOfMaterialsToContainerAtSevenController
     */
    public GetSetOfMaterialsToContainerAtMinus5Controller(){
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of GetSetOfMaterialsToContainerAtSevenController
     */
    public GetSetOfMaterialsToContainerAtMinus5Controller(Company company){
        this.company = company;
    }

    /**
     * Method that returns the materials to use at 7 degrees Celcius
     * @return listOfMaterials
     */
    public List<String> getSetOfMaterialsToContainerAtMinus5Controller(){
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
