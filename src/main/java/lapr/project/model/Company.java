package lapr.project.model;

import lapr.project.auth.AuthFacade;
import lapr.project.utils.TreeOfShips;

import java.util.List;

import java.time.LocalDateTime;
import java.util.*;

public class Company {

    /**
     * Tree of ships instance ordered by MMSI
     */
    TreeOfShips treeOfShips;

    /**
     * Tree of the Ships ordered by IMO
     */
    TreeOfShips treeOfShipsIMO;

    /**
     * Tree of the Ships ordered by CallSign
     */
    TreeOfShips treeOfShipsCallSign;

    /**
     * Instance of AuthFacede
     */
    private final AuthFacade authFacade;

    /**
     * Constructor of Company
     */
    public Company() {
        this.authFacade = new AuthFacade();
        this.treeOfShips = new TreeOfShips();
        this.treeOfShipsIMO = new TreeOfShips();
        this.treeOfShipsCallSign = new TreeOfShips();

    }

    /**
     * Return the list of Ships ordered by travelled distance and number of movements (descending/ascending)
     * @return list of ships
     */
    public List<Ship> printMovementsTravelledAndDeltaDistance() {
        Comparator<Ship> comparator = (s1, s2) -> {
            if (s1.getTreeOfPositionData().travelledDistance() > s2.getTreeOfPositionData().travelledDistance()) {
                return -1;
            }
            if (s1.getTreeOfPositionData().travelledDistance() < s2.getTreeOfPositionData().travelledDistance()) {
                return 1;
            }

            if (s1.getTreeOfPositionData().getTotalMovements() > s2.getTreeOfPositionData().getTotalMovements()) {
                return 1;
            }
            if (s1.getTreeOfPositionData().getTotalMovements() < s2.getTreeOfPositionData().getTotalMovements()) {
                return -1;
            }
            return 0;
        };
        List<Ship> list = listMovementsTravelledAndDeltaDistance();

        Collections.sort(list, comparator);

        return list;
    }

    /**
     * Returns the list of ships that are in the TreeOfShips
     * @return list of ships
     */
    private List<Ship> listMovementsTravelledAndDeltaDistance() {

        List<Ship> list = new ArrayList<>();

        for (Ship s : treeOfShips.inOrder()) {

            list.add(s);
        }

        return list;

    }

    /**
     * Returns tree of ships ordered by MMSI
     * @return tree of ships
     */
    public TreeOfShips getTreeOfShips() {
        return treeOfShips;
    }

    /**
     * Returns tree of ships ordered by IMO
     * @return tree of ships
     */
    public TreeOfShips getTreeOfShipsIMO() {
        return treeOfShipsIMO;
    }

    /**
     * Returns tree of ships ordered by Call Sign
     * @return tree of ships
     */
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
        Map<Ship, Double> topN = new LinkedHashMap<>();
        //List of ships between the wanted dates and with the same vessel type
        List<Ship> totalShipsByTravelledDistance = new ArrayList<>();
        for (Ship ship : treeOfShips.inOrder()) {
            if(ship.getVesselType() == vType && ship.atLeastTwo(date1,date2)) {
                    totalShipsByTravelledDistance.add(ship);
            }
        }

        // Comparator used to order the list by Travelled Distance
        Comparator<Ship> comparator = (a, b) -> {
            if (a.travelledDistanceBtDates(date1, date2) > b.travelledDistanceBtDates(date1, date2)) {
                return -1;
            }
            if (a.travelledDistanceBtDates(date1, date2) < b.travelledDistanceBtDates(date1, date2)) {
                return 1;
            }
            return 0;
        };
        Collections.sort(totalShipsByTravelledDistance, comparator);

