package lapr.project.utils;

import lapr.project.model.Capital;
import lapr.project.model.Country;
import lapr.project.model.Distance;
import lapr.project.model.PortAndWareHouse;
import lapr.project.utils.graph.Graph;
import lapr.project.utils.graph.matrix.MatrixGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class GraphGenerator {

    /**
     * Graph of capitals and ports
     */
    private final Graph<Object, Double> graph;

//    /**
//     * List of all imported countries
//     */
//    private final List<Country> countryList;

    /**
     * Constructor that initializes the graph
     */
    public GraphGenerator() {
        this.graph = new MatrixGraph<>(false);
//        countryList = new ArrayList<>();
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

                    Capital capital = new Capital(line[5].trim(), Double.parseDouble(line[6].trim()), Double.parseDouble(line[7].trim()));

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
     * @param object object to insert as a vertex
     * @return true if added. False if failed.
     */
    public boolean insert(Object object) {

        if (object instanceof Capital || object instanceof PortAndWareHouse) {
            if (!graph.validVertex(object)) {
                return graph.addVertex(object);
            }

            return false;
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

//    /**
//     * Getter for the country list
//     *
//     * @return list with all countries
//     */
//    public List<Country> getCountryList() {
//        return countryList;
//    }

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
     * Gets the graph
     *
     * @return graph
     */
    public Graph<Object, Double> getGraph() {
        return graph;
    }
}
