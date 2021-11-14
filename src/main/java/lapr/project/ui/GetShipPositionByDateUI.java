package lapr.project.ui;

import lapr.project.controller.GetShipByCodeController;
import lapr.project.controller.GetShipPositionByDateController;

import java.util.Scanner;

public class GetShipPositionByDateUI implements Runnable{

    Scanner in = new Scanner(System.in);

    private final GetShipPositionByDateController getShipPositionByDateController;

    private final GetShipByCodeController getShipByCodeController;

    public GetShipPositionByDateUI(){
        this.getShipPositionByDateController = new GetShipPositionByDateController();
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
        System.out.println("Write MMSI, IMO or Call Sign of the ship you want to get the positions ordered by date: ");

        String answer = in.next();

        System.out.println(this.getShipPositionByDateController.getShipPositionMessagesOrderByDateController(getShipByCodeController.getShipByCode(answer)));
    }
}
