package lapr.project.utils;

import lapr.project.controller.ImportFileController;
import lapr.project.model.Company;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class TreeOfShipsTest {

    @Test
    void readFileWrongPath() {
        String expected = "File Not Found!";

        TreeOfShips treeOfShips = new TreeOfShips();
        try {
            treeOfShips.createTreeMMSI(new File("ola"));
        }catch (Exception exception){
            assertEquals(exception.getMessage(), expected);
        }

        try {
            treeOfShips.createTreeIMO(new File("ola"));
        }catch (Exception exception){
            assertEquals(exception.getMessage(), expected);
        }

        try {
            treeOfShips.createTreeCallSign(new File("ola"));
        }catch (Exception exception){
            assertEquals(exception.getMessage(), expected);
        }
    }

    @Test
    void createByIMOCheckCorrectPositionsData() {
        TreeOfShips treeOfShips = new TreeOfShips();

        treeOfShips.createTreeIMO(new File("Files/sships.csv"));

        assertEquals(25,treeOfShips.getShipByImo("IMO9395044").getTreeOfPositionData().size());
    }

    @Test
    void createByCallSignCheckCorrectPositionsData() {
        TreeOfShips treeOfShips = new TreeOfShips();

        treeOfShips.createTreeCallSign(new File("Files/sships.csv"));

        assertEquals(19,treeOfShips.getShipByCallSign("FLSU").getTreeOfPositionData().size());
    }
}