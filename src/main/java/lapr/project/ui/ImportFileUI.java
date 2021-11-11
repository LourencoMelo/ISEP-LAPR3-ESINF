package lapr.project.ui;

import lapr.project.controller.ImportFileController;

import java.io.File;

public class ImportFileUI {

    private ImportFileController importFileController;

    public ImportFileUI() {
        this.importFileController = new ImportFileController();
    }

    public void import_ships(){

        importFileController.import_ships(new File("Files/sships.csv"));
        System.out.println("File imported!\n");

    }


}
