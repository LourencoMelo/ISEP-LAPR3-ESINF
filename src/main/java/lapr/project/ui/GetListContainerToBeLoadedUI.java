package lapr.project.ui;

import lapr.project.controller.GetListContainerToBeLoadedController;

public class GetListContainerToBeLoadedUI implements Runnable {

    private GetListContainerToBeLoadedController getListContainerToBeLoadedController;

    GetListContainerToBeLoadedUI() {
        this.getListContainerToBeLoadedController = new GetListContainerToBeLoadedController();
    }

    @Override
    public void run() {
        getListContainerToBeLoadedController.getListContainerToBeLoaded();

        System.out.println("Done.");
    }
}
