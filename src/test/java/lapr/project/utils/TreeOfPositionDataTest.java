package lapr.project.utils;

import lapr.project.controller.TopNController;
import lapr.project.model.Company;
import lapr.project.model.Distance;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeOfPositionDataTest {

    Company company = App.getInstance().getCompany();
    TopNController topNController = new TopNController(company);
    TreeOfPositionData treeOfPositionData = new TreeOfPositionData();

    @Test
    void distance() {
        double expected = 4.369711529939779;
        double result = Distance.distance(28.37458,-88.88584,28.35085,-88.85024);

        assertEquals(expected,result);
    }

    @Test
    void distance2() {
        double expected = 0;
        double result = Distance.distance(28.37458,-88.88584,28.37458,-88.88584);

        assertEquals(expected,result);
    }


    /*@Test
    void travelledDistanceBtDates() {


    }

    @Test
    void meanSOG() {

    }*/
}