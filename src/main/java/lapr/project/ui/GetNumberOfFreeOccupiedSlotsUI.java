package lapr.project.ui;

import lapr.project.controller.GetNumberOfFreeOccupiedSlotsController;

import java.util.Scanner;

public class GetNumberOfFreeOccupiedSlotsUI implements Runnable {

    Scanner in = new Scanner(System.in);

    private final GetNumberOfFreeOccupiedSlotsController getNumberOfFreeOccupiedSlotsController;

    public GetNumberOfFreeOccupiedSlotsUI() {
        this.getNumberOfFreeOccupiedSlotsController = new GetNumberOfFreeOccupiedSlotsController();
    }

    @Override
    public void run() {
        System.out.println("Please enter the call sign you want to know the free/occupied slots: ");

        String answer = in.next();

        System.out.println(this.getNumberOfFreeOccupiedSlotsController.getNumberOfFreeOccupiedSlots(answer));

    }
}
