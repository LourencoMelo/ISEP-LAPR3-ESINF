package lapr.project.ui;

import lapr.project.controller.GetShipByCodeController;

import java.util.Scanner;

public class GetShipByCodeUI implements Runnable {

    Scanner in = new Scanner(System.in);

    private final GetShipByCodeController getShipByCodeController;

    public GetShipByCodeUI() {
        this.getShipByCodeController = new GetShipByCodeController();
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
        System.out.println("Write MMSI, IMO or Call Sign of the ship you want to get the details: ");

        String answer = in.next();

        System.out.println(getShipByCodeController.getShipByCode(answer));
    }
}
