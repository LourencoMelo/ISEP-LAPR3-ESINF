package lapr.project.utils;

import lapr.project.controller.TopNController;
import lapr.project.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

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

    @Test
    void atLeastTwo(){
        /**
         * Parameters Created
         */
        LocalDateTime dateTest1 = LocalDateTime.of(2020, 12,29,17,19);
        LocalDateTime dateTest2 = LocalDateTime.of(2020, 12,31,17,19);
        /**
         * Ship Created
         */
        Ship shipTestCompare1 = new ShipByMMSI(123000788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        /**
         * Position Data
         */
        LocalDateTime date = LocalDateTime.of(2020, 12,30,17,19);
        PositionData positionDataTestCompare1 = new PositionData(dateTest1,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(date,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTest2,10,10,3,4,5,"1","Sopa");
        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(true, shipTestCompare1.atLeastTwo(dateTest1,dateTest2));
    }

    @Test
    void atLeastTwoFalse1Position(){
        /**
         * Parameters Created
         */
        LocalDateTime dateTest1 = LocalDateTime.of(2020, 12,29,17,19);
        LocalDateTime dateTest2 = LocalDateTime.of(2020, 12,31,17,19);
        /**
         * Ship Created
         */
        Ship shipTestCompare1 = new ShipByMMSI(123000788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        /**
         * Position Data
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTest1,10,10,3,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);


        assertEquals(false, shipTestCompare1.atLeastTwo(dateTest1,dateTest2));
    }

    @Test
    void atLeastTwoFalse0Positions(){
        /**
         * Parameters Created
         */
        LocalDateTime dateTest1 = LocalDateTime.of(2020, 12,29,17,19);
        LocalDateTime dateTest2 = LocalDateTime.of(2020, 12,31,17,19);
        /**
         * Ship Created
         */
        Ship shipTestCompare1 = new ShipByMMSI(123000788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        assertEquals(false, shipTestCompare1.atLeastTwo(dateTest1,dateTest2));
    }

    @Test
    void atLeastTwoFalsePositionsNotInLimits(){
        /**
         * Parameters Created
         */
        LocalDateTime dateTest1 = LocalDateTime.of(2020, 12,24,17,19);
        LocalDateTime dateTest2 = LocalDateTime.of(2020, 12,26,17,19);
        /**
         * Ship Created
         */
        Ship shipTestCompare1 = new ShipByMMSI(123000788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

        /**
         * Position Data
         */
        LocalDateTime date = LocalDateTime.of(2020, 12,30,17,19);
        LocalDateTime date1 = LocalDateTime.of(2020, 12,31,17,19);
        PositionData positionDataTestCompare1 = new PositionData(dateTest1,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(date,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(date1,10,10,3,4,5,"1","Sopa");
        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(false, shipTestCompare1.atLeastTwo(dateTest1,dateTest2));
    }

}