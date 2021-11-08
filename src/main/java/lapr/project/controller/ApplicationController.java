package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.utils.App;

public class ApplicationController {

    private Company company;

    public ApplicationController() {
        this(App.getInstance().getCompany());
    }

    public ApplicationController(Company company){
        this.company = company;
    }

}
