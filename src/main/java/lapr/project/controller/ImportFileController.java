package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.App;

import java.io.File;

public class ImportFileController {

    private Company company;

    public ImportFileController() {
        this(App.getInstance().getCompany());
    }

    public ImportFileController(Company company){
        this.company = company;
    }

    public void import_ships(File file){
        this.company.getTreeOfShips().createTreeMMSI(file);
        this.company.getTreeOfShipsIMO().createTreeIMO(file);
        this.company.getTreeOfShipsCallSign().createTreeCallSign(file);
    }

    public String getTreeOfShips(){
       return this.company.getTreeOfShips().toString();
    }

    public String getTreeOfShips2(){
        return this.company.getTreeOfShipsIMO().toString();
    }

    public String getTreeOfShips3(){
        return this.company.getTreeOfShipsCallSign().toString();
    }

    public Ship getShipByMMSI(int MMSI) {
        return company.getTreeOfShips().getShipByMMSI(MMSI);
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }
}
