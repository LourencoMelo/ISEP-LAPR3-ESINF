package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.App;

import java.io.File;

public class ImportFileController {

    /**
     * Creates instance of company
     */
    private Company company;

    /**
     *  Constructor of ImportFileController
     */
    public ImportFileController() {
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of ImportFileController
     */
    public ImportFileController(Company company){
        this.company = company;
    }

    /**
     * Imports the Ships and creates the trees
     * @param file
     */
    public void importShips(File file){
        this.company.getTreeOfShips().createTreeMMSI(file);
        this.company.getTreeOfShipsIMO().createTreeIMO(file);
        this.company.getTreeOfShipsCallSign().createTreeCallSign(file);
    }


    /**
     * Gets the TreeOfShips
     * @return treeOfShips in a string
     */
    public String getTreeOfShips(){
       return this.company.getTreeOfShips().toString();
    }

    /**
     * Gets the TreeOfShipsIMO
     * @return treeOfShipsIMO in a string
     */
    public String getTreeOfShips2(){
        return this.company.getTreeOfShipsIMO().toString();
    }

    /**
     * Gets the TreeOfShipsCallSign
     * @return TreeOfShipsCallSign in a string
     */
    public String getTreeOfShips3(){
        return this.company.getTreeOfShipsCallSign().toString();
    }

    /**
     * Gets the Ship by MMSI
     * @param mmsi
     * @return TreeIfShipsMMSI
     */
    public Ship getShipByMMSI(int mmsi) {
        return company.getTreeOfShips().getShipByMMSI(mmsi);
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }
}
