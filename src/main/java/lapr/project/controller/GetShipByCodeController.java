package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.App;

public class GetShipByCodeController {

    /**
     * Company instance
     */
    private Company company;

    /**
     * Constructor to get the same company as the other controllers
     */
    public GetShipByCodeController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor to associate the company of this controller to the company received with parameter
     * @param company instace
     */
    public GetShipByCodeController(Company company) {
        this.company = company;
    }

    /**
     * Returns the Ship that has the code sent by parameter
     * @param code MMSI or IMO or Call Sign
     * @return ship
     */
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

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }
}
