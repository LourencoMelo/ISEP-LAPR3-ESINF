package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.io.File;


import static org.junit.jupiter.api.Assertions.*;

class GenerateGraphControllerTest {

    private static final String PATH_COUNTRIES_TEST = "Files/countries.csv";
    private static final String PATH_BORDERS_TEST = "Files/borders.csv";

    /**
     * Creates an instance of GenerateGraphController
     */
    GenerateGraphController generateGraphController = new GenerateGraphController(App.getInstance().getCompany());


    /**
     * Test the constructor and company association
     */
    @Test
    void GenerateGraphControllerTestMethod() {

        Company company = App.getInstance().getCompany();

        assertEquals(company, generateGraphController.getCompany());
    }

    @Test
    void generateTest() {

        ImportPortsController importPortsController = new ImportPortsController(App.getInstance().getCompany());

        importPortsController.importPorts(new File("Files/bports.csv"));

        generateGraphController.generate(new File(PATH_COUNTRIES_TEST), new File(PATH_BORDERS_TEST));

        assertEquals(generateGraphController.getCompany().getGraphGenerator().getGraph(), App.getInstance().getCompany().getGraphGenerator().getGraph());
    }

    @Test
    void toStringTest() {

        assertEquals(App.getInstance().getCompany().getGraphGenerator().getGraph().toString(), generateGraphController.graphToString());

    }
}