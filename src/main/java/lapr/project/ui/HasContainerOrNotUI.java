package lapr.project.ui;

import lapr.project.controller.HasContainerOrNotController;
import lapr.project.model.PositionData;

import java.time.LocalDateTime;
import java.util.Scanner;

public class HasContainerOrNotUI implements Runnable {

    Scanner in = new Scanner(System.in);

    private final HasContainerOrNotController hasContainerOrNotController;

    public HasContainerOrNotUI() {
        this.hasContainerOrNotController = new HasContainerOrNotController();
    }

    @Override
    public void run() {
        System.out.println("Please enter the call sign you want: ");

        String callSign = in.next();

        System.out.println("Enter a position data : ");
        int year = in.nextInt();
        int month = in.nextInt();
        int dayOfMonth = in.nextInt();
        int hour = in.nextInt();
        int minute = in.nextInt();
        double latitude = in.nextDouble();
        double longitude = in.nextDouble();
        double sog = in.nextDouble();
        double cog = in.nextDouble();
        double heading = in.nextDouble();
        String position  = in.next();
        String transceiver = in.next();

        System.out.println("Enter a container id: ");

        String containerId = in.next();

        hasContainerOrNotController.hasContainerOrNot(callSign, new PositionData(LocalDateTime.of(year,month,dayOfMonth,hour,minute), latitude, longitude, sog, cog ,heading, position, transceiver), containerId);


    }
}
