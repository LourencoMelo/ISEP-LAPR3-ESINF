package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.App;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ShowCenterGravityLoadedController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     * Constructor of ShowCenterGravityLoadedController
     * @param company
     */
    public ShowCenterGravityLoadedController(Company company){
        this.company = company;
    }

    /**
     * Constructor of ShowCenterGravityLoadedController
     */
    public ShowCenterGravityLoadedController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Method that returns the Center Of Gravity
     * When the ship is loaded
     * @param ship
     * @param matrixLevels
     * @return map with the info
     */
    public Map<List<Double>, String[][]> showCenterOfGravityController(Ship ship, Map<Integer, double[][]> matrixLevels){
        return company.showCenterOfGravity(ship, matrixLevels);
    }

    public void containerImportController(File file, Ship ship){
        company.containerImport(file,ship);
    }

    public Map<Integer, double[][]> allocatingContainersController(Ship ship){
        return company.allocatingContainers(ship);
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }


}
