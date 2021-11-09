package lapr.project.ui;

import lapr.project.controller.ApplicationController;
import lapr.project.controller.GetShipByCodeController;

import java.util.Scanner;

public class GetShipByCodeUI<E> {

    Scanner in = new Scanner(System.in);

    private ApplicationController applicationController;

    private GetShipByCodeController getShipByCodeController;

    public GetShipByCodeUI() {
        this.applicationController = new ApplicationController();
        this.getShipByCodeController = new GetShipByCodeController();
    }

    public void getShipByCode() {

        System.out.println("Write MMSI, IMO or Call Sign of the ship you want to get the details: ");

        String aanswer = in.next();

        System.out.println(getShipByCodeController.getShipByCode(aanswer));
    }

}
