package lapr.project.ui;

import java.util.ArrayList;
import java.util.List;

public class ClientUI implements Runnable{

    /**
     * Empty Constructor
     */
    public ClientUI(){

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

            options.add(new MenuItem("See the current situation of a specific container being used to transport my goods", new GetInfoContainerUI()));
            options.add(new MenuItem("I want to know the route of a specific container I am leasing", new RouteOfContainerUI()));

            int option = 0;

            do{
                option = Utils.showAndSelectIndex(options, "\n\n\t\t\t\t\t\t\t\t======================== Client Menu ========================\n\n");

                if ((option >= 0) && (option < options.size())){
                    options.get(option).run();
                }
            }while (option != -1);

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
