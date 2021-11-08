package lapr.project.model;

import lapr.project.utils.AVL;
import lapr.project.utils.TreeOfShips;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;

public class Company {

    TreeOfShips treeOfShips;

    TreeOfShips treeOfShipsIMO;

    TreeOfShips treeOfShipsCallSign;


    public Company() {
        this.treeOfShips = new TreeOfShips();
        this.treeOfShipsIMO = new TreeOfShips();
        this.treeOfShipsCallSign = new TreeOfShips();

    }

    public TreeOfShips getTreeOfShips() {
        return treeOfShips;
    }

    public TreeOfShips getTreeOfShipsIMO() {
        return treeOfShipsIMO;
    }

    public TreeOfShips getTreeOfShipsCallSign() {
        return treeOfShipsCallSign;
    }

    public Ship getShipByMMSI(int MMSI) {
        return treeOfShips.getShipByMMSI(MMSI);
    }

    public Map<Ship, Double> getTopShipsWithMostKmByVesselType(LocalDateTime date1, LocalDateTime date2, int n, int vType) {

        Map<Ship, Double> topN = new HashMap<>();
        List<Ship> totalShipsByTravelledDistance = new ArrayList<>();

        for (Ship ship : treeOfShips.inOrder()) {
            if (ship.getVesselType() == vType && ship.finalDate().isAfter(date1) && ship.initialDate().isBefore(date2)) {
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

        int j = 0;
        if (totalShipsByTravelledDistance.size() > n) {
            for (j = 0; j < n; j++) {
                topN.put(totalShipsByTravelledDistance.get(j), totalShipsByTravelledDistance.get(j).getTreeOfPositionData().meanSOG(date1, date2));
            }
        }else{
            for(j = 0; j < totalShipsByTravelledDistance.size() - 1; j ++){
                topN.put(totalShipsByTravelledDistance.get(j), totalShipsByTravelledDistance.get(j).getTreeOfPositionData().meanSOG(date1, date2));
            }
        }
        return topN;
    }

}
