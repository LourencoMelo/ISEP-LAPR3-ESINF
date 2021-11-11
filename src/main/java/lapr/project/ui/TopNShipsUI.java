package lapr.project.ui;

import lapr.project.controller.TopNController;
import lapr.project.model.Ship;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

public class TopNShipsUI {
    Scanner in = new Scanner(System.in);

    private TopNController topNController;

    public TopNShipsUI(){
        this.topNController = new TopNController();
    }

    /**
     * For each Vessel Type this method will give the TOP-N ships with the most kilometres travelled and their respective average speed
     *
     * @param date1 initial date
     * @param date2 final date
     * @param n     N ships
     */
    public void getTopShipsWithMostKm(LocalDateTime date1, LocalDateTime date2, int n) {
        //For each Vessel Type , creates the respective map
        for (Integer vTypes : topNController.getVesselTypes()) {
            Map<Ship, Double> topN = topNController.getTopShipsWithMostKmByVesselType(date1, date2, n, vTypes);
            for (Map.Entry<Ship, Double> topiN : topN.entrySet()) {
                System.out.println(topiN);
                System.out.println(topiN.getKey().travelledDistanceBtDates(date1, date2));
            }
        }
    }
}
