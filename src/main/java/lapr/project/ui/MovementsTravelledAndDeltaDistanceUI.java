package lapr.project.ui;

import lapr.project.controller.MovementsTravelledAndDeltaDistanceController;
import lapr.project.model.Ship;

import java.util.Scanner;

public class MovementsTravelledAndDeltaDistanceUI implements Runnable{

    private MovementsTravelledAndDeltaDistanceController movementsTravelledAndDeltaDistanceController;

    public MovementsTravelledAndDeltaDistanceUI() {
        this.movementsTravelledAndDeltaDistanceController = new MovementsTravelledAndDeltaDistanceController();
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for(Ship s : movementsTravelledAndDeltaDistanceController.listMovementsTravelledAndDeltaDistance()) {
            System.out.println(s.toStringMMSIMovementsTravelledDistanceDeltaDistance());
        }
    }
}
