package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.io.File;


import static org.junit.jupiter.api.Assertions.*;

class GenerateGraphControllerTest {

    private static final String PATH_COUNTRIES_TEST = "Files/countries.csv";
    private static final String PATH_BORDERS_TEST = "Files/borders.csv";

    Company company = new Company();

    /**
     * Creates an instance of GenerateGraphController
     */
    GenerateGraphController generateGraphController = new GenerateGraphController(company);


    /**
     * Test the constructor and company association
     */
    @Test
    void GenerateGraphControllerTestMethod() {
        Company company1 = App.getInstance().getCompany();

        GenerateGraphController generateGraphController = new GenerateGraphController();

        assertEquals(company1, generateGraphController.getCompany());
    }

    @Test
    void generateTest() {

        ImportPortsController importPortsController = new ImportPortsController(company);

        importPortsController.importPorts(new File("Files/bports.csv"));

        generateGraphController.generate(new File(PATH_COUNTRIES_TEST), new File(PATH_BORDERS_TEST));

        assertEquals(generateGraphController.getCompany().getGraphGenerator().getGraph(),company.getGraphGenerator().getGraph());

        assertEquals(145, company.getGraphGenerator().getGraph().numVertices());

        System.out.println(company.getGraphGenerator().getGraph().numVertices());
    }

    @Test
    void toStringTest() {

        assertEquals(App.getInstance().getCompany().getGraphGenerator().getGraph().toString(), generateGraphController.graphToString());

    }
}