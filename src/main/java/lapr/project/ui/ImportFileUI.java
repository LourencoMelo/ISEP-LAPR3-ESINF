package lapr.project.ui;

import lapr.project.controller.ApplicationController;
import lapr.project.controller.ImportFileController;

import java.io.File;

public class ImportFileUI {

    private ImportFileController importFileController;

    private ApplicationController applicationController;

    public ImportFileUI() {
        this.importFileController = new ImportFileController();
        this.applicationController = new ApplicationController();
    }
//
//    public static void main(String[] args) {
//
//        ImportFileController importFileController = new ImportFileController();
//
//        importFileController.import_ships(new File("Files/sships.csv"));
//
//        System.out.println(importFileController.getTreeOfShips());
//
//    }

    public void import_ships(){

        importFileController.import_ships(new File("Files/sships.csv"));


        //System.out.println(importFileController.getShipByMMSI(210950000));

//        System.out.println(importFileController.getTreeOfShips());
//        System.out.println("\n\n\n");
//        System.out.println(importFileController.getTreeOfShips2());
//        System.out.println("\n\n\n");
//        System.out.println(importFileController.getTreeOfShips3());
    }


}
