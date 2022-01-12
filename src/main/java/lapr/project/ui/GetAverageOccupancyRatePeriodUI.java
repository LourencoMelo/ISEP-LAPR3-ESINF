package lapr.project.ui;


import lapr.project.controller.GetAverageOccupancyRatePeriodController;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;

import java.time.LocalDateTime;

public class GetAverageOccupancyRatePeriodUI implements Runnable{

    private final GetAverageOccupancyRatePeriodController getAverageOccupancyRatePeriodController;

    public GetAverageOccupancyRatePeriodUI(){
        this.getAverageOccupancyRatePeriodController = new GetAverageOccupancyRatePeriodController();
    }

    @Override
    public void run() {
        System.out.println("Searching Ship...");
        Ship ship = new ShipByMMSI(123000788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);
        System.out.println("Dates Genarated...:");
        LocalDateTime date1 = LocalDateTime.of(2020, 12,30,17,19);
        LocalDateTime date2 = LocalDateTime.of(2020, 12,30,18,29);
        System.out.println("========RESULTS=======");
        System.out.println(this.getAverageOccupancyRatePeriodController.getAverageOccupancyRatePeriodController(ship, date1, date2));
    }
}
