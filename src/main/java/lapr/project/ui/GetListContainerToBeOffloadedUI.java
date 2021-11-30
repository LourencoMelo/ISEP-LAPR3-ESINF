package lapr.project.ui;

import lapr.project.controller.GetListContainerToBeOffloadedController;

import java.util.Scanner;

public class GetListContainerToBeOffloadedUI implements Runnable {

    private GetListContainerToBeOffloadedController getListContainerToBeOffloadedController;

    GetListContainerToBeOffloadedUI() {
        this.getListContainerToBeOffloadedController = new GetListContainerToBeOffloadedController();
    }

    @Override
    public void run() {
        getListContainerToBeOffloadedController.getListContainerToBeOffloaded();

        System.out.println("Done.");
    }
}
