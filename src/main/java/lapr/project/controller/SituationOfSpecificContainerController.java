package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Container;
import lapr.project.utils.App;

public class SituationOfSpecificContainerController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     *  Constructor of AllocateCargoManifestToPortController
     */
    public SituationOfSpecificContainerController(){
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of AllocateCargoManifestToPortController
     */
    public SituationOfSpecificContainerController(Company company){
        this.company = company;
    }

    public Container situationOfSpecificContainer(){
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
