package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MostEfficientCircuitControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of MostEfficientCircuitController
     */
    MostEfficientCircuitController mostEfficientCircuitController = new MostEfficientCircuitController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void MostEfficientCircuitController() {
        Company company = App.getInstance().getCompany();

        MostEfficientCircuitController mostEfficientCircuitController = new MostEfficientCircuitController();

        assertEquals(company, mostEfficientCircuitController.getCompany());
    }

    @Test
    void getMostEfficientCircuit() {
        ImportPortsController importPortsController = new ImportPortsController(company);

        importPortsController.importPorts(new File("Files/bports.csv")); //Imports all ports from file

        company.generateGraph(new File("Files/countries.csv"), new File("Files/borders.csv"), new File("Files/seadists.csv"), 3); //Generates graph

        String start = "Genoa";

        //System.out.println(mostEfficientCircuitController.getMostEfficientCircuit(start));

        //assertEquals(mostEfficientCircuitController.getMostEfficientCircuit(start), company.getGraphGenerator().getMostEfficientCircuit(company.getVerticesByName(start)));
    }

}