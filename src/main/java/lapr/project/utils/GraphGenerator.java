package lapr.project.utils;

import lapr.project.model.*;
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

    /**
     * Constructor that initializes the graph
     */
    public GraphGenerator() {
        this.graph = new MatrixGraph<>(false);
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

    public ArrayList<Capital> getVertexCapital() {
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
    public ArrayList<Capital> getAdjVertexCapital(Capital cap) {
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

}
