package lapr.project.ui;

import lapr.project.controller.GetSummaryDocumentMaterialsController;



public class GetSummaryDocumentMaterialsUI implements Runnable{

    private final GetSummaryDocumentMaterialsController getSummaryDocumentMaterialsController;

    public GetSummaryDocumentMaterialsUI(){
        this.getSummaryDocumentMaterialsController = new GetSummaryDocumentMaterialsController();
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
        System.out.println("=======SUMMARY DOCUMENT========");

        System.out.println(this.getSummaryDocumentMaterialsController.getSummaryDocumentMaterialsController());
        System.out.println("===============================");
    }
}
