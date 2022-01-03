package lapr.project.ui;

import lapr.project.controller.AuditTrailsController;

import java.util.Scanner;

public class AuditTrailsUI implements Runnable{
    private final AuditTrailsController auditTrailsController;

    public AuditTrailsUI(){
        this.auditTrailsController = new AuditTrailsController();
    }

    Scanner sc = new Scanner(System.in);

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
        System.out.println("Insert container : ");
        String container = sc.next();
        System.out.println("Insert cargo manifest : ");
        String cargo = sc.next();
        System.out.println(this.auditTrailsController.getAuditTrails(container,cargo));
        System.out.println("================================");
    }
}
