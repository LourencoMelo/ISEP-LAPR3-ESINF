package lapr.project.ui;

import lapr.project.controller.ClosestPortController;
import lapr.project.model.PortAndWareHouse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ClosestPortUI implements Runnable {

    private final ClosestPortController closestPortController;

    public ClosestPortUI() {
        this.closestPortController = new ClosestPortController();
    }

    Scanner in = new Scanner(System.in);

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
        System.out.println("Insert the wanted Call Sign : ");
        String cs = in.nextLine();
        System.out.println("Insert the wanted date : ");
        String date = in.nextLine();

        System.out.println("------------------------------");
        PortAndWareHouse result = closestPortController.getClosest(cs,formatter(date));
        System.out.println("Port : " + result.getPort());
    }

    LocalDateTime formatter(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(str, formatter);
    }
}
