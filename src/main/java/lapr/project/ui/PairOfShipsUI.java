package lapr.project.ui;

import lapr.project.controller.PairOfShipsController;
import lapr.project.model.Pair;
import lapr.project.model.Ship;

import java.util.List;

public class PairOfShipsUI implements Runnable{

    private PairOfShipsController pairOfShipsController;

    public PairOfShipsUI(){
        this.pairOfShipsController = new PairOfShipsController();
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
        List<Pair<Ship, Ship>> pairs = pairOfShipsController.getPairShips();
        System.out.println(pairs);
    }
}
