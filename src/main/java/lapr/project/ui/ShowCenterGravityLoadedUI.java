package lapr.project.ui;

import lapr.project.controller.GetShipByCodeController;
import lapr.project.controller.ShowCenterGravityLoadedController;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class ShowCenterGravityLoadedUI implements Runnable{

    Scanner in = new Scanner(System.in);

    private final ShowCenterGravityLoadedController showCenterGravityLoadedController;

    private final GetShipByCodeController getShipByCodeController;

    public ShowCenterGravityLoadedUI(){
        this.showCenterGravityLoadedController = new ShowCenterGravityLoadedController();
        this.getShipByCodeController = new GetShipByCodeController();
    }

    @Override
    public void run() {
        System.out.println("============Show Center Gravity Loaded==============");
        System.out.println("Enter the MMSI of the ship:");
        String mmsi = in.next();
        System.out.println("Please import a file of Containers:");
        String fileName = in.next();
        System.out.println("Importing file...");
        showCenterGravityLoadedController.containerImportController(new File(fileName), getShipByCodeController.getShipByCode(mmsi));
        Map<Integer, double[][]> mapAllocatted = showCenterGravityLoadedController.allocatingContainersController(getShipByCodeController.getShipByCode(mmsi));
        showCenterGravityLoadedController.showCenterOfGravityController(getShipByCodeController.getShipByCode(mmsi), mapAllocatted);
    }
}
