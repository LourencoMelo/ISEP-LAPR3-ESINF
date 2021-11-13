package lapr.project.ui;

import lapr.project.controller.ImportFileController;

import java.io.File;
import java.util.Scanner;

public class ImportFileUI implements Runnable{

    private ImportFileController importFileController;

    public ImportFileUI() {
        this.importFileController = new ImportFileController();
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

        importFileController.importShips(new File(answer));
        System.out.printf("\nNumber of Ships imported to the system : %d\n", importFileController.getCompany().getTreeOfShips().size());
        System.out.println("File imported!\n");
    }
}
