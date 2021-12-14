package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;

public class PortStaffUI implements Runnable{

    public PortStaffUI(){

    }

    @Override
    public void run() {
        try{
            List<MenuItem> options = new ArrayList<>();

            options.add(new MenuItem("I wish to know the total number of occupied slots on the Port", new GetTotalNumberOfOccupiedSlotsUI()));
            options.add(new MenuItem("I wish to fill a statically reserved matrix in memory with each container's ID in its respective place", new AllocateCargoManifestToPortUI()));

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
