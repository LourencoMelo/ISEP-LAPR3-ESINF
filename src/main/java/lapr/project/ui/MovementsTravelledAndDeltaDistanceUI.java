package lapr.project.ui;

import lapr.project.controller.MovementsTravelledAndDeltaDistanceController;
import lapr.project.model.Ship;

import java.util.Scanner;

public class MovementsTravelledAndDeltaDistanceUI {

    Scanner in = new Scanner(System.in);

    private MovementsTravelledAndDeltaDistanceController movementsTravelledAndDeltaDistanceController;

    public MovementsTravelledAndDeltaDistanceUI() {
        this.movementsTravelledAndDeltaDistanceController = new MovementsTravelledAndDeltaDistanceController();
    }

    public void listMovementsTravelledAndDeltaDistance() {
        for(Ship s : movementsTravelledAndDeltaDistanceController.listMovementsTravelledAndDeltaDistance()) {
            System.out.println(s.toStringMMSIMovementsTravelledDistanceDeltaDistance());
        }
    }

}
