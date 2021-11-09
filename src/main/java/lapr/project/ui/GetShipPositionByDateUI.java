package lapr.project.ui;

import lapr.project.controller.ApplicationController;
import lapr.project.controller.GetShipByCodeController;
import lapr.project.controller.GetShipPositionByDateController;

import java.util.Scanner;

public class GetShipPositionByDateUI {

    Scanner in = new Scanner(System.in);

    private ApplicationController applicationController;

    private GetShipPositionByDateController getShipPositionByDateController;

    private GetShipByCodeController getShipByCodeController;

    public GetShipPositionByDateUI(){
        this.applicationController = new ApplicationController();
        this.getShipPositionByDateController = new GetShipPositionByDateController();
        this.getShipByCodeController = new GetShipByCodeController();
    }

    public void getShipPositionMessagesOrderByDate(){
        System.out.println("Write MMSI, IMO or Call Sign of the ship you want to get the positions ordered by date: ");

        String answer = in.next();

        System.out.println(this.getShipPositionByDateController.getShipPositionMessagesOrderByDateController(getShipByCodeController.getShipByCode(answer)));
    }
}
