package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ShowCenterGravityLoadedControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    ShowCenterGravityLoadedController showCenterGravityLoadedController = new ShowCenterGravityLoadedController(company);

    @Test
    void ShowCenterGravityLoadedControllerTest(){
        Company company = App.getInstance().getCompany();

        ShowCenterGravityLoadedController showCenterGravityLoadedController = new ShowCenterGravityLoadedController();

        assertEquals(company, showCenterGravityLoadedController.getCompany());
    }

    /**
     * Tests if the Company object gives the same result as the App /////// Needs to be changed in the future
     */
    @Test
    void companyObjectVerifier() {
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        assertEquals(App.getInstance().getCompany().getShipPositionMessagesOrderByDate(shipTest), company.getShipPositionMessagesOrderByDate(shipTest));
    }

    @Test
    void showCenterOfGravityController() {
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        company.containerImport(new File("Files/containerFew.csv"), shipTest);

        Map<Integer, double[][]> matrixLevelsCompany = company.allocatingContainers(shipTest);

        Map<List<Double>, String[][]> mapCompany = company.showCenterOfGravity(shipTest, matrixLevelsCompany);

        Map<List<Double>, String[][]> mapController = showCenterGravityLoadedController.showCenterOfGravityController(shipTest, matrixLevelsCompany);

        List<Double> list = new ArrayList<>();
        list.add(-0.08552603060384065);
        list.add(0.918564957302007);

        String[][] matrixCompany = mapCompany.get(list);
        String[][] matrixController = mapController.get(list);

        //Checking if the lists are equal
        for(List<Double> keyTest : mapCompany.keySet()){
            for(List<Double> keyCompany : mapController.keySet()){
                assertEquals(keyTest, keyCompany);
            }
        }

        int length = (int) shipTest.getLength();
        int width = (int) shipTest.getWidth();

        for(Map.Entry<List<Double>, String[][]> mapObjCompany : mapCompany.entrySet()){
            for(Map.Entry<List<Double>, String[][]> mapObjController : mapController.entrySet()){
                String[][] mCompany =  mapObjCompany.getValue();
                String[][] mController = mapObjController.getValue();
                for(int i = 0; i < length; i++){
                    for(int j = 0; j < width; j++){
                        assertEquals(mCompany[i][j], mController[i][j]);
                    }
                }
            }
        }

    }

}