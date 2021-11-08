package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.TreeOfShips;

import java.io.File;

public class GetShipByCodeController {

    TreeOfShips treeOfShips = new TreeOfShips();

    public GetShipByCodeController() {
        treeOfShips.createTree(new File("Files/sships.csv"));
    }

    public void getShipByMMSI(int mMSI) {



    }

    public void getShipByImo(String iMO) {



    }

    public void getShipByCallSign(String callSign) {



    }
}
