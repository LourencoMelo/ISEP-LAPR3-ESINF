package lapr.project.ui;

import lapr.project.controller.ImportPortsController;

import java.io.File;
import java.util.Scanner;

public class ImportPortsUI implements Runnable{

    private final ImportPortsController importPortsController;

    public ImportPortsUI() {
        this.importPortsController = new ImportPortsController();
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
        Scanner in = new Scanner(System.in);
        System.out.println("Please insert the path to the text file you wish to import: ");
        String answer = in.nextLine();

        importPortsController.importPorts(new File(answer));

        System.out.println(importPortsController.getKdTreeOfPorts());
        System.out.printf("%nNumber of Ports imported to the system : %d%n", importPortsController.getCompany().getTreeOfPorts().size());
        System.out.println("File imported!\n");
    }
}
