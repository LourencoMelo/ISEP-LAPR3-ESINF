package lapr.project.ui;

import lapr.project.controller.GetSetOfMaterialsToContainerAtMinus5Controller;

public class GetSetOfMaterialsToContainerAtMinus5UI implements Runnable{

    private final GetSetOfMaterialsToContainerAtMinus5Controller getSetOfMaterialsToContainerAtMinus5Controller;

    public GetSetOfMaterialsToContainerAtMinus5UI(){
        this.getSetOfMaterialsToContainerAtMinus5Controller = new GetSetOfMaterialsToContainerAtMinus5Controller();
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
        System.out.println(this.getSetOfMaterialsToContainerAtMinus5Controller.getSetOfMaterialsToContainerAtMinus5Controller());
        System.out.println("================================");
    }
}
