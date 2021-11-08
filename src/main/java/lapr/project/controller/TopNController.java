package lapr.project.controller;

import lapr.project.model.Company;
import lapr.project.model.Ship;
import lapr.project.utils.AVL;
import lapr.project.utils.TreeOfShips;

import java.time.LocalDateTime;
import java.util.*;

public class TopNController extends AVL<Ship> {

    Company company;
    TreeOfShips treeOfShips;

    public TopNController(){
        treeOfShips = new TreeOfShips();
    }

    public void getTopShipsWithMostKm(LocalDateTime date1, LocalDateTime date2, int n){

        List<Integer> allVesselTypes = new ArrayList<>();

        for(Ship ship : inOrder()){
            if(!allVesselTypes.contains(ship.getVesselType())){
                allVesselTypes.add(ship.getVesselType());
            }
        }

        for(Integer vTypes : allVesselTypes){
            Map<Ship, Double> topN = company.getTopShipsWithMostKmByVesselType(date1,date2,n,vTypes);
            for(Map.Entry<Ship, Double> topiN : topN.entrySet()){
                System.out.println(topiN);
            }
        }
    }






}
