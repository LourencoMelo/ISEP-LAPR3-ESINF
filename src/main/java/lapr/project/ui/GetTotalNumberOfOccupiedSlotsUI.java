package lapr.project.ui;

import lapr.project.controller.GetTotalNumberOfOccupiedSlotsController;

public class GetTotalNumberOfOccupiedSlotsUI implements Runnable{

    private final GetTotalNumberOfOccupiedSlotsController getTotalNumberOfOccupiedSlotsController;

    public GetTotalNumberOfOccupiedSlotsUI(){
        this.getTotalNumberOfOccupiedSlotsController = new GetTotalNumberOfOccupiedSlotsController();
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
        System.out.println("========TOTAL OCCUPIED SLOTS=======");
        System.out.println("Result: " + getTotalNumberOfOccupiedSlotsController.getTotalNumberOfOccupiedSlotsController());
        System.out.println("===================================");
    }
}
