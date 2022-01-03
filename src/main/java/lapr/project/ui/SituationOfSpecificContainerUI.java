package lapr.project.ui;

import lapr.project.controller.AccessToInfoContainersOnShipController;
import lapr.project.controller.SituationOfSpecificContainerController;

import java.util.Scanner;

public class SituationOfSpecificContainerUI implements Runnable {

    Scanner sc = new Scanner(System.in);

    private SituationOfSpecificContainerController situationOfSpecificContainerController;

    SituationOfSpecificContainerUI() {
        this.situationOfSpecificContainerController = new SituationOfSpecificContainerController();
    }

    @Override
    public void run() {

        situationOfSpecificContainerController.situationOfSpecificContainer();

        System.out.println("Done.");
    }

}
