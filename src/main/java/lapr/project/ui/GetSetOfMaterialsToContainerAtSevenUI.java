package lapr.project.ui;

import lapr.project.controller.GetSetOfMaterialsToContainerAtSevenController;

public class GetSetOfMaterialsToContainerAtSevenUI implements Runnable {


    private final GetSetOfMaterialsToContainerAtSevenController getSetOfMaterialsToContainerAtSevenController;

    public GetSetOfMaterialsToContainerAtSevenUI(){
        this.getSetOfMaterialsToContainerAtSevenController = new GetSetOfMaterialsToContainerAtSevenController();
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
        System.out.println("==========MATERIALS USED========");
        System.out.println(this.getSetOfMaterialsToContainerAtSevenController.getSetOfMaterialsToContainerAtSevenController());
        System.out.println("================================");
    }
}
