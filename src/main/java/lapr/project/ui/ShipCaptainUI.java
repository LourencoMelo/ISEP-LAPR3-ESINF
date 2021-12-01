package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;

public class ShipCaptainUI implements Runnable {

    public ShipCaptainUI() {
        //Empty constructor
    }
    @Override
    public void run() {
        try{
            List<MenuItem> options = new ArrayList<>();

            options.add(new MenuItem("List of containers to be offloaded in the next port, including container identifier, type, position, and load.", new GetListContainerToBeOffloadedUI()));
            options.add(new MenuItem("The occupancy rate (percentage) of a given ship for a given cargo manifest.", new GetOccupancyRateCargoManifestUI()));

            int option = 0;

            do{
                option = Utils.showAndSelectIndex(options, "\n\n\t\t\t\t\t\t\t\t======================== Traffic Manager Menu ========================\n\n");

                if ((option >= 0) && (option < options.size())){
                    options.get(option).run();
                }
            }while (option != -1);

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
