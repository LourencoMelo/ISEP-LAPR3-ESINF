package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

public class GetTotalNumberOfOccupiedSlotsController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     *  Constructor of GetTotalNumberOfOccupiedSlotsController
     */
    public GetTotalNumberOfOccupiedSlotsController(){
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of GetTotalNumberOfOccupiedSlotsController
     */
    public GetTotalNumberOfOccupiedSlotsController(Company company){
        this.company = company;
    }

    /**
     * Method that returns the Total Number Of Occupied Slots
     * @return totalOccupied
     */
    public int getTotalNumberOfOccupiedSlotsController(){
        return 0;
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }


}
