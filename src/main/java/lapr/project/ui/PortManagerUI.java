package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;

public class PortManagerUI implements Runnable{

    public PortManagerUI() {
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
        try{
            List<MenuItem> options = new ArrayList<>();

            options.add(new MenuItem("Import Ports into a 2D-tree with port locations.", new ImportPortsUI()));
            options.add(new MenuItem("I want to know the occupancy rate of each warehouse.", new OccupancyRateUI()));
            options.add(new MenuItem("I intend to get a warning whenever I issue a cargo manifest destined for a warehouse whose available capacity is insufficient to accommodate the new manifest", new GetWarningUI()));
            options.add(new MenuItem("I intend to generate, a week in advance, the loading and unloading map based on ships and trucks load manifests and corresponding travel plans", new GenerateLoadingSufficientResourcesUI()));


            int option = 0;

            do{
                option = Utils.showAndSelectIndex(options, "\n\n\t\t\t\t\t\t\t\t======================== Port Manager Menu ========================\n\n");

                if ((option >= 0) && (option < options.size())){
                    options.get(option).run();
                }
            }while (option != -1);

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
