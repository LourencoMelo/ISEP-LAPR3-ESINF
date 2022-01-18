package lapr.project.ui;

import lapr.project.controller.GetShipByCodeController;
import lapr.project.controller.HowMuchShipSinkController;

import java.util.Scanner;

public class HowMuchShipSinkUI implements Runnable{

    Scanner in = new Scanner(System.in);

    private final HowMuchShipSinkController howMuchShipSinkController;

    private final GetShipByCodeController getShipByCodeController;

    public HowMuchShipSinkUI() {
        this.howMuchShipSinkController = new HowMuchShipSinkController();
        this.getShipByCodeController = new GetShipByCodeController();
    }

    @Override
    public void run() {
        System.out.println("=======HOW MUCH THE SHIP SUNK =========");
        double shipDeadWeight = 3000;
        System.out.println("Enter the MMSI of the ship:");
        String mmsi = in.next();
        if(getShipByCodeController.getShipByCode(mmsi).getLinkedListContainers().isEmpty()){
            System.out.println("Please Import/Load containers first on the Ship");
        }else{
            System.out.println("Total Mass:");
            double totalMass = howMuchShipSinkController.calculateTotalMassController(getShipByCodeController.getShipByCode(mmsi));
            System.out.println(totalMass + "Kg");
            System.out.println("Which type of water the ship is gonna float?(1- salt water, 2- fresh water");
            int typeOfWater = in.nextInt();
            if(typeOfWater == 1 || typeOfWater == 2){
                double diffHeights = howMuchShipSinkController.calculateDiffHeightsController(getShipByCodeController.getShipByCode(mmsi), totalMass, shipDeadWeight, typeOfWater);
                System.out.println("Difference of heights: "+ diffHeights + "m");
                double pressure = howMuchShipSinkController.calculatePressureOnWaterController(getShipByCodeController.getShipByCode(mmsi), totalMass, typeOfWater);
                System.out.println("Pressure exerted on water: " + pressure + "N/M^2");
            }else{
                System.out.println("Please insert 1 or 2 as typeOfWater!");
            }
        }

    }
}
