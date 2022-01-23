package lapr.project.ui;

import lapr.project.controller.GetShipByCodeController;
import lapr.project.controller.ShowCenterGravityShipController;
import lapr.project.model.Ship;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShowCenterGravityShipUI implements Runnable {

    Scanner in = new Scanner(System.in);

    private final ShowCenterGravityShipController showCenterGravityShipController;

    private final GetShipByCodeController getShipByCodeController;

    public ShowCenterGravityShipUI(){
        this.showCenterGravityShipController = new ShowCenterGravityShipController();
        this.getShipByCodeController = new GetShipByCodeController();
    }

    @Override
    public void run() {
        System.out.println("============Show Center Gravity Loaded==============");
        System.out.println("Enter the MMSI of the ship:");
        String mmsi = in.next();
        Ship ship = getShipByCodeController.getShipByCode(mmsi);
        List<String[][]> list = showCenterGravityShipController.centerOfGravityEmptyShipController(ship);
        String[][] matrixRectangle = list.get(0);
        String[][] matrixTriangle = list.get(1);
        //Printing
        System.out.println("Center of gravity top view: \n");
        for(String[] row : matrixRectangle){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\n");
        System.out.println("Center of gravity front view: \n");
        for (int i = 0; i < 4; i++){
            for (int j = 0; j <= i; j++){
                System.out.print(matrixTriangle[i][j] + " ");
            }
            System.out.println();
        }

    }
}
