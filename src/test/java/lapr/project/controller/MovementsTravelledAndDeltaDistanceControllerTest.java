package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.model.ShipByMMSI;
import lapr.project.utils.App;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovementsTravelledAndDeltaDistanceControllerTest {

    /**
     * Create an instance of Company
     */
    Company company = new Company();

    /**
     * Creates an instance of GetShipByCodeController
     */
    MovementsTravelledAndDeltaDistanceController movementsTravelledAndDeltaDistanceController = new MovementsTravelledAndDeltaDistanceController(company);

    /**
     * Test the constructor and company association
     */
    @Test
    void MovementsTravelledAndDeltaDistanceController() {
        Company company = App.getInstance().getCompany();

        MovementsTravelledAndDeltaDistanceController movementsTravelledAndDeltaDistanceController = new MovementsTravelledAndDeltaDistanceController();

        assertEquals(company, movementsTravelledAndDeltaDistanceController.getCompany());
    }

    /**
     * Tests if the Company object gives the same result as the App
     */
    @Test
    void companyObjectVerifier() {
        Ship shipTest = new ShipByMMSI(123456788, "WarCraft", "1023456787","Roger",2, 5.0, 3.0, 20.9);
        assertEquals(App.getInstance().getCompany().getShipPositionMessagesOrderByDate(shipTest), company.getShipPositionMessagesOrderByDate(shipTest));
    }

    /**
     * Test if the list returned is well ordered by travelled distance and number of movements (descending/ascending)
     */
    @Test
    void listMovementsTravelledAndDeltaDistance() {

        company.getTreeOfShips().createTreeMMSI(new File("Files/sships.csv"));

        List<Ship> list = new ArrayList<>();

        for (Ship s : company.getTreeOfShips().inOrder()) {
            list.add(s);
        }

        Comparator<Ship> comparator = new Comparator<Ship>() {
            @Override
            public int compare(Ship s1, Ship s2) {
                if (s1.getTreeOfPositionData().travelledDistance() > s2.getTreeOfPositionData().travelledDistance()) {
                    return -1;
                }
                if (s1.getTreeOfPositionData().travelledDistance() < s2.getTreeOfPositionData().travelledDistance()) {
                    return 1;
                }

                if (s1.getTreeOfPositionData().getTotalMovements() > s2.getTreeOfPositionData().getTotalMovements()) {
                    return 1;
                }
                if (s1.getTreeOfPositionData().getTotalMovements() < s2.getTreeOfPositionData().getTotalMovements()) {
                    return -1;
                }
                return 0;
            }
        };

        Collections.sort(list, comparator);

        assertEquals(list, movementsTravelledAndDeltaDistanceController.listMovementsTravelledAndDeltaDistance());

    }

}