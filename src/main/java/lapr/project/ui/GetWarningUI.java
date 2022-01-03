package lapr.project.ui;

import lapr.project.controller.GetWarningController;

public class GetWarningUI implements Runnable{
    private final GetWarningController getWarningController;

    public GetWarningUI(){
        this.getWarningController = new GetWarningController();
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
        System.out.println(this.getWarningController.getWarning());
        System.out.println("================================");
    }
}
