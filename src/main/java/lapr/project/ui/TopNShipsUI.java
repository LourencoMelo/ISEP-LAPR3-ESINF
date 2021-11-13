package lapr.project.ui;

import lapr.project.controller.TopNController;
import lapr.project.model.Ship;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

public class TopNShipsUI implements Runnable{


    private TopNController topNController;

    public TopNShipsUI(){
        this.topNController = new TopNController();
    }

    Scanner in = new Scanner(System.in);
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

        System.out.println("Please insert the number of ships you wish to see: ");
        int n = in.nextInt();
        in.nextLine();
        System.out.println("Please insert the first date: ");
        String date1 = in.nextLine();
        System.out.println("Please insert the second date: ");
        String date2 = in.nextLine();

        //For each Vessel Type , creates the respective map
        System.out.println("------------------------------");
        for (Integer vTypes : topNController.getVesselTypes()) {
            Map<Ship, Double> topN = topNController.getTopShipsWithMostKmByVesselType(formatter(date1), formatter(date2), n, vTypes);
            for (Map.Entry<Ship, Double> topiN : topN.entrySet()) {
                System.out.println("Ship : " + topiN.getKey().getMMSI());
                System.out.println("Vessel Type : " + topiN.getKey().getVesselType());
                System.out.println("Mean SOG : " + String.format("%.2f",topiN.getValue()) + "Km/h");
                System.out.println("Travelled distance : " + String.format("%.3f",topiN.getKey().travelledDistanceBtDates(formatter(date1), formatter(date2))) + "Km");
                System.out.println("------------------------------");
            }
        }
    }

    LocalDateTime formatter(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(str, formatter);
    }
}
