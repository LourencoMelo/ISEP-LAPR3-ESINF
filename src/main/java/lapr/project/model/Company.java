package lapr.project.model;

import lapr.project.auth.AuthFacade;
import lapr.project.utils.GraphGenerator;
import lapr.project.utils.TreeOfPorts;
import lapr.project.utils.TreeOfShips;
import lapr.project.utils.graph.Algorithms;
import lapr.project.utils.graph.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.Logger;

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
     * Tree of the ports
     */
    TreeOfPorts treeOfPorts;

    /**
     * List of all company countries
     */
    List<Country> countryList;

    /**
     * Graph generator instance
     */
    GraphGenerator graphGenerator;

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
        this.treeOfPorts = new TreeOfPorts();
        this.graphGenerator = new GraphGenerator();
        this.countryList = new ArrayList<>();
    }

    /**
     * Return the list of Ships ordered by travelled distance and number of movements (descending/ascending)
     *
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
     *
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
     *
     * @return tree of ships
     */
    public TreeOfShips getTreeOfShips() {
        return treeOfShips;
    }

    /**
     * Returns tree of ships ordered by IMO
     *
     * @return tree of ships
     */
    public TreeOfShips getTreeOfShipsIMO() {
        return treeOfShipsIMO;
    }

    /**
     * Returns tree of ships ordered by Call Sign
     *
     * @return tree of ships
     */
    public TreeOfShips getTreeOfShipsCallSign() {
        return treeOfShipsCallSign;
    }

    /**
     * Returns kd-tree of ports
     *
     * @return tree of ports
     */
    public TreeOfPorts getTreeOfPorts() {
        return treeOfPorts;
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
            if (ship.getVesselType() == vType && ship.atLeastTwo(date1, date2)) {
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
     *
     * @return allVesselTypes
     */
    public List<Integer> getVesselTypes() {
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
     *
     * @param a
     * @param b
     * @return boolean
     */
    public boolean closeDepartureArrival(Ship a, Ship b) {
        double distanceArrival = 0;
        double distanceDeparture = 0;
        distanceArrival = Distance.distance(a.arrivalLatitude(), a.arrivalLongitude(), b.arrivalLatitude(), b.arrivalLongitude());
        distanceDeparture = Distance.distance(a.departureLatitude(), a.departureLongitude(), b.departureLatitude(), b.departureLongitude());
        if (distanceArrival <= 5 && distanceDeparture <= 5 && a.travelledDistance() >= 10 && b.travelledDistance() >= 10 && a.travelledDistance() != b.travelledDistance()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calculates the travel Distance Differences
     *
     * @param pairOfShips
     * @return diff
     */
    public double travelDistanceDifference(Pair<Ship, Ship> pairOfShips) {
        double diff = 0;
        diff = Math.abs(pairOfShips.getFirst().travelledDistance() - pairOfShips.getSecond().travelledDistance());
        return diff;
    }

    /**
     * Gets the Pair of the Ships aggregated
     *
     * @return pairs
     */
    public List<Pair<Ship, Ship>> getPairShips() {
        List<Ship> ls = new ArrayList<>();
        List<Pair<Ship, Ship>> pairs = new ArrayList<>();
        for (Ship ship : treeOfShips.inOrder()) {
            ls.add(ship);
        }
        for (int i = 0; i < ls.size() - 1; i++) {
            for (int j = i + 1; j < ls.size(); j++) {
                if (closeDepartureArrival(ls.get(i), ls.get(j))) {
                    pairs.add(Pair.of(ls.get(i), ls.get(j)));
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
            if (travelDistanceDifference(o1) > travelDistanceDifference(o2)) {
                return -1;
            }
            if (travelDistanceDifference(o1) < travelDistanceDifference(o2)) {
                return 1;
            }
            return 0;
        };
        Collections.sort(pairs, comparator);
        return pairs;
    }

    /**
     * Finds the wanted message (PositionData) for the wanted call sign and date
     *
     * @param callSign call sign
     * @param date     date
     * @return message (position data)
     */
    public PositionData getPositionDataByCallSignAndDateTime(String callSign, LocalDateTime date) {
        Ship ship = treeOfShipsCallSign.getShipByCallSign(callSign);
        if (ship == null) {
            return null;
        }
        return ship.getTreeOfPositionData().closestData(date);
    }

    /**
     * Returns the closest port of a wanted ship in a wanted time
     *
     * @param callSign call sign
     * @param date     date
     * @return port
     */
    public PortAndWareHouse getClosest(String callSign, LocalDateTime date) {
        if (getPositionDataByCallSignAndDateTime(callSign, date) != null) {
            return treeOfPorts.getClosest(getPositionDataByCallSignAndDateTime(callSign, date));
        } else {
            throw new IllegalArgumentException("The data you inserted is illegible");
        }
    }


    /**
     * Gets the AuthFacade
     *
     * @return authFacade
     */
    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    /**
     * Getter method for graph instance
     *
     * @return graphGenerator instance
     */
    public GraphGenerator getGraphGenerator() {
        return graphGenerator;
    }

    /**
     * Generates the graph with all capitals.
     *
     * @param countries list of countries to import
     * @param borders   list of edges to add to the graph
     */
    public void generateGraph(File countries, File borders, File seaDists, int n) {

        //Fills the country list with the countries read on the file received
        graphGenerator.importCountries(countries, countryList);

        //Fills the countries subtrees of ports
        fillCountriesSubTreesOfPorts();

        //Inserts the vertex for all the capitals
        graphGenerator.generateCapitalVertex(countryList);

        //Adds all the edges read on the file received. This file represents all borders between countries.
        graphGenerator.addEdgesFromBorders(borders, countryList);

        //Adds all the ports to the graph
        graphGenerator.addPortsToGraph(treeOfPorts.getListOfAllPorts());

        //Add edges for all the ports from the same country
        graphGenerator.addEdgesForPortsSameCountry();

        //Add edges between capitals and closest ports
        graphGenerator.addEdgesFromClosestPortToCapital(countryList);

        //Imports all seadists to the map
        graphGenerator.importSeaDists(seaDists, treeOfPorts.getListOfAllPorts());

        //Add edges between closest n ports from diferent countries
        graphGenerator.NClosestPorts(countryList, n);
    }

    /**
     * Fills the countries subTrees of ports
     */
    public void fillCountriesSubTreesOfPorts() {
        for (Country country : countryList) {
            country.getTree_of_ports().fillSubTree(treeOfPorts.getListOfAllPorts(), country.getName());
        }
    }

    /**
     * Gets all the countries from the company
     *
     * @return list of countries
     */
    public List<Country> getCountryList() {
        return countryList;
    }

    /**
     * Colour the map of countries
     *
     * @param countryList list of countries
     */
    public void colourMap(List<Country> countryList) {
        graphGenerator.colourMap(countryList);
    }

    /**
     * ===========================US 418 =================================================
     */

    public List<String[][]> centerOfGravityEmptyShip(Ship ship){
        int width = (int) ship.getWidth();
        int length = (int) ship.getLength();
        int defHeight = 4;

        //Rectangle
        String[][] matrixRectangle = new String[length][width];
        for(String[] row : matrixRectangle){
            Arrays.fill(row, "0");
        }

        //Search for Center of Rectangle
        int whereIsX = (width/2) ;
        int whereIsY = (length/2) ;


        for(int i = 0; i < length; i++){
            if(i == whereIsY){
                for(int j = 0; j < width; j++){
                    if(j == whereIsX){
                        matrixRectangle[i][j] = "X";
                    }
                }
            }
        }

        //Triangle
        String[][] matrixTriangle = new String[4][];
        for (int i = 0; i < 4; i++){
            matrixTriangle[i] = new String[i+1];
            for (int j = 0; j <= i; j++){
                matrixTriangle[i][j] = "0";
            }
        }
        matrixTriangle[2][1] = "X";

        List<String[][]> list = new ArrayList<>();
        list.add(matrixRectangle);
        list.add(matrixTriangle);

        return list;
    }

    /**
     * ========================US 419 & US420 =========================================
     */


    /**
     * Importing the Containers by a file(.csv) and adding them to the ship
     *
     * @param file file introduced by the user
     * @param ship ship previous entered by the user to add the containers
     */
    public void containerImport(File file, Ship ship) {

        try (Scanner in = new Scanner(file)) {

            in.nextLine();

            LinkedList<Container> linkedListContainersExist = new LinkedList<>();

            while (in.hasNextLine()) {
                String[] container_info = in.nextLine().trim().split(",");

                try {
                    Container container = new Container(container_info[0].trim(), container_info[1].trim(), Integer.parseInt(container_info[2].trim()), Integer.parseInt(container_info[3].trim()), Integer.parseInt(container_info[4]), Integer.parseInt(container_info[5].trim()), Integer.parseInt(container_info[6].trim()));

                    if (!linkedListContainersExist.contains(container)) {
                        linkedListContainersExist.add(container);
                    }

                } catch (IllegalArgumentException exception) {
                    Logger.getLogger(exception.getMessage());
                }
            }

            ship.setContainers(linkedListContainersExist);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    /**
     * Allocates the ships into a matrix
     * Each level has a matrix
     *
     * @param ship
     * @return matrixLevels
     */
    public Map<Integer, double[][]> allocatingContainers(Ship ship) {
        //Creating the map to return
        Map<Integer, double[][]> matrixLevels = new LinkedHashMap<>();

        //Creating the matrix based on ship size
        int widthSize = (int) ship.getWidth();
        int lengthSize = (int) ship.getLength();

        //counter to walk through the linked list
        int counter = 0;
        int level = 0;
        float maxLevel = (float) ship.getLinkedListContainers().size() / (widthSize * lengthSize);
        float maxLevelAux = maxLevel;

        //Calculating how many levels are needed
        if (Math.round(maxLevelAux) > maxLevel) {
            maxLevel = Math.round(maxLevel);
        } else if (Math.round(maxLevelAux) == maxLevel) {
            System.out.println("Perfect Allocation");
        } else {
            maxLevel = Math.round(maxLevel);
            maxLevel++;
        }

        //filling the matrix
        for (int k = 0; k < maxLevel; k++) {
            double[][] matrix = new double[lengthSize][widthSize];
            for (int i = 0; i < lengthSize; i++) {
                for (int j = 0; j < widthSize; j++) {
                    if (counter < ship.getLinkedListContainers().size()) {
                        matrix[i][j] = ship.getLinkedListContainers().get(counter).getTare() + ship.getLinkedListContainers().get(counter).getPayload();
                        counter++;
                    }
                }
            }
            matrixLevels.put(level, matrix);
            level++;
        }

        return matrixLevels;
    }

    /**
     * Calculate the Center of Gravity
     * Put the results into a list
     * @param ship
     * @param matrixLevels
     * @return list with values
     */
    public List<Double> calculateCenterGravity(Ship ship, Map<Integer, double[][]> matrixLevels){

        double widthSizeRef = ship.getWidth()/2;
        double lengthSizeRef = ship.getLength()/2;
        double positionMassX = 0;
        double positionMassY = 0;
        double totalMass = 0;

        for(Map.Entry<Integer, double[][]> mapObject : matrixLevels.entrySet()){
            double [][] matrix = mapObject.getValue();
            widthSizeRef = widthSizeRef - 0.5;
            lengthSizeRef = lengthSizeRef - 0.5;

            for(int i = 0; i < ship.getLength(); i++){
                for(int j = 0; j < ship.getWidth(); j++){
                    positionMassX += matrix[i][j] * (j - widthSizeRef);
                    positionMassY += matrix[i][j] * (lengthSizeRef - i);
                    totalMass += matrix[i][j];
                }
            }
        }


        double resultX = 0;
        double resultY = 0;

        if(totalMass != 0){
            resultX = positionMassX/totalMass;
            resultY = positionMassY/totalMass;
        }

        List<Double> list = new ArrayList<>();
        list.add(resultX);
        list.add(resultY);

        return list;
    }

    /**
     * Shows in a matrix
     * Where is the center of gravity
     * With a "X"
     * @param ship
     * @param matrixLevels
     */
    public Map<List<Double>, String[][]> showCenterOfGravity(Ship ship, Map<Integer, double[][]> matrixLevels){
        //Calls the method calculateCenterGravity
        List<Double> list = calculateCenterGravity(ship, matrixLevels);
        Map<List<Double>, String[][]> mapShowCenter= new  HashMap<>();

        //Prints the results
        System.out.println("Center Gravity X:" + list.get(0));
        System.out.println("Center Gravity Y:" + list.get(1));

        //Gets the dimensions of the ship
        int length = (int) ship.getLength();
        int width = (int) ship.getWidth();

        //Creates and fills the String matrix
        String[][] matrixShow = new String[length][width];
        for(String[] row : matrixShow){
            Arrays.fill(row, "0");
        }

        int widthAux;
        int lengthAux;
        int whereIsX;
        int whereIsY;

        widthAux = (int) (width/2);
        lengthAux = (int) (length/2);

        //Discovering where is the Y of "X"
        whereIsX = (int) Math.round(list.get(0));
        whereIsY = (int) Math.round(list.get(1));

        whereIsX += widthAux;
        whereIsY = lengthAux - whereIsY;

        //Searches where is the center of gravity in the matrix
        for(int i = 0; i < ship.getLength(); i++){
            if(i == whereIsY){
                for(int j = 0; j < ship.getWidth(); j++){
                    if(j == whereIsX) {
                        matrixShow[i][j] = "X";
                    }
                }
            }
        }

        mapShowCenter.put(list, matrixShow);

        //Printing the results
        for(String[] row: matrixShow){
            System.out.println(Arrays.toString(row));
        }

        return mapShowCenter;

    }


    /**
     * Calculates the total mass of the ship
     * (Ship deadweight and containers)
     *
     * @param ship
     * @return totalmass
     */
    public double calculateTotalMass(Ship ship) {
        int size = ship.getLinkedListContainers().size();
        double weightByDefault = 200.0;
        double totalWeightContainers = size * weightByDefault;
        double shipDeadWeight = 3000;

        double totalMass = shipDeadWeight + totalWeightContainers;

        return totalMass;
    }

    /**
     * Calculates the difference of the heights
     * When the containers are not loaded
     * Compared when they are loaded
     *
     * @param ship
     * @param totalMass
     * @param shipDeadWeight
     * @param typeOfWater
     * @return difference
     */
    public double calculateDiffHeights(Ship ship, double totalMass, double shipDeadWeight, int typeOfWater) {
        //Density Liquids
        double liquidDensity;
        if (typeOfWater == 1) {
            liquidDensity = 1026.0;
        } else {
            liquidDensity = 1000.0;
        }

        //Measurements
        double width = ship.getWidth();
        double length = ship.getLength();
        double height = 10.0;

        //Sink and Height Volume With Containers
        double volumeSinkWithContainers = (totalMass / liquidDensity);
        double heightSinkWithContainersAux = (volumeSinkWithContainers * 2 * height) / (length * width);
        double heightSinkWithContainers = Math.sqrt(heightSinkWithContainersAux);

        //Sink and Height Volume Dead Weight
        double volumeSinkDead = (shipDeadWeight / liquidDensity);
        double heightSinkDeadAux = (volumeSinkDead * 2 * height) / (length * width);
        double heightSinkDead = Math.sqrt(heightSinkDeadAux);

        //Calculating the difference
        double difference = heightSinkDead - heightSinkWithContainers;

        return difference;
    }

    /**
     * Calculating Pressure on water By area
     * N/m^2
     *
     * @param ship
     * @param totalMass
     * @param typeOfWater
     * @return
     */
    public double calculatePressureOnWater(Ship ship, double totalMass, int typeOfWater) {
        //Density Liquids
        double liquidDensity;
        if (typeOfWater == 1) {
            liquidDensity = 1026.0;
        } else {
            liquidDensity = 1000.0;
        }

        //Gravity
        double gravity = 9.8;

        //Measurements
        double width = ship.getWidth();
        double length = ship.getLength();
        double height = 10.0;

        //Sink and Height and Width Volume With Containers
        double volumeSinkWithContainers = (totalMass / liquidDensity);
        double heightSinkWithContainersAux = (volumeSinkWithContainers * 2 * height) / (length * width);
        double heightSinkWithContainers = Math.sqrt(heightSinkWithContainersAux);

        double widthSinkWithContainers = (volumeSinkWithContainers * 2) / (length * heightSinkWithContainers);

        //Calculate hypotenuse
        double sum = (heightSinkWithContainers * heightSinkWithContainers) + (widthSinkWithContainers * widthSinkWithContainers);
        double hypotenuse = Math.sqrt(sum);

        //Calculate Total Area
        double totalArea = (widthSinkWithContainers * heightSinkWithContainers) + (hypotenuse * length * 2);

        //Calculate Pressure
        double pressure = (totalMass * gravity) / (totalArea);

        return pressure;
    }


    /////////////////////////////////////////////////////////// SHORTEST PATHS ///////////////////////////////////////////////////////////////////

    /**
     * Returns the object PortAndCapital by name
     *
     * @param name name
     * @return PortAndCapital
     */
    public PortAndCapital getVerticesByName(String name) {
        return graphGenerator.getVerticesByName(name);
    }

    //////////////////////////////// LAND PATH

    /**
     * Returns the closest Land Path between to places
     *
     * @param lc1 location 1
     * @param lc2 location 2
     * @return shortest path
     */
    public List<PortAndCapital> closestLandPath(PortAndCapital lc1, PortAndCapital lc2) {
        return graphGenerator.closestLandPath(lc1, lc2);
    }

    ////////////////////////////////// Maritime path

    /**
     * Returns if the PortAndCapital is a port
     *
     * @param port port
     * @return true or false
     */
    public boolean isPort(PortAndCapital port) {
        return graphGenerator.isPort(port);
    }

    /**
     * Gets the Shortest Maritime Path
     *
     * @param lc1 location 1
     * @param lc2 location 2
     * @return closest maritime path
     */
    public List<PortAndWareHouse> closestPathMaritime(PortAndWareHouse lc1, PortAndWareHouse lc2) {
        return graphGenerator.closestPathMaritime(lc1, lc2);
    }

    ////////////////////////////////// Maritime or land path

    /**
     * Finds the closest Land or Sea Path
     *
     * @param lc1 location 1
     * @param lc2 location 2
     * @return path
     */
    public List<PortAndCapital> closestPathLandOrSea(PortAndCapital lc1, PortAndCapital lc2) {
        return graphGenerator.closestPathLandOrSea(lc1, lc2);
    }

    ////////////////////////////////// Maritime or land path passing throw N points

    public List<PortAndCapital> closestPathPassingThroughNPoint(PortAndCapital lc1, PortAndCapital lc2, List<PortAndCapital> list) {
        return graphGenerator.closestPathPassingThroughNPoint(lc1,lc2,list);
    }


}
