package lapr.project.ui;

import lapr.project.controller.ApplicationController;
import lapr.project.controller.GetShipByCodeController;
import lapr.project.controller.MovementsTravelledAndDeltaDistanceController;

import java.util.Scanner;

public class MovementsTravelledAndDeltaDistanceUI {

    Scanner in = new Scanner(System.in);

    private ApplicationController applicationController;

    private MovementsTravelledAndDeltaDistanceController movementsTravelledAndDeltaDistanceController;

    public MovementsTravelledAndDeltaDistanceUI() {
        this.applicationController = new ApplicationController();
        this.movementsTravelledAndDeltaDistanceController = new MovementsTravelledAndDeltaDistanceController();
    }

    public void listMovementsTravelledAndDeltaDistance() {
        movementsTravelledAndDeltaDistanceController.listMovementsTravelledAndDeltaDistance();
    }

}