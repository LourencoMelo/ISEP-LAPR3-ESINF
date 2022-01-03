package lapr.project.ui;

import lapr.project.controller.GenerateGraphController;

import java.io.File;
import java.util.Scanner;

public class GenerateGraphUI implements Runnable{

    /**
     * instance of controller
     */
    private GenerateGraphController generateGraphController;

    public GenerateGraphUI() {
        this.generateGraphController = new GenerateGraphController();
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
        System.out.println("Please insert the path to the text file with countries information: ");
        String countries = in.nextLine();

        System.out.println("Please insert the path to the text file with borders information: ");
        String borders = in.nextLine();

        System.out.println("Please insert the path to the text file with sea distances information: ");
        String seadist = in.nextLine();

        System.out.println("Please insert the number of closest ports: ");
        int n = in.nextInt();

        System.out.println(countries + borders + seadist + n);

        generateGraphController.generate(new File(countries),new File(borders), new File(seadist), n);

        System.out.println("Files imported!\n");

        System.out.println(generateGraphController.graphToString());

    }
}
