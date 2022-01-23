package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.PortAndCapital;
import lapr.project.model.PortAndWareHouse;
import lapr.project.utils.App;

import java.util.List;

public class ShortestPathsController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     * Constructor of TopNController
     */
    public ShortestPathsController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor of TopNController
     * @param company
     */
    public ShortestPathsController(Company company){
        this.company = company;
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Returns the object PortAndCapital by name
     * @param name name
     * @return PortAndCapital
     */
    public PortAndCapital getVerticesByName(String name){
        return company.getVerticesByName(name);
    }


    //////////////////////// LAND PATH

    /**
     * Returns the closest Land Path between to places
     * @param lc1 location 1
     * @param lc2 location 2
     * @return shortest path
     */
    public List<PortAndCapital> closestLandPath(PortAndCapital lc1, PortAndCapital lc2) {
        return company.closestLandPath(lc1,lc2);
    }

    ///////////////////////// MARITIME PATH

    /**
     * Returns if the PortAndCapital is a port
     * @param port port
     * @return true or false
     */
    public boolean isPort(PortAndCapital port){
        return company.isPort(port);
    }

    /**
     * Gets the Shortest Maritime Path
     * @param lc1 location 1
     * @param lc2 location 2
     * @return closest maritime path
     */
    public List<PortAndWareHouse> closestPathMaritime(PortAndWareHouse lc1, PortAndWareHouse lc2){
        return company.closestPathMaritime(lc1,lc2);
    }

    ////////////////////////////// LAND OR MARITIME

    /**
     * Finds the closest Land or Sea Path
     *
     * @param lc1 location 1
     * @param lc2 location 2
     * @return path
     */
    public List<PortAndCapital> closestPathLandOrSea(PortAndCapital lc1, PortAndCapital lc2) {
        return company.closestPathLandOrSea(lc1,lc2);
    }

    ///////////////////// PASSING THROUGH N PLACES

    public List<PortAndCapital> closestPathPassingThroughNPoint(PortAndCapital lc1, PortAndCapital lc2, List<PortAndCapital> list) {
        return company.closestPathPassingThroughNPoint(lc1,lc2,list);
    }
}
