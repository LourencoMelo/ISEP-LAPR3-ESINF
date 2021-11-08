package lapr.project.model;

import lapr.project.utils.TreeOfShips;

import java.io.File;

public class Company {

    TreeOfShips treeOfShips;

    TreeOfShips treeOfShipsIMO;

    TreeOfShips treeOfShipsCallSign;


    public Company() {
        this.treeOfShips = new TreeOfShips();
        this.treeOfShipsIMO = new TreeOfShips();
        this.treeOfShipsCallSign = new TreeOfShips();

    }

    public TreeOfShips getTreeOfShips() {
        return treeOfShips;
    }

    public TreeOfShips getTreeOfShipsIMO() {
        return treeOfShipsIMO;
    }

    public TreeOfShips getTreeOfShipsCallSign() {
        return treeOfShipsCallSign;
    }

    public Ship getShipByMMSI(int MMSI) {
        return treeOfShips.getShipByMMSI(MMSI);
    }

}
