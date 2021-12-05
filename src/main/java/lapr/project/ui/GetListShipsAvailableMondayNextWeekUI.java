package lapr.project.ui;

import lapr.project.controller.GetListShipsAvailableMondayNextWeekController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GetListShipsAvailableMondayNextWeekUI implements Runnable {

    Scanner sc = new Scanner(System.in);

    private final GetListShipsAvailableMondayNextWeekController getListShipsAvailableMondayNextWeekController;

    private GetListShipsAvailableMondayNextWeekUI() {
        this.getListShipsAvailableMondayNextWeekController = new GetListShipsAvailableMondayNextWeekController();
    }

    @Override
    public void run() {
        System.out.println("Write the date (dd/MM/yyyy HH:mm): ");

        String date = sc.next();

        getListShipsAvailableMondayNextWeekController.getListShipsAvailableMondayNextWeek(formatter(date));

        System.out.println("Done.");
    }

    LocalDateTime formatter(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(str, formatter);
    }
}
