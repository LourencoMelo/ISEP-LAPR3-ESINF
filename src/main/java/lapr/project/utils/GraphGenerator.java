package lapr.project.utils;

import lapr.project.model.*;
import lapr.project.utils.graph.Algorithms;
import lapr.project.utils.graph.Edge;
import lapr.project.utils.graph.Graph;
import lapr.project.utils.graph.matrix.MatrixGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Logger;

public class GraphGenerator {

    /**
     * Graph of capitals and ports
     */
    private final Graph<PortAndCapital, Double> graph;


    private final Map<PortAndWareHouse, List<SeaDist>> seaDistancesMap;

    /**
     * Constructor that initializes the graph
     */
    public GraphGenerator() {
        this.graph = new MatrixGraph<>(false);
        this.seaDistancesMap = new HashMap<>();
    }


    /**
     * Imports the information from the countries file
     *
     * @param file        file path
     * @param countryList list of countries from the company
     */
    public void importCountries(File file, List<Country> countryList) {

        try (Scanner in = new Scanner(file)) {

            in.nextLine();

            while (in.hasNextLine()) {

                String[] line = in.nextLine().trim().split(",");

                try {

                    Capital capital = new Capital(line[5].trim(), Double.parseDouble(line[6].trim()), Double.parseDouble(line[7].trim()), line[0].trim());

                    Country country = new Country(line[0].trim(), line[1].trim(), line[2].trim(), line[3].trim(), Double.parseDouble(line[4].trim()), capital);

                    if (!countryList.contains(country)) countryList.add(country);

                } catch (Exception exception) {
                    Logger.getLogger(exception.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            Logger.getLogger(e.getMessage());
        }

    }

    /**
     * Creates all vertex for respective capitals
     */
    public void generateCapitalVertex(List<Country> countryList) {

        for (Country country : countryList) {
            insert(country.getCapital());
        }

    }

    /**
     * Inserts new vertex to the graph. Checks if the graph contains the vertex first.
     *
     * @param portAndCapital object to insert as a vertex
     * @return true if added. False if failed.
     */
    public boolean insert(PortAndCapital portAndCapital) {

        if (!graph.validVertex(portAndCapital)) {
            return graph.addVertex(portAndCapital);
        }

        return false;
    }


    /**
     * Creates the edges received from the borders file
     *
     * @param file file path with borders info
     */
    public void addEdgesFromBorders(File file, List<Country> countryList) {
        try (Scanner in = new Scanner(file)) {

            in.nextLine();

            while (in.hasNextLine()) {

                String[] line = in.nextLine().trim().split(",");

                try {

                    Capital capital1 = getCapitalByCountryName(line[0].trim(), countryList);
                    Capital capital2 = getCapitalByCountryName(line[1].trim(), countryList);

                    if (capital1 != null && capital2 != null) {

                        graph.addEdge(capital1, capital2, Distance.distance(capital1.getLatitude(), capital1.getLongitude(), capital2.getLatitude(), capital2.getLongitude()));
                    }


                } catch (Exception exception) {
                    Logger.getLogger(exception.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            Logger.getLogger(e.getMessage());
        }
    }

    public void addPortsToGraph(List<PortAndWareHouse> portAndWareHouseList) {
        for (PortAndWareHouse portAndWareHouse : portAndWareHouseList) {
            insert(portAndWareHouse);
        }
    }

    /**
     * Adds edges between the closest port and capital from a country
     *
     * @param countryList list of countries from the company
     */
    public void addEdgesFromClosestPortToCapital(List<Country> countryList) {
        for (Country country : countryList) {
            if (country.getTree_of_ports().size() != 0) {
                Capital capital = country.getCapital();
                PortAndWareHouse portAndWareHouse = country.getTree_of_ports().findNearestNeighbour(capital.getLatitude(), capital.getLongitude());

                if (portAndWareHouse != null)
                    graph.addEdge(country.getCapital(), portAndWareHouse, Distance.distance(capital.getLatitude(), capital.getLongitude(), portAndWareHouse.getLatitude(), portAndWareHouse.getLongitude()));
            }
        }
    }

    /**
     * Adds edges between ports from the same country
     */
    public void addEdgesForPortsSameCountry() {
        for (PortAndCapital vertex : graph.vertices()) {
            for (PortAndCapital vertex2 : graph.vertices()) {
                if (vertex != vertex2 && vertex instanceof PortAndWareHouse && vertex2 instanceof PortAndWareHouse) {
                    if (((PortAndWareHouse) vertex).getCountry().equals(((PortAndWareHouse) vertex2).getCountry())) {
                        graph.addEdge(vertex, vertex2, Distance.distance(vertex.getLatitude(), vertex.getLongitude(), vertex2.getLatitude(), vertex2.getLongitude()));
                    }
                }
            }
        }
    }


    /**
     * Imports SeadDists from file and fills the map with seadists ordered for each port from the company
     *
     * @param file file with info
     */
    public void importSeaDists(File file, List<PortAndWareHouse> portList) {

        try (Scanner in = new Scanner(file)) {

            in.nextLine();

            while (in.hasNextLine()) {

                String[] line = in.nextLine().trim().split(",");

                try {

                    PortAndWareHouse originPort = findPortByID(Integer.parseInt(line[1].trim()), portList);
                    PortAndWareHouse destinyPort = findPortByID(Integer.parseInt(line[4].trim()), portList);

                    if (originPort != null && destinyPort != null) {
                        SeaDist seaDist = new SeaDist(originPort, destinyPort, Double.parseDouble(line[6].trim()));

                        if (seaDistancesMap.get(originPort) == null) {
                            seaDistancesMap.put(originPort, new ArrayList<>());
                            seaDistancesMap.get(originPort).add(seaDist);
                        } else {
                            seaDistancesMap.get(originPort).add(seaDist);
                        }
                    }

                } catch (Exception exception) {
                    Logger.getLogger(exception.getMessage());
                }
            }


        } catch (FileNotFoundException e) {
            Logger.getLogger(e.getMessage());
        }

        seaDistancesMap.values().forEach(Collections::sort);
    }

    /**
     * Adds edges between n closest ports
     *
     * @param countryList list of countries from the company
     * @param n           n closest ports
     */
    public void NClosestPorts(List<Country> countryList, int n) {

        for (Country country : countryList) {
            for (PortAndWareHouse portAndWareHouse : country.getTree_of_ports().inOrder()) {
                int i = 0, j = 0;
                while (i < n) {

                    if (seaDistancesMap.get(portAndWareHouse) == null) break;

                    if (j == seaDistancesMap.get(portAndWareHouse).size()) break;

                    SeaDist seaDist = seaDistancesMap.get(portAndWareHouse).get(j);

                    if (portAndWareHouse != null && seaDist.getDestinyPort() != null && !Objects.equals(portAndWareHouse.getCountry(), seaDist.getDestinyPort().getCountry())) {
                        graph.addEdge(portAndWareHouse, seaDist.getDestinyPort(), seaDist.getSeaDistance());
                        i++;
                    }
                    j++;
                }
            }
        }

    }

    /**
     * Getter method to find the capital of a country
     *
     * @param countryName name of the country
     * @param countryList list of countries from company
     * @return capital of the country
     */
    public Capital getCapitalByCountryName(String countryName, List<Country> countryList) {
        for (Country country : countryList) {
            if (country.getName().equalsIgnoreCase(countryName)) return country.getCapital();
        }

        return null;
    }

    /**
     * Gets the country by Capital Name
     *
     * @param capitalName capital name
     * @param countryList list of countries
     * @return Country
     */
    public Country getCountryByCapitalName(String capitalName, List<Country> countryList) {
        for (Country country : countryList) {
            if (country.getCapital().getName().equalsIgnoreCase(capitalName)) return country;
        }
        return null;
    }


    /**
     * Gets the graph
     *
     * @return graph
     */
    public Graph<PortAndCapital, Double> getGraph() {
        return graph;
    }

    public List<Capital> getVertexCapital() {
        ArrayList<Capital> capitalArrayList = new ArrayList<>();
        graph.vertices().forEach(capitals ->
        {
            if (capitals instanceof Capital) {
                capitalArrayList.add((Capital) capitals);
            }
        });
        return capitalArrayList;
    }

    /**
     * Gets the adjacent capitals
     *
     * @param cap capital
     * @return list of adjacent capitals
     */
    public List<Capital> getAdjVertexCapital(Capital cap) {
        ArrayList<Capital> adjCapitalArrayList = new ArrayList<>();
        graph.adjVertices(cap).forEach(capitals ->
        {
            if (capitals instanceof Capital) {
                adjCapitalArrayList.add((Capital) capitals);
            }
        });
        return adjCapitalArrayList;
    }

    /**
     * Colours the map
     *
     * @param countryList list of country
     */
    public void colourMap(List<Country> countryList) {
        countryList.get(0).setColour(0);

        boolean[] remainingColors = new boolean[countryList.size()];

        Arrays.fill(remainingColors, true);

        for (Capital capital : getVertexCapital()) {
            for (Capital capitalAdj : getAdjVertexCapital(capital)) {
                Country country = getCountryByCapitalName(capitalAdj.getName(), countryList);
                if (country.getColour() != -1) {
                    remainingColors[country.getColour()] = false;
                }
            }
            int cor;
            for (cor = 0; cor < countryList.size(); cor++) {
                if (remainingColors[cor])
                    break;
            }

            getCountryByCapitalName(capital.getName(), countryList).setColour(cor);
            Arrays.fill(remainingColors, true);
        }
    }

    /**
     * Finds a port by its id
     *
     * @param id       id of the port to find
     * @param portList list of ports from the company
     * @return port found or null if not found
     */
    public PortAndWareHouse findPortByID(int id, List<PortAndWareHouse> portList) {

        for (PortAndWareHouse portAndWareHouse : portList) {

            if (portAndWareHouse.getCode() == id) return portAndWareHouse;

        }

        return null;

    }

    /**
     * Map of seadistances
     *
     * @return map
     */
    public Map<PortAndWareHouse, List<SeaDist>> getSeaDistancesMap() {
        return seaDistancesMap;
    }

    public Map<Double, PortAndCapital> topClosenessByContinent(int topN, String continent) {

        //Creates the map to aux
        Map<Double, PortAndCapital> auxMap = new TreeMap<>(Double::compare);

        //Creates the map that is going to be returned
        Map<Double, PortAndCapital> lastMap = new LinkedHashMap<>();

        //Creates a List of that specific continent
        List<PortAndCapital> listLocations = new ArrayList<>();

        //Adds in the "listLocations" if is in the same continent
        for (PortAndCapital location : graph.vertices()) {
            if (location.getContinent().compareTo(continent) == 0) {
                listLocations.add(location);
            }
        }

        for (PortAndCapital location1 : listLocations) {
            double averageCloseness = 0;
            double sum = 0;
            for (PortAndCapital location2 : listLocations) {
                LinkedList<PortAndCapital> path = new LinkedList<>(); //To save the sequence of the paths
                Algorithms.shortestPath(graph, location1, location2, Double::compare, Double::sum, 0.0, path); //Saves the shortestPath on path
                for (int i = 0; i < path.size(); i++) { //Gets the weight of the path between location1 & location 2
                    if (i + 1 == path.size()) {
                        break;
                    }
                    sum += graph.edge(path.get(i), path.get(i + 1)).getWeight();
                }
            }
            averageCloseness = sum / listLocations.size();
            auxMap.put(averageCloseness, location1);
        }

        //Ordering the Map ascending order(The locations that have the most closeness)
        //auxMap.entrySet().stream().sorted(Map.Entry.comparingByKey());

        //Limiting the return to the TopN Places in closeness
        int limitTopN = 0;
        for (Map.Entry<Double, PortAndCapital> mapObject : auxMap.entrySet()) {
            if (limitTopN == topN) {
                return lastMap;
            }
            lastMap.put(mapObject.getKey(), mapObject.getValue());
            limitTopN++;
        }

        return lastMap;
    }


    /**
     * Iterates through the graph and fills the centralitys
     *
     * @return ordered map by centralitys
     */
    public Map<PortAndWareHouse, Integer> getCentralitys() {

        Map<PortAndWareHouse, Integer> centrality_map = new HashMap<>(); //Map to be filled with all the ports present on the graph and his respective centralitys

        for (PortAndCapital local : graph.vertices()) {
            ArrayList<LinkedList<PortAndCapital>> paths = new ArrayList<>(); //Array of the shortest paths for each vertex of the graph

            ArrayList<Double> dists = new ArrayList<>(); //Array of distances of the shortest paths

            Algorithms.shortestPaths(graph, local, Double::compare, Double::sum, 0.0, paths, dists); //Calculates all shortest paths to the respective local

            for (LinkedList<PortAndCapital> path : paths) {  //For each

                if (path != null) {

                    for (PortAndCapital local1 : path) {

                        if (local1 instanceof PortAndWareHouse) {

                            Integer count = centrality_map.get(local1);

                            if (count == null) {
                                count = 0;
                            }

                            centrality_map.put((PortAndWareHouse) local1, count + 1);

                        }
                    }
                }

            }

        }

        return centrality_map;

    }

    /**
     * List with the n porter with greater centrality
     *
     * @param n number of ports pretended
     * @return list of ports
     */
    public Map<PortAndWareHouse, Integer> listOfNPortsCentrality(int n) {

        List<Map.Entry<PortAndWareHouse, Integer>> list_of_entry = new ArrayList<>(getCentralitys().entrySet());

        list_of_entry.sort(new Comparator<Map.Entry<PortAndWareHouse, Integer>>() {
            @Override
            public int compare(Map.Entry<PortAndWareHouse, Integer> o1, Map.Entry<PortAndWareHouse, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        }.thenComparing(new Comparator<Map.Entry<PortAndWareHouse, Integer>>() {
            @Override
            public int compare(Map.Entry<PortAndWareHouse, Integer> o1, Map.Entry<PortAndWareHouse, Integer> o2) {
                return o2.getKey().getPort().compareTo(o1.getKey().getPort());
            }
        }));  //Sorts the List of entries by values

        Map<PortAndWareHouse, Integer> mapOfNPorts = new LinkedHashMap<>(); //Keeps the order from the sorted list

        for (int i = 0; i < n; i++) {
            if (i > list_of_entry.size() - 1) break;
            mapOfNPorts.put(list_of_entry.get(i).getKey(), list_of_entry.get(i).getValue());
        }


        return mapOfNPorts;
    }


    /**
     * Returns the object PortAndCapital by name
     *
     * @param name name
     * @return PortAndCapital
     */
    public PortAndCapital getVerticesByName(String name) {
        for (PortAndCapital portAndCapital : graph.vertices()) {
            if (portAndCapital.getName().compareTo(name) == 0) {
                return portAndCapital;
            }
        }
        return null;
    }

    /**
     * Returns if the PortAndCapital is a port
     *
     * @param port port
     * @return true or false
     */
    public boolean isPort(PortAndCapital port) {
        return port instanceof PortAndWareHouse;
    }

    /**
     * Returns the closest Land Path between to places
     *
     * @param lc1 location 1
     * @param lc2 location 2
     * @return shortest path
     */
    public List<PortAndCapital> closestLandPath(PortAndCapital lc1, PortAndCapital lc2) {
        LinkedList<PortAndCapital> path = new LinkedList<>(); //To save the sequence of the paths
        Graph<PortAndCapital, Double> landOnlyGraph = new MatrixGraph<>(false);

        for (PortAndCapital place : graph.vertices()) {
            landOnlyGraph.addVertex(place);
        }

        for (Edge<PortAndCapital, Double> edge : graph.edges()) {
            if (!((edge.getVOrig() instanceof PortAndWareHouse) && (edge.getVDest() instanceof PortAndWareHouse))) {
                landOnlyGraph.addEdge(edge.getVOrig(), edge.getVDest(), edge.getWeight());
            }
        }
        Algorithms.shortestPath(landOnlyGraph, lc1, lc2, Double::compare, Double::sum, 0.0, path);

        return path;

    }

    /**
     * Finds the closest Land or Sea Path
     *
     * @param lc1 location 1
     * @param lc2 location 2
     * @return path
     */
    public List<PortAndCapital> closestPathLandOrSea(PortAndCapital lc1, PortAndCapital lc2) {
        LinkedList<PortAndCapital> path = new LinkedList<>(); //To save the sequence of the paths
        Algorithms.shortestPath(graph, lc1, lc2, Double::compare, Double::sum, 0.0, path);
        return path;
    }

    /**
     * Gets the Shortest Maritime Path
     *
     * @param lc1 location 1
     * @param lc2 location 2
     * @return closest maritime path
     */
    public List<PortAndWareHouse> closestPathMaritime(PortAndWareHouse lc1, PortAndWareHouse lc2) {
        LinkedList<PortAndWareHouse> path = new LinkedList<>(); //To save the sequence of the paths
        Graph<PortAndWareHouse, Double> portGraph = new MatrixGraph<>(false);

        for (PortAndCapital porto : graph.vertices()) {
            if (isPort(porto)) {
                portGraph.addVertex((PortAndWareHouse) porto);
            }
        }

        for (Edge<PortAndCapital, Double> edge : graph.edges()) {
            if ((edge.getVOrig() instanceof PortAndWareHouse) && (edge.getVDest() instanceof PortAndWareHouse)) {
                portGraph.addEdge((PortAndWareHouse) edge.getVOrig(), (PortAndWareHouse) edge.getVDest(), edge.getWeight());
            }
        }
        Algorithms.shortestPath(portGraph, lc1, lc2, Double::compare, Double::sum, 0.0, path);

        return path;
    }

    /**
     * Gets the shortest path between two locals passing through N places
     *
     * @param list list of places
     * @return shortest path
     */
    public List<PortAndCapital> closestPathPassingThroughNPoint(PortAndCapital lc1, PortAndCapital lc2, List<PortAndCapital> list) {
        LinkedList<PortAndCapital> totalPath = new LinkedList<>();
        Graph<PortAndCapital, Double> minGraph = Algorithms.minDistGraph(graph, Double::compare, Double::sum);
        double minWeight = getWeight(list, lc1, lc2, minGraph);
        List<PortAndCapital> auxList = new LinkedList<>(list);

        List<PortAndCapital> shortestComb = permute(list, minWeight, lc1, lc2, minGraph);

        if (shortestComb.isEmpty()) {
            shortestComb = auxList;
        }

        /////////////////// Getting the shortest path ///////////////////////////
        Algorithms.shortestPath(graph, lc1, shortestComb.get(0), Double::compare, Double::sum, 0.0, totalPath);

        for (int i = 0; i < list.size() - 1; i++) {
            LinkedList<PortAndCapital> aux = new LinkedList<>();
            Algorithms.shortestPath(graph, shortestComb.get(i), shortestComb.get(i + 1), Double::compare, Double::sum, 0.0, aux);
            totalPath.addAll(aux);
        }
        LinkedList<PortAndCapital> aux2 = new LinkedList<>();
        Algorithms.shortestPath(graph, shortestComb.get(shortestComb.size() - 1), lc2, Double::compare, Double::sum, 0.0, aux2);
        totalPath.addAll(aux2);

        return totalPath;
    }

    /**
     * Permutes the list and returns the shortest combination
     *
     * @param str       list
     * @param minWeight minimum weight
     * @param lc1       local 1
     * @param lc2       local 2
     * @param minGraph  warshall graph
     * @return shortest combination
     */
    private List<PortAndCapital> permute(List<PortAndCapital> str, double minWeight, PortAndCapital lc1, PortAndCapital lc2, Graph<PortAndCapital, Double> minGraph) {
        int[] indexes = new int[str.size()];
        List<PortAndCapital> shortestComb = new LinkedList<>();
        for (int i = 0; i < str.size(); i++) {
            indexes[i] = 0;
        }
        int i = 0;
        while (i < str.size()) {
            if (indexes[i] < i) {
                swap(str, i % 2 == 0 ? 0 : indexes[i], i);
                double peso = getWeight(str, lc1, lc2, minGraph);
                if (peso < minWeight) {
                    minWeight = peso;
                    shortestComb = str;
                }
                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }
        return shortestComb;
    }

    /**
     * Calculates the weight of a path
     *
     * @param str      list
     * @param lc1      local 1
     * @param lc2      local 2
     * @param minGraph warshall graph
     * @return
     */
    public double getWeight(List<PortAndCapital> str, PortAndCapital lc1, PortAndCapital lc2, Graph<PortAndCapital, Double> minGraph) {
        double peso = minGraph.edge(lc1, str.get(0)).getWeight();
        for (int i = 0; i < str.size() - 1; i++) {
            peso += minGraph.edge(str.get(i), str.get(i + 1)).getWeight();
        }
        peso += minGraph.edge(str.get(str.size() - 1), lc2).getWeight();
        return peso;
    }

    /**
     * Swaps elements
     *
     * @param list list of places
     * @param a    a
     * @param b    b
     */
    private void swap(List<PortAndCapital> list, int a, int b) {
        PortAndCapital tmp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, tmp);
    }

//    /**
//     * Recurssive method to find the hamiltonian path (goes through all the vertices)
//     *
//     * @param graph   graph with ports and capitals
//     * @param start   start port or capital
//     * @param visited Is visited or not
//     * @param path    final path
//     * @param n       number of vertices
//     */
//    private void hamiltonianPaths(Graph<PortAndCapital, Double> graph, PortAndCapital start, Map<PortAndCapital, Boolean> visited, LinkedList<PortAndCapital> path, int n) {
//
//        if (path.size() == n) {
//            return;
//        }
//
//        for (PortAndCapital p : graph.adjVertices(start)) {
//            if (!visited.get(p)) {
//                visited.put(p, true);
//                path.add(p);
//                //System.out.println("PASSA");
//                hamiltonianPaths(graph, p, visited, path, n);
//
//                visited.put(p, false);
//                path.remove(path.size() - 1);
//            }
//        }
//    }
//
//    /**
//     * Start of the hamiltonian paths finding algorithm
//     *
//     * @param start starting vertex
//     * @return hamiltonian path
//     */
//    public LinkedList<PortAndCapital> getMostEfficientCircuit(PortAndCapital start) {
//
//        System.out.println(start);
//
//        if (start == null) {
//            return null;
//        } else {
//
//            LinkedList<PortAndCapital> path = new LinkedList<>();
//
//            path.add(start);
//
//            Map<PortAndCapital, Boolean> visited = new HashMap<>();
//
//            for (PortAndCapital p : graph.vertices()) {
//                visited.put(p, false);
//            }
//
//            visited.put(start, true);
//
//            hamiltonianPaths(graph, start, visited, path, graph.numVertices());
//
//            return path;
//        }
//    }


    public LinkedList<PortAndCapital> getMostEfficientCircuit(PortAndCapital start){

        if (start == null) {
            return null;
        } else {

            Graph<PortAndCapital, Double> graphCloned = new MatrixGraph<>(false);

            graphCloned = graph.clone();

            HamiltonianCycle hamiltonianCycle = new HamiltonianCycle(graphCloned.getEdgeMatrix());

            return hamiltonianCycle.findHamiltonianCycle(start);
        }
    }

}

