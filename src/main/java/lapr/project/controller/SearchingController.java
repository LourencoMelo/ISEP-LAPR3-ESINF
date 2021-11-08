package lapr.project.controller;

import lapr.project.model.Ship;
import lapr.project.utils.AVL;
import lapr.project.utils.TreeOfShips;

import java.time.LocalDateTime;
import java.util.*;

public class SearchingController extends AVL<Ship> {

    TreeOfShips treeOfShips;

    public SearchingController(){
        treeOfShips = new TreeOfShips();
    }


    public Map<Ship, Double> getTopShipsWithMostKm(LocalDateTime date1, LocalDateTime date2, int n, int vType){

        Map<Ship,Double> topN = new HashMap<>();
        List<Ship> totalShipsByTravelledDistance = new ArrayList<>();

        for(Ship ship : inOrder()){
            if(ship.getVesselType() == vType){
                totalShipsByTravelledDistance.add(ship);
            }
        }
        Comparator<Ship> comparator = new Comparator<Ship>() {
            @Override
            public int compare(Ship s1, Ship s2) {
                if (s1.getTreeOfPositionData().travelledDistanceBtDates(date1, date2) > s2.getTreeOfPositionData().travelledDistanceBtDates(date1, date2)) {
                    return -1;
                }
                if (s1.getTreeOfPositionData().travelledDistanceBtDates(date1, date2) < s2.getTreeOfPositionData().travelledDistanceBtDates(date1, date2)) {
                    return 1;
                }
                return 0;
            }
        };
        Collections.sort(totalShipsByTravelledDistance, comparator);

        for(Ship ship : totalShipsByTravelledDistance){
            while(n != 0){
                topN.put(ship,ship.getTreeOfPositionData().meanSOG(date1,date2));
                n--;
            }
        }
        return topN;
    }


}
