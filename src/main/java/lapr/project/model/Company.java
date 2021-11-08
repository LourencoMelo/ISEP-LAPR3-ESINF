package lapr.project.model;

import lapr.project.utils.TreeOfShips;

public class Company {

    TreeOfShips treeOfShips;

    public Company() {
        this.treeOfShips = new TreeOfShips();
    }

    public TreeOfShips getTreeOfShips() {
        return treeOfShips;
    }
}
