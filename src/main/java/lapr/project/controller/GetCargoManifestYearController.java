package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Pair;
import lapr.project.utils.App;

import java.util.List;

public class GetCargoManifestYearController {
    /**
     * Company instance
     */
    private Company company;

    /**
     * Constructor to get the same company as the other controllers
     */
    public GetCargoManifestYearController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor to associate the company of this controller to the company received with parameter
     * @param company instance
     */
    public GetCargoManifestYearController(Company company) {
        this.company = company;
    }

    /**
     * Return a pair with the number of cargo manifests transported that year and the average number per manifest
     * @return pair
     */
    public List<Pair<Integer, Integer>> getCargoManifestGivenYear(Integer year) {
        return null;
    }

    /**
     * Returns company
     * @return company
     */
    public Company getCompany() {
        return company;
    }
}
