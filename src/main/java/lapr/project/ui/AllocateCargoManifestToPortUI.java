package lapr.project.ui;

import lapr.project.controller.AllocateCargoManifestToPortController;

import java.util.Scanner;

public class AllocateCargoManifestToPortUI implements Runnable {

    Scanner in = new Scanner(System.in);

    private final AllocateCargoManifestToPortController allocateCargoManifestToPortController;

    public AllocateCargoManifestToPortUI(){
        this.allocateCargoManifestToPortController = new AllocateCargoManifestToPortController();
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
        System.out.println("Please enter the Cargo Manifest ID!");

        int answer = in.nextInt();

        System.out.println("Removing the containers of the ship");
        System.out.println("Allocating the Containers...");
        if(allocateCargoManifestToPortController.allocateCargoManifestToPortController(answer)){
            System.out.println("Matrix was filled!");
        }else{
            System.out.println("Some error happenned!");
        }
    }
}
