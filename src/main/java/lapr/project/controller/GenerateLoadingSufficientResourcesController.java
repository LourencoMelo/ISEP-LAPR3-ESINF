package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

import java.util.Map;

public class GenerateLoadingSufficientResourcesController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     *  Constructor of GenerateLoadingSufficientResourcesController
     */
    public GenerateLoadingSufficientResourcesController(){
        this(App.getInstance().getCompany());
    }

    /**
     *  Constructor of GenerateLoadingSufficientResourcesController
     */
    public GenerateLoadingSufficientResourcesController(Company company){
        this.company = company;
    }

    /**
     * Genaretes the loading and
     * unloading map based on ships and trucks load
     * manifests and corresponding travel plans
     * @return null
     */
    public Map<Object, Object> generateLoadingSufficientResourcesController(){
        return null;
    }

    /**
     * Returns the company instace
     * @return company
     */
    public Company getCompany() {
        return company;
    }


}
