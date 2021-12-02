package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ImportPortsControllerTest {

    ImportPortsController importPortsController = new ImportPortsController(App.getInstance().getCompany());


    @Test
    void importPortsController() {

        Company company = App.getInstance().getCompany();

        ImportPortsController importPortsController = new ImportPortsController();

        assertEquals(company, importPortsController.getCompany());

    }

    @Test
    void company_Object() {

        assertEquals(App.getInstance().getCompany().getTreeOfPorts(), importPortsController.getCompany().getTreeOfPorts());
    }


    @Test
    void import_Ports() {

        importPortsController.importPorts(new File("Files/sports.csv"));

        assertEquals(App.getInstance().getCompany().getTreeOfPorts().size(), 22);

    }

    @Test
    void getKDTree() {

        String expected = "|\t|\t|-------PortAndWareHouse{continent='Europe', country='United Kingdom', code=29002, port='Liverpool', lat=53.46666667, log=-3.033333333}\n" +
                "|\t|-------PortAndWareHouse{continent='Europe', country='France', code=18326, port='Dunkirk', lat=51.05, log=2.366666667}\n" +
                "|\t|\t|-------PortAndWareHouse{continent='Europe', country='Spain', code=17386, port='Barcelona', lat=41.33333333, log=2.166666667}\n" +
                "|\t|\t|\t|-------PortAndWareHouse{continent='Europe', country='Spain', code=18937, port='Valencia', lat=39.45, log=-0.3}\n" +
                "|-------PortAndWareHouse{continent='Europe', country='France', code=18012, port='Brest', lat=48.4, log=-4.5}\n" +
                "|\t|\t|-------PortAndWareHouse{continent='America', country='Canada', code=22226, port='Halifax', lat=44.65, log=-63.56666667}\n" +
                "|\t|\t|\t|-------PortAndWareHouse{continent='America', country='Canada', code=25350, port='Vancouver', lat=49.28333333, log=-123.1166667}\n" +
                "|\t|-------PortAndWareHouse{continent='Europe', country='Portugal', code=13012, port='Leixoes', lat=41.18333333, log=-8.7}\n" +
                "|\t|\t|-------PortAndWareHouse{continent='Europe', country='Portugal', code=13390, port='Setubal', lat=38.5, log=-8.916666667}\n" +
                "|\t|\t|\t|-------PortAndWareHouse{continent='America', country='United States', code=25007, port='New Jersey', lat=40.66666667, log=-74.16666667}\n" +
                "PortAndWareHouse{continent='Europe', country='Portugal', code=18476, port='Ponta Delgada', lat=37.73333333, log=-25.66666667}\n" +
                "|\t|\t|-------PortAndWareHouse{continent='Europe', country='Portugal', code=23428, port='Funchal', lat=32.65, log=-16.91666667}\n" +
                "|\t|\t|\t|-------PortAndWareHouse{continent='America', country='Brazil', code=20351, port='Salvador', lat=-12.96666667, log=-38.51666667}\n" +
                "|\t|-------PortAndWareHouse{continent='America', country='Brazil', code=27248, port='Santos', lat=-23.93333333, log=-46.31666667}\n" +
                "|\t|\t|-------PortAndWareHouse{continent='America', country='Brazil', code=20301, port='Rio Grande', lat=-32.06666667, log=-52.06666667}\n" +
                "|\t|\t|\t|-------PortAndWareHouse{continent='America', country='Chile', code=28082, port='Valparaiso', lat=-33.01666667, log=-71.63333333}\n" +
                "|-------PortAndWareHouse{continent='America', country='Peru', code=10860, port='Matarani', lat=-17.0, log=-72.1}\n" +
                "|\t|\t|-------PortAndWareHouse{continent='America', country='Colombia', code=28313, port='Cartagena', lat=10.41666667, log=-75.53333333}\n" +
                "|\t|\t|\t|-------PortAndWareHouse{continent='America', country='United States', code=14635, port='Los Angeles', lat=33.71666667, log=-118.2666667}\n" +
                "|\t|-------PortAndWareHouse{continent='America', country='Colombia', code=28261, port='Buenaventura', lat=3.916666667, log=-77.05}\n" +
                "|\t|\t|-------PortAndWareHouse{continent='America', country='Chile', code=27792, port='San Vicente', lat=-36.73333333, log=-73.15}\n" +
                "|\t|\t|\t|-------PortAndWareHouse{continent='America', country='Peru', code=30045, port='Callao', lat=-12.05, log=-77.16666667}\n";

        importPortsController.importPorts(new File("Files/sports.csv"));

        assertEquals(importPortsController.getKdTreeOfPorts(), expected);

    }
}