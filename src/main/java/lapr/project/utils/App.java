package lapr.project.utils;

import lapr.project.auth.AuthFacade;
import lapr.project.auth.UserSession;
import lapr.project.model.*;

public class App {

    private static App singleton = null;
    private final Company company;
    private final AuthFacade authFacade;
    private final String ID = "TrafficManager";
    private final String ClientRole = "Client";
    private final String ShipCaptain = "ShipCaptain";

    private App() {
        this.company = new Company();
        this.authFacade = this.company.getAuthFacade();
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

    public UserSession getCurrentUserSession() {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd) {
        return this.authFacade.doLogin(email, pwd).isLoggedIn();
    }

    public void doLogout() {
        this.authFacade.doLogout();
    }

    private void bootstrap() {
            this.authFacade.addUserRole(ID,ID);
            this.authFacade.addUserRole(ClientRole,ClientRole);
            this.authFacade.addUserRole(ShipCaptain,ShipCaptain);

            this.authFacade.addUserWithRole("João","joao@gmail.com","12345",ID);
            this.authFacade.addUserWithRole("Client","client@gmail.com", "12345", ClientRole);
            this.authFacade.addUserWithRole("Vanessa", "vanessa@gmail.com", "12345", ShipCaptain);
    }


}
