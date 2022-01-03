package lapr.project.ui;

import lapr.project.controller.AccessToInfoContainersOnShipController;
import lapr.project.controller.GetListContainerToBeOffloadedController;

import java.util.Scanner;

public class AccessToInfoContainersOnShipUI implements Runnable {

    Scanner sc = new Scanner(System.in);

    private AccessToInfoContainersOnShipController accessToInfoContainersOnShipController;

    AccessToInfoContainersOnShipUI() {
        this.accessToInfoContainersOnShipController = new AccessToInfoContainersOnShipController();
    }

    @Override
    public void run() {

        accessToInfoContainersOnShipController.accessToInfoContainersOnShip();

        System.out.println("Done.");
    }

}
