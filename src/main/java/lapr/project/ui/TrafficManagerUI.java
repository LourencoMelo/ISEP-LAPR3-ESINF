package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;

public class TrafficManagerUI implements Runnable {


    public TrafficManagerUI() {
        //Empty constructor
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

        try {
            List<MenuItem> options = new ArrayList<>();

            options.add(new MenuItem("Import Ships from a text file into a BST", new ImportFileUI()));
            options.add(new MenuItem("Search details of a ship by code", new GetShipByCodeUI()));
            options.add(new MenuItem("See positional messages temporally organized", new GetShipPositionByDateUI()));
            options.add(new MenuItem("Make a Summary of a ship's movements", new ShipDataUI()));
            options.add(new MenuItem("List all ships(MMSI,Total Number of Movements, Travelled Distance and Delta Distance", new MovementsTravelledAndDeltaDistanceUI()));
            options.add(new MenuItem("Get the Ships with most km travelled and their mean SOG grouped by Vessel Types", new TopNShipsUI()));
            options.add(new MenuItem("See pair os ships with routes with close dparture/arrival coordinates(<=5km) and with different Travelled Distance", new PairOfShipsUI()));
            options.add(new MenuItem("Know which ships will be available on Monday next week and their location", new GetListContainerToBeOffloadedUI()));
            options.add(new MenuItem("Find the closest port of a ship given its Call Sign, on a certain Date Time", new ClosestPortUI()));
            options.add(new MenuItem("Know which places (cities or ports) are closest to all other places (closeness places).", new TopClosenessByContinentUI()));
            options.add(new MenuItem("Import data from countries, ports, borders and seadists to build a freight network", new GenerateGraphUI()));
            options.add(new MenuItem("Colour the map", new ColourMapUI()));
            options.add(new MenuItem("I wish to know which ports are more critical", new ListNCentralityPortsUI()));
            int option = 0;

            do {
                option = Utils.showAndSelectIndex(options, "\n\n\t\t\t\t\t\t\t\t======================== Traffic Manager Menu ========================\n\n");

                if ((option >= 0) && (option < options.size())) {
                    options.get(option).run();
                }
            } while (option != -1);

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
