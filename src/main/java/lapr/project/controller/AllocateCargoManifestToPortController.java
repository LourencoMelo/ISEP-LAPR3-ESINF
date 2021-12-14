package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

public class AllocateCargoManifestToPortController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     *  Constructor of AllocateCargoManifestToPortController
     */
    public AllocateCargoManifestToPortController(){
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of AllocateCargoManifestToPortController
     */
    public AllocateCargoManifestToPortController(Company company){
        this.company = company;
    }

    /**
     * Method that fills the matrix of the port
     * And emptys the matrix of the ship in current situation
     * @param cargoManifestId
     */
    public boolean allocateCargoManifestToPortController(int cargoManifestId){
        return true;
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }

}
