package lapr.project.utils;

import lapr.project.model.*;

public class App {
    private static App singleton = null;
    private Company company;


    private App() {
        this.company = new Company();
        bootstrap();
    }

    public static App getInstance() {
        if (singleton == null) {
            synchronized (App.class) {
                singleton = new App();
            }
        }
        return singleton;
    }

    public Company getCompany() {
        return this.company;
    }

    private void bootstrap() {

    }


}
