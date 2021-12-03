package lapr.project.utils;

import lapr.project.model.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TreeOfPositionDataTest {

    /**
     * Objects for Testing
     */

    Ship shipTestCompare1 = new ShipByMMSI(123000788, "WarCraft", "1023456787", "Roger", 2, 5.0, 3.0, 20.9);

    /**
     * Objects For atLeastTwo()
     */
    LocalDateTime mainDateTest1 = LocalDateTime.of(2020, 12,29,17,19);
    LocalDateTime mainDateTest2 = LocalDateTime.of(2020, 12,31,17,19);
    LocalDateTime secondaryDateTest1 = LocalDateTime.of(2020, 12,30,17,19);

    /**
     * Objects For MeanSog()
     */
    LocalDateTime mainSogDate1 = LocalDateTime.of(2020, 12,30,17,19);
    LocalDateTime mainSogDate2 = LocalDateTime.of(2020, 12,30,18,29);
    LocalDateTime mainSogDate3 = LocalDateTime.of(2020, 12,30,19,19);

    /**
     * Objects For TravelDistance Tests
     */

    LocalDateTime dateTravelDistance1 = LocalDateTime.of(2020, 12,30,17,19);
    LocalDateTime dateTravelDistance2 = LocalDateTime.of(2020, 12,30,18,29);
    LocalDateTime dateTravelDistance3 = LocalDateTime.of(2020, 12,30,19,19);
    LocalDateTime dateTravelDistance4  = LocalDateTime.of(2020, 12,27,17,19);


    /**
     *---------------------------------------------------------------------------------------
     *
     *                                  DISTANCE TESTS
     *
     * ---------------------------------------------------------------------------------------
     */

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

    /**
     *---------------------------------------------------------------------------------------
     *
     *                                  AT LEAST TWO TESTS
     *
     * ---------------------------------------------------------------------------------------
     */


    @Test
    void atLeastTwo(){
        /**
         * Position Data
         */
        PositionData positionDataTestCompare1 = new PositionData(mainDateTest1,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(secondaryDateTest1,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(mainDateTest2,10,10,3,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertTrue(shipTestCompare1.atLeastTwo(mainDateTest1, mainDateTest2));
    }

    @Test
    void atLeastTwoFalse1Position(){

        /**
         * Position Data
         */
        PositionData positionDataTestCompare1 = new PositionData(mainDateTest1,10,10,3,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);


        assertFalse(shipTestCompare1.atLeastTwo(mainDateTest1, mainDateTest2));
    }

    @Test
    void atLeastTwoFalse0Positions(){

        assertFalse(shipTestCompare1.atLeastTwo(mainDateTest1, mainDateTest2));
    }

    @Test
    void atLeastTwoFalsePositionsNotInLimits(){
        /**
         * Parameters Created
         */
        LocalDateTime dateTest1 = LocalDateTime.of(2020, 12,24,17,19);
        LocalDateTime dateTest2 = LocalDateTime.of(2020, 12,26,17,19);

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

        assertFalse(shipTestCompare1.atLeastTwo(dateTest1, dateTest2));
    }

    @Test
    void atLeastTwoFalsePositionsOneInLimits(){
        /**
         * Parameters Created
         */
        LocalDateTime dateTest1 = LocalDateTime.of(2020, 12,24,17,19);
        LocalDateTime dateTest2 = LocalDateTime.of(2020, 12,26,17,19);

        /**
         * Position Data
         */
        LocalDateTime date = LocalDateTime.of(2020, 12,30,17,19);
        LocalDateTime date1 = LocalDateTime.of(2020, 12,31,17,19);

        PositionData positionDataTestCompare1 = new PositionData(date,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(date1,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(date1,10,10,3,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertFalse(shipTestCompare1.atLeastTwo(dateTest1, date));
    }



    /**
     *---------------------------------------------------------------------------------------
     *
     *                                  MEAN SOG TESTS
     *
     * ---------------------------------------------------------------------------------------
     */


    @Test
    void meanSOGWithoutParameters(){
        /**
         * Expected final return value
         */
        double expected = 6;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(mainSogDate1,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(mainSogDate2,10,10,6,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(mainSogDate3,10,10,9,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().meanSOG());
    }

    @Test
    void meanSOGWithoutParametersSOGZero(){
        /**
         * Expected final return value
         */
        double expected = 0;

        /**
         * Objects Needed For testing
         */
        LocalDateTime datetest1 = LocalDateTime.of(2020, 12,30,17,19);
        LocalDateTime datetest2 = LocalDateTime.of(2020, 12,30,18,29);
        LocalDateTime datetest3 = LocalDateTime.of(2020, 12,30,19,19);

        PositionData positionDataTestCompare1 = new PositionData(datetest1,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(datetest2,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(datetest3,10,10,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);


        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().meanSOG());
    }

    @Test
    void meanSOGInEmptyList() {
        double expected = 0;

        assertEquals(expected,shipTestCompare1.getTreeOfPositionData().meanSOG());
    }

    /**
     *---------------------------------------------------------------------------------------
     *
     *                           MEAN SOG WITH DATES TESTS
     *
     * ---------------------------------------------------------------------------------------
     */

    @Test
    void meanSOGWithParameters(){
        /**
         * Expected final return value
         */
        double expected = 4.5;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(mainSogDate1,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(mainSogDate2,10,10,6,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(mainSogDate3,10,10,9,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().meanSOG(mainSogDate1,mainSogDate2));
    }

    @Test
    void meanSOGWithParametersSOGZero(){
        /**
         * Expected final return value
         */
        double expected = 0;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(mainSogDate1,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(mainSogDate2,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(mainSogDate3,10,10,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().meanSOG(mainSogDate1,mainSogDate3));
    }

    @Test
    void meanSOGWithParametersNotInterval(){
        /**
         * Expected final return value
         */
        double expected = 0;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(mainSogDate1,10,10,3,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(mainSogDate2,10,10,6,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(mainSogDate3,10,10,9,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().meanSOG(dateTravelDistance4, mainDateTest1));
    }

    /**
     *---------------------------------------------------------------------------------------
     *
     *                                  TRAVEL DISTANCE TESTS
     *
     * ---------------------------------------------------------------------------------------
     */


    @Test
    void travelledDistanceTwoPointsSamePosition(){
        /**
         * Expected final return value
         */
        double expected = 0;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,10,10,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().travelledDistance());
    }

    @Test
    void travelledDistanceTwoPointsDiffPosition(){
        /**
         * Expected final return value
         */
        double expected = 4751.733107605955;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().travelledDistance());
    }

    @Test
    void travelledDistanceThreePoints(){
        /**
         * Expected final return value
         */
        double expected = 11057.439248129005;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().travelledDistance());
    }

    /**
     *---------------------------------------------------------------------------------------
     *
     *                         TRAVEL DISTANCE BETWEEN DATES TESTS
     *
     * ---------------------------------------------------------------------------------------
     */

    @Test
    void travelledDistanceTwoPointsSamePositionBtwDates(){
        /**
         * Expected final return value
         */
        double expected = 0;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,10,10,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().travelledDistanceBtDates(dateTravelDistance1,dateTravelDistance2));
    }

    @Test
    void travelledDistanceTwoPointsDiffPositionBtwDates(){
        /**
         * Expected final return value
         */
        double expected = 4751.733107605955;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().travelledDistanceBtDates(dateTravelDistance1, dateTravelDistance2));
    }

    @Test
    void travelledDistanceThreePointsBtwDates(){
        /**
         * Expected final return value
         */
        double expected = 11057.439248129005;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().travelledDistanceBtDates(dateTravelDistance1,dateTravelDistance3));
    }

    @Test
    void travelledDistanceNotBtwDates(){
        /**
         * Expected final return value
         */
        double expected = 0;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().travelledDistanceBtDates(dateTravelDistance4, mainDateTest1));
    }

    /**
     *---------------------------------------------------------------------------------------
     *
     *                         GET TOTAL MOVEMENTS
     *
     * ---------------------------------------------------------------------------------------
     */
    @Test
    void getTotalMovementsTest(){
        /**
         * Expected final return value
         */
        int expected = 3;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().getTotalMovements());
    }

    /**
     *---------------------------------------------------------------------------------------
     *
     *                         INITIAL DATE TESTS
     *
     * ---------------------------------------------------------------------------------------
     */
    @Test
    void initialPublicRight(){
        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);


        assertEquals(dateTravelDistance1, shipTestCompare1.getTreeOfPositionData().initialDate());
    }

    @Test
    void initialPublicWrong(){
        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);


        assertNotSame(dateTravelDistance2, shipTestCompare1.getTreeOfPositionData().initialDate());
    }

    @Test
    void initialPublicNoRoot(){
        assertNull(shipTestCompare1.getTreeOfPositionData().initialDate());
    }

    /**
     *---------------------------------------------------------------------------------------
     *
     *                         FINAL DATE TESTS
     *
     * ---------------------------------------------------------------------------------------
     */
    @Test
    void finalPublicRight(){
        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);


        assertEquals(dateTravelDistance3, shipTestCompare1.getTreeOfPositionData().finalDate());
    }

    @Test
    void finalPublicWrong(){
        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);


        assertNotSame(dateTravelDistance2, shipTestCompare1.getTreeOfPositionData().finalDate());
    }

    @Test
    void finalPublic(){
        assertNull(shipTestCompare1.getTreeOfPositionData().finalDate());
    }

    /**
     *---------------------------------------------------------------------------------------
     *
     *                         DELTA DISTANCE TESTS
     *
     * ---------------------------------------------------------------------------------------
     */

    @Test
    void getDeltaDistance(){
        /**
         * Expected result
         */
        double expected = 3915.1189561031474;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().getDeltaDistance());
    }

    @Test
    void getDeltaDistanceHasNext(){
        /**
         * Expected result
         */
        double expected = 0;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,0,4,5,"1","Sopa");


        shipTestCompare1.addPositionData(positionDataTestCompare1);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().getDeltaDistance());
    }

    /**
     *---------------------------------------------------------------------------------------
     *
     *                         MAX SOG TESTS
     *
     * ---------------------------------------------------------------------------------------
     */
    @Test
    void maxSOG(){
        /**
         * Expected result
         */
        double expected = 10;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,2,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,10,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,10,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().maxSOG());
    }

    /**
     *---------------------------------------------------------------------------------------
     *
     *                         MAX & MEAN COG TESTS
     *
     * ---------------------------------------------------------------------------------------
     */
    @Test
    void maxCOG(){
        /**
         * Expected result
         */
        double expected = 7;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,2,1,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,10,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,3,7,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().maxCOG());
    }

    @Test
    void maxCOGTwoMax(){
        /**
         * Expected result
         */
        double expected = 7;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,2,1,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,10,7,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,3,7,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().maxCOG());
    }

    @Test
    void meanCOG(){
        /**
         * Expected result
         */
        double expected = 4;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,2,1,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,10,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,3,7,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().meanCOG());
    }

    @Test
    void meanCOGInEmptyList() {
        double expected = 0;

        assertEquals(expected,shipTestCompare1.getMeanCOG());
    }

    /**
     *---------------------------------------------------------------------------------------
     *
     *                         TOTAL MOVEMENT TIME
     *
     * ---------------------------------------------------------------------------------------
     */
    @Test
    void getTotalMovementTime(){
        /**
         * Expected result
         */
        long expected = 7200;

        /**
         * Objects Needed For testing
         */
        PositionData positionDataTestCompare1 = new PositionData(dateTravelDistance1,53.88,45.5,2,1,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(dateTravelDistance2,33.22,99.2,10,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(dateTravelDistance3,88.92,13.2,3,7,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        assertEquals(expected, shipTestCompare1.getTreeOfPositionData().getTotalMovementTime());

    }
    /**
     *---------------------------------------------------------------------------------------
     *
     *                         DEPARTURE/ARRIVAL OF LATITUDE/LONGITUDE
     *
     * ---------------------------------------------------------------------------------------
     */

    @Test
    void closestDate(){

        /**
         * Wanted date
         */
        LocalDateTime dateWanted = LocalDateTime.of(2020, 12,30,22,19);

        /**
         * Objects Needed For testing
         */
        LocalDateTime datetest1 = LocalDateTime.of(2020, 12,30,17,19);
        LocalDateTime datetest2 = LocalDateTime.of(2020, 12,30,18,29);
        LocalDateTime datetest3 = LocalDateTime.of(2020, 12,30,19,19);
        LocalDateTime datetest4 = LocalDateTime.of(2020, 12,30,20,19);
        LocalDateTime datetest5 = LocalDateTime.of(2020, 12,30,21,29);
        LocalDateTime datetest6 = LocalDateTime.of(2020, 12,30,22,19);
        LocalDateTime datetest7 = LocalDateTime.of(2020, 12,30,23,19);
        LocalDateTime datetest8 = LocalDateTime.of(2020, 12,30,16,29);
        LocalDateTime datetest9 = LocalDateTime.of(2020, 12,30,15,19);

        PositionData positionDataTestCompare1 = new PositionData(datetest1,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(datetest2,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(datetest3,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare4 = new PositionData(datetest4,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare5 = new PositionData(datetest5,10,10,0,4,5,"1","Sopa");
        PositionData expected = new PositionData(datetest6,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare7 = new PositionData(datetest7,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare8 = new PositionData(datetest8,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare9 = new PositionData(datetest9,10,10,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);
        shipTestCompare1.addPositionData(positionDataTestCompare4);
        shipTestCompare1.addPositionData(positionDataTestCompare5);
        shipTestCompare1.addPositionData(expected);
        shipTestCompare1.addPositionData(positionDataTestCompare7);
        shipTestCompare1.addPositionData(positionDataTestCompare8);
        shipTestCompare1.addPositionData(positionDataTestCompare9);

        PositionData result = shipTestCompare1.getTreeOfPositionData().closestData(dateWanted);

        assertEquals(expected,result);
    }

    @Test
    void closestDate2(){

        /**
         * Wanted date
         */
        LocalDateTime dateWanted = LocalDateTime.of(2020, 12,30,22,50);

        /**
         * Objects Needed For testing
         */
        LocalDateTime datetest1 = LocalDateTime.of(2020, 12,30,17,19);
        LocalDateTime datetest2 = LocalDateTime.of(2020, 12,30,18,29);
        LocalDateTime datetest3 = LocalDateTime.of(2020, 12,30,19,19);
        LocalDateTime datetest4 = LocalDateTime.of(2020, 12,30,20,19);
        LocalDateTime datetest5 = LocalDateTime.of(2020, 12,30,21,29);
        LocalDateTime datetest6 = LocalDateTime.of(2020, 12,30,22,19);
        LocalDateTime datetest7 = LocalDateTime.of(2020, 12,30,23,19);
        LocalDateTime datetest8 = LocalDateTime.of(2020, 12,30,16,29);
        LocalDateTime datetest9 = LocalDateTime.of(2020, 12,30,15,19);

        PositionData positionDataTestCompare1 = new PositionData(datetest1,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(datetest2,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(datetest3,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare4 = new PositionData(datetest4,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare5 = new PositionData(datetest5,10,10,0,4,5,"1","Sopa");
        PositionData expected = new PositionData(datetest6,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare7 = new PositionData(datetest7,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare8 = new PositionData(datetest8,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare9 = new PositionData(datetest9,10,10,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);
        shipTestCompare1.addPositionData(positionDataTestCompare4);
        shipTestCompare1.addPositionData(positionDataTestCompare5);
        shipTestCompare1.addPositionData(expected);
        shipTestCompare1.addPositionData(positionDataTestCompare7);
        shipTestCompare1.addPositionData(positionDataTestCompare8);
        shipTestCompare1.addPositionData(positionDataTestCompare9);

        PositionData result = shipTestCompare1.getTreeOfPositionData().closestData(dateWanted);

        assertEquals(expected,result);
    }

    @Test
    void closestDate3(){

        /**
         * Wanted date
         */
        LocalDateTime dateWanted = LocalDateTime.of(2020, 12,30,18,49);

        /**
         * Objects Needed For testing
         */
        LocalDateTime datetest1 = LocalDateTime.of(2020, 12,30,17,19);
        LocalDateTime datetest2 = LocalDateTime.of(2020, 12,30,18,29);
        LocalDateTime datetest3 = LocalDateTime.of(2020, 12,30,19,19);

        PositionData positionDataTestCompare1 = new PositionData(datetest1,10,10,0,4,5,"1","Sopa");
        PositionData expected = new PositionData(datetest2,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(datetest3,10,10,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(expected);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        PositionData result = shipTestCompare1.getTreeOfPositionData().closestData(dateWanted);

        assertEquals(expected,result);
    }

    @Test
    void closestDate4(){

        /**
         * Wanted date
         */
        LocalDateTime dateWanted = LocalDateTime.of(2020, 12,30,22,49);

        /**
         * Objects Needed For testing
         */
        LocalDateTime datetest1 = LocalDateTime.of(2020, 12,30,17,19);
        LocalDateTime datetest2 = LocalDateTime.of(2020, 12,30,18,29);
        LocalDateTime datetest3 = LocalDateTime.of(2020, 12,30,19,19);

        PositionData positionDataTestCompare1 = new PositionData(datetest1,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(datetest2,10,10,0,4,5,"1","Sopa");
        PositionData expected = new PositionData(datetest3,10,10,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(expected);

        PositionData result = shipTestCompare1.getTreeOfPositionData().closestData(dateWanted);

        assertEquals(expected,result);
    }

    @Test
    void closestDate5(){

        /**
         * Wanted date
         */
        LocalDateTime dateWanted = LocalDateTime.of(2020, 12,30,15,49);

        /**
         * Objects Needed For testing
         */
        LocalDateTime datetest1 = LocalDateTime.of(2020, 12,30,17,19);
        LocalDateTime datetest2 = LocalDateTime.of(2020, 12,30,18,29);
        LocalDateTime datetest3 = LocalDateTime.of(2020, 12,30,19,19);

        PositionData positionDataTestCompare1 = new PositionData(datetest1,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare2 = new PositionData(datetest2,10,10,0,4,5,"1","Sopa");
        PositionData positionDataTestCompare3 = new PositionData(datetest3,10,10,0,4,5,"1","Sopa");

        shipTestCompare1.addPositionData(positionDataTestCompare1);
        shipTestCompare1.addPositionData(positionDataTestCompare2);
        shipTestCompare1.addPositionData(positionDataTestCompare3);

        PositionData result = shipTestCompare1.getTreeOfPositionData().closestData(dateWanted);

        assertNull(result);
    }






}