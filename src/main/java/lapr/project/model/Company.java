package lapr.project.model;

import lapr.project.utils.AVL;
import lapr.project.utils.TreeOfShips;

import java.util.List;

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

    public void printMovementsTravelledAndDeltaDistance() {
        Comparator<Ship> comparator = new Comparator<Ship>() {
            @Override
            public int compare(Ship s1, Ship s2) {
                if (s1.getTreeOfPositionData().travelledDistance() > s2.getTreeOfPositionData().travelledDistance()) {
                    return -1;
                }
                if (s1.getTreeOfPositionData().travelledDistance() < s2.getTreeOfPositionData().travelledDistance()) {
                    return 1;
                }

                if(s1.getTreeOfPositionData().getTotalMovements() > s2.getTreeOfPositionData().getTotalMovements()) {
                    return 1;
                }
                if(s1.getTreeOfPositionData().getTotalMovements() < s2.getTreeOfPositionData().getTotalMovements()) {
                    return -1;
                }
                return 0;
            }
        };
        List<Ship> list = listMovementsTravelledAndDeltaDistance();

        Collections.sort(list, comparator);

        for(Ship s : list) {
            System.out.println(s.toStringMMSIMovementsTravelledDistanceDeltaDistance());
        }
    }

    private List<Ship> listMovementsTravelledAndDeltaDistance() {

        List<Ship> list = new ArrayList<>();

        for( Ship s : treeOfShips.inOrder()) {
            list.add(s);
        }

        return list;

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

    /**
     * Returns a map of the TOP-N ships with the most kilometres travelled and their respective average speed for a specific vessel type
     *
     * @param date1 initial date
     * @param date2 final date
     * @param n     N ships
     * @param vType Vessel Type
     * @return map of the TOP-N ships with the most kilometres travelled and their respective average speed
     */
    public Map<Ship, Double> getTopShipsWithMostKmByVesselType(LocalDateTime date1, LocalDateTime date2, int n, int vType) {

        // Creates a map where the Ship is the key and the average speed is the value
        Map<Ship, Double> topN = new HashMap<>();
        //List of ships between the wanted dates and with the same vessel type
        List<Ship> totalShipsByTravelledDistance = new ArrayList<>();

        for (Ship ship : treeOfShips.inOrder()) {
            if (ship.getVesselType() == vType && ship.finalDate().isAfter(date1) && ship.initialDate().isBefore(date2)) {
                totalShipsByTravelledDistance.add(ship);
            }
        }

        // Comparator used to order the list by Travelled Distance
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

        //Putting the top N ships and average speed into the map
        int j = 0;
        if (totalShipsByTravelledDistance.size() > n) {
            for (j = 0; j < n; j++) {
                topN.put(totalShipsByTravelledDistance.get(j), totalShipsByTravelledDistance.get(j).getTreeOfPositionData().meanSOG(date1, date2));
            }
        } else {
            for (j = 0; j < totalShipsByTravelledDistance.size() - 1; j++) {
                topN.put(totalShipsByTravelledDistance.get(j), totalShipsByTravelledDistance.get(j).getTreeOfPositionData().meanSOG(date1, date2));
            }
        }
        //returns the map
        return topN;
    }

    public HashMap<Ship, Set<PositionData>> getShipPositionMessagesOrderByDate(int code){
        HashMap<Ship, Set<PositionData>> mapShipPositionMessagesOrderedByDate = new HashMap<>();
        for(Ship ship: treeOfShips.inOrder()){
            Set<PositionData> positionDataSet = new HashSet<>();
            for(PositionData positionData: ship.getTreeOfPositionData().inOrder()){
                positionDataSet.add(positionData);
            }
            mapShipPositionMessagesOrderedByDate.put(ship, positionDataSet);
        }
        return mapShipPositionMessagesOrderedByDate;
    }


    /**
     * For each Vessel Type this method will give the TOP-N ships with the most kilometres travelled and their respective average speed
     *
     * @param date1 initial date
     * @param date2 final date
     * @param n     N ships
     */
    public void getTopShipsWithMostKm(LocalDateTime date1, LocalDateTime date2, int n) {
        //Creates a list of vessel types
        List<Integer> allVesselTypes = new ArrayList<>();
        for (Ship ship : treeOfShips.inOrder()) {
            if (!allVesselTypes.contains(ship.getVesselType())) {
                allVesselTypes.add(ship.getVesselType());
            }
        }
        //For each Vessel Type , creates the respective map
        for (Integer vTypes : allVesselTypes) {
            Map<Ship, Double> topN = getTopShipsWithMostKmByVesselType(date1, date2, n, vTypes);
            for (Map.Entry<Ship, Double> topiN : topN.entrySet()) {
                System.out.println(topiN);
            }
        }
    }
}
