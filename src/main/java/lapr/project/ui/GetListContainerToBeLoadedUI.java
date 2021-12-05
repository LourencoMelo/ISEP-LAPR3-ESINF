package lapr.project.ui;

import lapr.project.controller.GetListContainerToBeLoadedController;

import java.util.Scanner;

public class GetListContainerToBeLoadedUI implements Runnable {

    Scanner in = new Scanner(System.in);

    private GetListContainerToBeLoadedController getListContainerToBeLoadedController;

    GetListContainerToBeLoadedUI() {
        this.getListContainerToBeLoadedController = new GetListContainerToBeLoadedController();
    }

    @Override
    public void run() {
        System.out.println("Enter the port where the containers are going to be loaded:");
        int port = in.nextInt();
        if(port > 0){
            System.out.println("============Result============");
            System.out.println(getListContainerToBeLoadedController.getListContainerToBeLoaded());
        }else{
            throw new IllegalArgumentException("The port id needs to be bigger than zero!");
        }
    }
}
