package lapr.project.ui;

import lapr.project.controller.GetCargoManifestYearController;

import java.time.LocalDateTime;
import java.util.Scanner;

public class GetCargoManifestYearUI implements Runnable {

    private GetCargoManifestYearController getCargoManifestGivenYear;

    GetCargoManifestYearUI() {
        this.getCargoManifestGivenYear = new GetCargoManifestYearController();
    }

    Scanner in = new Scanner(System.in);

    @Override
    public void run() {
        System.out.println("Please insert the year: ");
        int year = in.nextInt();
        if(year >= 0 && year <= LocalDateTime.now().getYear()){
            System.out.println(("============RESULT==============="));
            System.out.println(getCargoManifestGivenYear.getCargoManifestGivenYear(year));
        }else{
            throw new IllegalArgumentException("The year needs to be positive and not a future year");
        }
    }
}
