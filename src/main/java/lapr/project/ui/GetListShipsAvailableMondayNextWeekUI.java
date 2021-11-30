package lapr.project.ui;

import lapr.project.controller.GetListShipsAvailableMondayNextWeekController;

public class GetListShipsAvailableMondayNextWeekUI implements Runnable {

    private GetListShipsAvailableMondayNextWeekController getListShipsAvailableMondayNextWeekController;

    private GetListShipsAvailableMondayNextWeekUI() {
        this.getListShipsAvailableMondayNextWeekController = new GetListShipsAvailableMondayNextWeekController();
    }

    @Override
    public void run() {
        getListShipsAvailableMondayNextWeekController.getListShipsAvailableMondayNextWeek();

        System.out.println("Done.");
    }
}
