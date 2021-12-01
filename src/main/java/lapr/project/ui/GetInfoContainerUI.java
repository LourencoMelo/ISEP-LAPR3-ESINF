package lapr.project.ui;

import lapr.project.controller.GetInfoContainerController;

import java.util.Scanner;

public class GetInfoContainerUI implements Runnable{

    Scanner in = new Scanner(System.in);

    private final GetInfoContainerController getInfoContainerController;

    public GetInfoContainerUI() {
        this.getInfoContainerController = new GetInfoContainerController();
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
        System.out.println("Please enter the container ID so access his info.");

        String answer = in.next();

        System.out.println(this.getInfoContainerController.getInfoContainerController(answer));
    }
}
