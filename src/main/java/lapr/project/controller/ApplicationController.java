package lapr.project.controller;

import lapr.project.auth.store.UserStore;
import lapr.project.model.Company;
import lapr.project.utils.App;

public class ApplicationController {
    private Company company;

    private UserStore userStore;

    public ApplicationController() {
        this(App.getInstance().getCompany());
    }

    public ApplicationController(Company company) {
        this.company = company;
        this.userStore = new UserStore();
    }
}