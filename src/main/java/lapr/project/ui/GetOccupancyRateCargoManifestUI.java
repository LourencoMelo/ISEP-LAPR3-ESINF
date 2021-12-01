package lapr.project.ui;

import lapr.project.controller.GetOccupancyRateCargoManifestController;

import java.util.Scanner;

public class GetOccupancyRateCargoManifestUI implements Runnable{

    Scanner in = new Scanner(System.in);

    private final GetOccupancyRateCargoManifestController getOccupancyRateCargoManifestController;

    public GetOccupancyRateCargoManifestUI(){
        this.getOccupancyRateCargoManifestController = new GetOccupancyRateCargoManifestController();
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
        System.out.println("Enter the Cargo Manifest to comparate the Ship's Occupancy.");

        String answer = in.next();

        System.out.println(this.getOccupancyRateCargoManifestController.getOccupancyRateCargoManifestController(answer));
    }
}
