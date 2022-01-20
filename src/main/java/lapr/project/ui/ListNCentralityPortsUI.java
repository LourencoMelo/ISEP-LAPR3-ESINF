package lapr.project.ui;

import lapr.project.controller.ListNCentralityPortsController;
import lapr.project.model.PortAndWareHouse;

import java.util.Map;
import java.util.Scanner;

public class ListNCentralityPortsUI implements Runnable {


    private final ListNCentralityPortsController controller;

    public ListNCentralityPortsUI() {
        this.controller = new ListNCentralityPortsController();
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

        Scanner in = new Scanner(System.in);
        System.out.println("Please insert the number of ports with greater centrality in the freight network you want to see: ");
        int answer = in.nextInt();


        for (Map.Entry<PortAndWareHouse, Integer> entry : controller.getNPorts(answer).entrySet()) {

            System.out.printf("Name : %s    ||  Centrality : %d;\n", entry.getKey().getPort(), entry.getValue());

        }

    }
}