        //Putting the top N ships and average speed into the map
        int j = 0;
        if (totalShipsByTravelledDistance.size() > n) {
            for (j = 0; j < n; j++) {
                topN.put(totalShipsByTravelledDistance.get(j), totalShipsByTravelledDistance.get(j).meanSOG(date1, date2));
            }
        } else {
            for (j = 0; j < totalShipsByTravelledDistance.size(); j++) {
                topN.put(totalShipsByTravelledDistance.get(j), totalShipsByTravelledDistance.get(j).meanSOG(date1, date2));
            }
        }
        //returns the map
        return topN;
    }


    /**
     * Searches the ship by the code introduced and returns an hashmap with the positions ordered by date
     *
     * @param ship
     * @return mapShipPositionMessagesOrderedByDate
     */
    public HashMap<Ship, Set<PositionData>> getShipPositionMessagesOrderByDate(Ship ship) {
        HashMap<Ship, Set<PositionData>> mapShipPositionMessagesOrderedByDate = new HashMap<>();
        Set<PositionData> positionDataSet = new HashSet<>();

        for (PositionData positionData : ship.getTreeOfPositionData().inOrder()) {
            positionDataSet.add(positionData);
        }
        mapShipPositionMessagesOrderedByDate.put(ship, positionDataSet);

        return mapShipPositionMessagesOrderedByDate;
    }

    /**
     * Gets the VesselTypes in a List
     * @return allVesselTypes
     */
    public List<Integer> getVesselTypes(){
        //Creates a list of vessel types
        List<Integer> allVesselTypes = new ArrayList<>();
        for (Ship ship : treeOfShips.inOrder()) {
            if (!allVesselTypes.contains(ship.getVesselType())) {
                allVesselTypes.add(ship.getVesselType());
            }
        }
        return allVesselTypes;
    }

    /**
     * CloseDeparturArrival
     * @param a
     * @param b
     * @return boolean
     */
    public boolean closeDepartureArrival(Ship a, Ship b){
        double distanceArrival = 0;
        double distanceDeparture = 0;
        distanceArrival = Distance.distance(a.arrivalLatitude(),a.arrivalLongitude(),b.arrivalLatitude(),b.arrivalLongitude());
        distanceDeparture = Distance.distance(a.departureLatitude(),a.departureLongitude(),b.departureLatitude(),b.departureLongitude());
        if(distanceArrival <= 5 && distanceDeparture <= 5 && a.travelledDistance() >= 10 && b.travelledDistance() >= 10 && a.travelledDistance() != b.travelledDistance()){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Calculates the travel Distance Differences
     * @param pairOfShips
     * @return diff
     */
    public double travelDistanceDifference(Pair<Ship, Ship> pairOfShips){
        double diff = 0;
        diff = Math.abs(pairOfShips.getFirst().travelledDistance() - pairOfShips.getSecond().travelledDistance());
        return diff;
    }

    /**
     * Gets the Pair of the Ships aggregated
     * @return pairs
     */
    public List<Pair<Ship, Ship>> getPairShips(){
        List<Ship> ls = new ArrayList<>();
        List<Pair<Ship, Ship>> pairs = new ArrayList<>();
        for(Ship ship : treeOfShips.inOrder()){
            ls.add(ship);
        }
        for(int i = 0; i < ls.size() - 1; i ++){
            for(int j = i + 1; j < ls.size(); j ++ ){
                if(closeDepartureArrival(ls.get(i),ls.get(j))){
                    pairs.add(Pair.of(ls.get(i),ls.get(j)));
                }
            }
        }

        Comparator<Pair<Ship, Ship>> comparator = (o1, o2) -> {
            if (o1.getFirst().getMMSI() > o2.getFirst().getMMSI()) {
                return -1;
            }
            if (o1.getFirst().getMMSI() < o2.getFirst().getMMSI()) {
                return 1;
            }
            if (travelDistanceDifference(o1) > travelDistanceDifference(o2)){
                return -1;
            }
            if (travelDistanceDifference(o1) < travelDistanceDifference(o2)){
                return 1;
            }
            return 0;
        };
        Collections.sort(pairs, comparator);
        return pairs;
    }

    /**
     * Gets the AuthFacade
     * @return authFacade
     */
    public AuthFacade getAuthFacade() {
        return authFacade;
    }
}
