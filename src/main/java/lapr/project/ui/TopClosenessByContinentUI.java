package lapr.project.ui;

import lapr.project.controller.TopClosenessByContinentController;

import java.util.Scanner;

public class TopClosenessByContinentUI implements Runnable{

    Scanner in = new Scanner(System.in);

    private final TopClosenessByContinentController topClosenessByContinentController;

    public TopClosenessByContinentUI(){
        this.topClosenessByContinentController = new TopClosenessByContinentController();
    }

    @Override
    public void run() {
        System.out.println("How many places you want to display by continent?");
        int topN = in.nextInt();
        if(topN <= 0){
            throw new IllegalArgumentException();
        }else{
            String arrayContinents[] = {"Europe","America"};
            System.out.println("============Result=============");
            for(int i=0; i< arrayContinents.length; i++){
                System.out.println(topClosenessByContinentController.topClosenessByContinentController(topN,arrayContinents[i]));
            }
        }
    }
}
