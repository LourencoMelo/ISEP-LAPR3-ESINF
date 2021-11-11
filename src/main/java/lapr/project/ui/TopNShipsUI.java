package lapr.project.ui;

import lapr.project.controller.ApplicationController;
import lapr.project.controller.TopNController;

import java.time.LocalDateTime;
import java.util.Scanner;

public class TopNShipsUI {
    Scanner in = new Scanner(System.in);

    private ApplicationController applicationController;

    private TopNController topNController;

    public TopNShipsUI(){
        this.applicationController = new ApplicationController();
        this.topNController = new TopNController();
    }

    public void getTopNShips(){
    }
}
