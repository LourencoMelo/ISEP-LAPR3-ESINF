package lapr.project.ui;

import lapr.project.controller.ColourMapController;
import lapr.project.model.Country;

import java.util.List;

public class ColourMapUI implements Runnable{

    private final ColourMapController colourMapController;

    public ColourMapUI(){
        this.colourMapController = new ColourMapController();
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
        System.out.println("Colouring the map!");
        System.out.println("------------------------------");
        List<Country> list = colourMapController.getCountryList();
        colourMapController.ColourMap(list);
        for(Country country : list){
            System.out.println("Country -> " + country.getName() + " Colour -> " + country.getColour());
        }
    }

}
