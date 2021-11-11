package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.App;

public class GetShipByCodeController {

    private Company company;

    public GetShipByCodeController() {
        this(App.getInstance().getCompany());
    }

    public GetShipByCodeController(Company company) {
        this.company = company;
    }

    public Ship getShipByCode(String code) {
        if (code.startsWith("IMO")) {
            return this.company.getTreeOfShipsIMO().getShipByImo(code);
        }

        try {

            return this.company.getTreeOfShips().getShipByMMSI(Integer.parseInt(code));

        } catch (NumberFormatException exception) {

            return this.company.getTreeOfShipsCallSign().getShipByCallSign(code);

        }

    }

}
