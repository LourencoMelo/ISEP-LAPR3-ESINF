package lapr.project.ui;

import lapr.project.controller.GetShipOccupancyRateController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GetShipOccupancyRateUI implements Runnable{

    Scanner in = new Scanner(System.in);

    private final GetShipOccupancyRateController getShipOccupancyRateController;

    public GetShipOccupancyRateUI(){
        this.getShipOccupancyRateController = new GetShipOccupancyRateController();
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
        System.out.println("Enter the Ship MMSI to know the occupancy rate");

        int shipMMSI = in.nextInt();
        if(shipMMSI >= 100000000 && shipMMSI <= 999999999){
            in.nextLine();
            System.out.println("Enter the date of the moment (Format: dd/MM/yyyy HH:mm)");
            String date = in.nextLine();
            double occupancyRateResult = getShipOccupancyRateController.getShipOccupancyRateController(shipMMSI, formatter(date));
            System.out.println("----------------RESULT-----------------");
            System.out.println("ShipMMSI: " + shipMMSI);
            System.out.println("Date: " + date);
            System.out.println("Result: "+ occupancyRateResult);
        }else{
            throw new IllegalArgumentException("MMSI needs to be a 9 digits unique number.");
        }
    }


    LocalDateTime formatter(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(str, formatter);
    }
}
