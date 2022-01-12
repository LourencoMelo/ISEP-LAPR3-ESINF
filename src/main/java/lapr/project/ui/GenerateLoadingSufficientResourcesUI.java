package lapr.project.ui;

import lapr.project.controller.GenerateLoadingSufficientResourcesController;

public class GenerateLoadingSufficientResourcesUI implements Runnable{

    private final GenerateLoadingSufficientResourcesController generateLoadingSufficientResourcesController;

    public GenerateLoadingSufficientResourcesUI(){
        this.generateLoadingSufficientResourcesController = new GenerateLoadingSufficientResourcesController();
    }

    @Override
    public void run() {
        System.out.println("=======Genarated=======");
        System.out.println(this.generateLoadingSufficientResourcesController.generateLoadingSufficientResourcesController());
    }
}
