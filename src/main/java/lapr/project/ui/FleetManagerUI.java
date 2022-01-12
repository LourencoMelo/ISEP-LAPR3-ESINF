package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;

public class FleetManagerUI implements Runnable{

    public FleetManagerUI(){
        //Empty constructor
    }
    @Override
    public void run() {
        try{
            List<MenuItem> options = new ArrayList<>();

            options.add(new MenuItem("I want to know the number of days each ship has been idle since the beginning of the current year.", new GetShipIdleDaysOfYearUI()));
            options.add(new MenuItem("I want to know the average occupancy rate per manifest of a given ship during a given period.", new GetAverageOccupancyRatePeriodUI()));
            options.add(new MenuItem("I want to know which ship voyages – place and date of origin and destination – had an occupancy rate below a certain threshold", new GetShipVoyagesBelowThresholdUI()));

            int option = 0;

            do{
                option = Utils.showAndSelectIndex(options, "\n\n\t\t\t\t\t\t\t\t======================== Fleet Manager Menu ========================\n\n");

                if ((option >= 0) && (option < options.size())){
                    options.get(option).run();
                }
            }while (option != -1);

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

}
