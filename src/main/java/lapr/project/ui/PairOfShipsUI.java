package lapr.project.ui;

import lapr.project.controller.PairOfShipsController;
import lapr.project.model.Pair;
import lapr.project.model.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PairOfShipsUI {
    Scanner in = new Scanner(System.in);

    private PairOfShipsController pairOfShipsController;

    public PairOfShipsUI(){
        this.pairOfShipsController = new PairOfShipsController();
    }

    public void getPairShips(){
        List<Pair<Ship, Ship>> pairs = new ArrayList<>();
        pairs = pairOfShipsController.getPairShips();
        System.out.println(pairs);
    }
}
