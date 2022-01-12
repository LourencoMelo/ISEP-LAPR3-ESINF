package lapr.project.ui;

import lapr.project.controller.GetShipVoyagesBelowThresholdController;

public class GetShipVoyagesBelowThresholdUI implements Runnable{

    private final GetShipVoyagesBelowThresholdController getShipVoyagesBelowThresholdController;

    public GetShipVoyagesBelowThresholdUI(){
        this.getShipVoyagesBelowThresholdController = new GetShipVoyagesBelowThresholdController();
    }

    @Override
    public void run() {
        System.out.println("=======RESULTS======");
        System.out.println(this.getShipVoyagesBelowThresholdController.getShipVoyagesBelowThresholdController());
    }
}
