package lapr.project.ui;

import lapr.project.controller.GetShipIdleDaysOfYearController;

public class GetShipIdleDaysOfYearUI implements Runnable{

    private final GetShipIdleDaysOfYearController getShipIdleDaysOfYearController;

    public GetShipIdleDaysOfYearUI() {
        this.getShipIdleDaysOfYearController = new GetShipIdleDaysOfYearController();
    }

    @Override
    public void run() {
        System.out.println("=========RESULT========");
        System.out.println(this.getShipIdleDaysOfYearController.getShipIdleDaysOfYearController());
    }
}
