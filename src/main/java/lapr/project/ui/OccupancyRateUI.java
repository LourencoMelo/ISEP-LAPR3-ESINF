package lapr.project.ui;

import lapr.project.controller.OccupancyRateController;

import java.util.Scanner;

public class OccupancyRateUI implements Runnable{
    private final OccupancyRateController occupancyRateController;

    public OccupancyRateUI(){
        this.occupancyRateController = new OccupancyRateController();
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
        System.out.println(this.occupancyRateController.getOccupancyRate());
        System.out.println("================================");
    }
}
