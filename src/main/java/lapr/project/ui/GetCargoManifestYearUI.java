package lapr.project.ui;

import lapr.project.controller.GetCargoManifestYearController;

import java.util.Scanner;

public class GetCargoManifestYearUI implements Runnable {

    private GetCargoManifestYearController getCargoManifestGivenYear;

    GetCargoManifestYearUI() {
        this.getCargoManifestGivenYear = new GetCargoManifestYearController();
    }

    Scanner in = new Scanner(System.in);

    @Override
    public void run() {
        System.out.println("Please insert the year : ");
        int n = in.nextInt();
        in.nextLine();
        getCargoManifestGivenYear.getCargoManifestGivenYear(n);

        System.out.println("Done.");
    }
}
