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
            options.add(new MenuItem("List of containers to be loaded in the next port, including container identifier, type and load.", new GetListContainerToBeLoadedUI()));
            options.add(new MenuItem("I want to know how many cargo manifests I have transported during a given year and the average number of containers per manifest.", new GetCargoManifestYearUI()));
            options.add(new MenuItem("The occupancy rate (percentage) of a given ship for a given cargo manifest.", new GetOccupancyRateCargoManifestUI()));
            options.add(new MenuItem("The occupancy rate (percentage) of a given ship for on a given time.", new GetShipOccupancyRateUI()));
            options.add(new MenuItem("I want to have access to audit trails for a given container of a given cargo manifest.", new AuditTrailsUI()));
            options.add(new MenuItem("n I want the determine the unladen center of mass for each vessel (if different) according to its characteristics.", new ShowCenterGravityShipUI()));
            options.add(new MenuItem("I want to know where to position, for example, one hundred (100) containers on the vessel, such that the center of mass remains at xx and yy determined in the previous point.", new ShowCenterGravityLoadedUI()));
            options.add(new MenuItem("I want to know for a specific vessel, how much did the vessel sink, assuming that each container has half a ton of mass.", new HowMuchShipSinkUI()));

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
