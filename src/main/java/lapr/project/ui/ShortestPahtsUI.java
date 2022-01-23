package lapr.project.ui;

import lapr.project.controller.ShortestPathsController;
import lapr.project.model.PortAndCapital;
import lapr.project.model.PortAndWareHouse;

import java.util.*;

public class ShortestPahtsUI implements Runnable{

    private final ShortestPathsController shortestPathsController;

    public ShortestPahtsUI(){
        this.shortestPathsController = new ShortestPathsController();
    }

    Scanner in = new Scanner(System.in);
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println("Which of the shortest paths do you want verify?");
        System.out.println("Land path (only includes land routes, may start/end in port/city) - 1");
        System.out.println("Maritime path (only includes ports) - 2");
        System.out.println("Land or sea path (may include cities and ports) - 3");
        System.out.println("Obligatorily passing through n indicated places - 4");
        int n = in.nextInt();
        if(n == 1){
            System.out.println("Please write the first location!");
            String location1 = in.nextLine();
            System.out.println("Please write the second location!");
            String location2 = in.nextLine();
            PortAndCapital lct1 = shortestPathsController.getVerticesByName(location1);
            PortAndCapital lct2 = shortestPathsController.getVerticesByName(location2);
            List<PortAndCapital> path = shortestPathsController.closestLandPath(lct1,lct2);
            System.out.println(path);
        }else if(n == 2){
            System.out.println("Please write the first location!");
            String location1 = in.nextLine();
            System.out.println("Please write the second location!");
            String location2 = in.nextLine();
            PortAndCapital lct1 = shortestPathsController.getVerticesByName(location1);
            PortAndCapital lct2 = shortestPathsController.getVerticesByName(location2);
            if(shortestPathsController.isPort(lct1) && shortestPathsController.isPort(lct2)) {
                List<PortAndWareHouse> path = shortestPathsController.closestPathMaritime((PortAndWareHouse) lct1, (PortAndWareHouse) lct2);
                System.out.println(path);
            }
            System.out.println("The locations you entered are eligible!");
        }else if(n == 3){
            System.out.println("Please write the first location!");
            String location1 = in.nextLine();
            System.out.println("Please write the second location!");
            String location2 = in.nextLine();
            PortAndCapital lct1 = shortestPathsController.getVerticesByName(location1);
            PortAndCapital lct2 = shortestPathsController.getVerticesByName(location2);
            List<PortAndCapital> path = shortestPathsController.closestPathLandOrSea(lct1,lct2);
            System.out.println(path);
        }else if(n == 4){
            System.out.println("Please write the first location!");
            String location1 = in.nextLine();
            System.out.println("Please write the second location!");
            String location2 = in.nextLine();
            System.out.println("How many locations do you want the path to go through?");
            int nLocations = in.nextInt();
            in.nextLine();
            PortAndCapital lct1 = shortestPathsController.getVerticesByName(location1);
            PortAndCapital lct2 = shortestPathsController.getVerticesByName(location2);
            List<PortAndCapital> listNLocals = new LinkedList<>();
            for(int i = 0;i < nLocations;i++){
                System.out.println("Please write the location!");
                String location = in.nextLine();
                listNLocals.add(shortestPathsController.getVerticesByName(location));
            }
            List<PortAndCapital> path = shortestPathsController.closestPathPassingThroughNPoint(lct1,lct2,listNLocals);
            System.out.println(path);
        }
    }

}
