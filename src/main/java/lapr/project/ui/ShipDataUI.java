package lapr.project.ui;

import lapr.project.controller.GetShipByCodeController;
import lapr.project.model.Ship;

import java.util.Scanner;

public class ShipDataUI implements Runnable {

    private final GetShipByCodeController getShipByCodeController;

    public ShipDataUI() {
        this.getShipByCodeController = new GetShipByCodeController();
    }


    @Override
    public void run() {

        try {

            Scanner in = new Scanner(System.in);


            System.out.println("Please insert one code(MMSI/IMO/CallSign) to find the ship data you want : ");

            String answer = in.next();

            Ship ship = getShipByCodeController.getShipByCode(answer);

            if (ship != null) {


                System.out.println("\n\n\t\t\t\t\t\t============================ Ship Data ============================");

                System.out.println("\t\t\t\t\t\tMMSI -> " + ship.getMMSI() +
                        "\n\t\t\t\t\t\tVessel Name -> " + ship.getName() +
                        "\n\t\t\t\t\t\tStart Base Date Time -> " + ship.initialDate() +
                        "\n\t\t\t\t\t\tEnd Base Date Time -> " + ship.finalDate() +
                        "\n\t\t\t\t\t\tTotal Movement Time -> " + String.format("%02dh%02dm",(ship.totalMovementTime()/3600),((ship.totalMovementTime() % 3600) / 60)) +
                        "\n\t\t\t\t\t\tTotal Number Of Movements -> " + ship.getTotalMovements() +
                        "\n\t\t\t\t\t\tMax SOG -> " + ship.getMaxSOG() + " km/h" +
                        "\n\t\t\t\t\t\tMean SOG -> " + String.format("%.3f",ship.getMeanSOG()) + " km/h" +
                        "\n\t\t\t\t\t\tMax COG -> " + ship.getMaxCOG() + "°" +
                        "\n\t\t\t\t\t\tMean COG -> " + String.format("%.3f",ship.getMeanCOG()) + "°" +
                        "\n\t\t\t\t\t\tDeparture Latitude -> " + ship.departureLatitude() + "°" +
                        "\n\t\t\t\t\t\tDeparture Longitude -> " + ship.departureLongitude() + "°" +
                        "\n\t\t\t\t\t\tArrival Latitude -> " + ship.arrivalLatitude() + "°" +
                        "\n\t\t\t\t\t\tArrival Longitude -> " + ship.arrivalLongitude() + "°" +
                        "\n\t\t\t\t\t\tTravelled Distance -> " + String.format("%.3f" ,ship.travelledDistance()) + " km"+
                        "\n\t\t\t\t\t\tDelta Distance -> " + String.format("%.3f",ship.getDeltaDistance()) + " km"
                );

            } else {
                System.out.println("The code you inserted does not correspond to any ship in the system database.");
            }
        }catch (Exception ignored){
            //ignored
        }
    }

}
