package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.App;

public class HowMuchShipSinkController {

    /**
     * Creates Instance of Company
     */
    Company company;

    /**
     * Constructor of HowMuchShipSinkController
     */
    public HowMuchShipSinkController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor of HowMuchShipSinkController
     * @param company
     */
    public HowMuchShipSinkController(Company company){
        this.company = company;
    }

    /**
     * Calculates the total mass
     * (Ship deadweight and containers)
     * @param ship
     * @return totalMass
     */
    public double calculateTotalMassController(Ship ship){
       return company.calculateTotalMass(ship);
    }

    /**
     * Calculates the difference of the heights
     * When the containers are not loaded
     * Compared when they are loaded
     * Controller
     * @param ship
     * @param totalMass
     * @param shipDeadWeight
     * @param typeOfWater
     * @return difference of heights
     */
    public double calculateDiffHeightsController(Ship ship, double totalMass, double shipDeadWeight, int typeOfWater){
        return company.calculateDiffHeights(ship,totalMass,shipDeadWeight, typeOfWater);
    }

    /**
     * Calculating Pressure on water By area
     * N/m^2  Controller
     * @param ship
     * @param totalMass
     * @param typeOfWater
     * @return
     */
    public double calculatePressureOnWaterController(Ship ship, double totalMass, int typeOfWater){
        return company.calculatePressureOnWater(ship, totalMass, typeOfWater);
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }
}
