package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.TreeOfShips;

import java.io.File;

public class ImportFileController {

    private Company company;

    public ImportFileController() {
        this.company = new Company();
    }

    public void import_ships(File file){
        this.company.getTreeOfShips().createTree(file);
    }

    public String getTreeOfShips(){
       return this.company.getTreeOfShips().toString();
    }

}
