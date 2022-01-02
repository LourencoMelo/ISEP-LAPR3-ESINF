package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Country;
import lapr.project.utils.App;

import java.util.List;

public class ColourMapController {

    /**
     * Creates instance of company
     */
    Company company;

    /**
     * Constructor of TopNController
     */
    public ColourMapController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor of TopNController
     * @param company
     */
    public ColourMapController(Company company){
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
     * Colour the map of countries
     * @param countryList list of countries
     */
    public void ColourMap(List<Country> countryList){
        company.colourMap(countryList);
    }

    /**
     * Returns the country list
     * @return country List
     */
    public List<Country> getCountryList(){
        return company.getCountryList();
    }

}
