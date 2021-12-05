package lapr.project.ui;

import lapr.project.controller.GetListContainerToBeOffloadedController;

import java.util.Scanner;

public class GetListContainerToBeOffloadedUI implements Runnable {

    Scanner sc = new Scanner(System.in);

    private GetListContainerToBeOffloadedController getListContainerToBeOffloadedController;

    GetListContainerToBeOffloadedUI() {
        this.getListContainerToBeOffloadedController = new GetListContainerToBeOffloadedController();
    }

    @Override
    public void run() {

        System.out.println("Write the code of the port: ");

        String code = sc.next();

        getListContainerToBeOffloadedController.getListContainerToBeOffloaded(code);

        System.out.println("Done.");
    }
}
