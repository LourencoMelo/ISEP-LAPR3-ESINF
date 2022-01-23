package lapr.project.ui;

import lapr.project.controller.MostEfficientCircuitController;

import java.util.Scanner;

public class MostEfficentCircuitUI implements Runnable {

    Scanner in = new Scanner(System.in);

    private MostEfficientCircuitController mostEfficientCircuitController;

    public MostEfficentCircuitUI() {
        this.mostEfficientCircuitController = new MostEfficientCircuitController();
    }

    @Override
    public void run() {

        System.out.println("Write the name of the Port or the name of the Capital");

        String answer = in.next();

        System.out.println(mostEfficientCircuitController.getMostEfficientCircuit(answer));

    }

}
