package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ListNCentralityPortsControllerTest {

    private static final String PATH_COUNTRIES_TEST = "Files/countries.csv";
    private static final String PATH_BORDERS_TEST = "Files/borders.csv";
    private static final String PATH_SEADISTS_TEST = "Files/seadists.csv";

    private static final int NUMBER_OF_CLOSEST_PORTS = 0;

    Company company = new Company();

    ListNCentralityPortsController controller = new ListNCentralityPortsController(company);

    @Test
    void listNCentralityPortsControllerTest() {
        Company company = App.getInstance().getCompany();

        ListNCentralityPortsController controller = new ListNCentralityPortsController(company);

        assertEquals(company, controller.getCompany());
    }

    @Test
    void nPortsTest() {

        ImportPortsController importPortsController = new ImportPortsController(company);

        GenerateGraphController generateGraphController = new GenerateGraphController(company);

        importPortsController.importPorts(new File("Files/bports.csv"));

        generateGraphController.generate(new File(PATH_COUNTRIES_TEST), new File(PATH_BORDERS_TEST), new File(PATH_SEADISTS_TEST), NUMBER_OF_CLOSEST_PORTS);

        assertEquals(company.getGraphGenerator().listOfNPortsCentrality(4), controller.getCompany().getGraphGenerator().listOfNPortsCentrality(4));
    }
}