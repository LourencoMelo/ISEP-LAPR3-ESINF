package lapr.project.utils;

import lapr.project.model.Capital;
import lapr.project.model.Country;
import lapr.project.model.PortAndWareHouse;
import lapr.project.model.PositionData;
import lapr.project.utils.graph.Edge;
import lapr.project.utils.graph.matrix.MatrixGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GraphGeneratorTest {

    private GraphGenerator graphGenerator;
    private final List<Country> expectedCountryList = new ArrayList<>();
    private final ArrayList<Capital> expectedVertices = new ArrayList<>();
    private final Collection<Edge<Object, Double>> collection = new ArrayList<>();

    private static final String PATH_COUNTRIES_TEST = "Files/countryTestFile.csv";
    private static final String PATH_BORDERS_TEST = "Files/bordersTestFile.csv";

    @BeforeEach
    void setUp() {

        graphGenerator = new GraphGenerator();

        Capital capital1 = new Capital("Nicosia", 35.16666667, 33.366667);
        Capital capital2 = new Capital("Valletta", 35.88333333, 14.5);
        Capital capital3 = new Capital("Athens", 37.98333333, 23.733333);
        Capital capital4 = new Capital("Lisbon", 38.71666667, -9.133333);
        Capital capital5 = new Capital("Ankara", 39.93333333, 32.866667);
        Capital capital6 = new Capital("Yerevan", 40.16666667, 44.5);
        Capital capital7 = new Capital("Madrid", 40.4, -3.683333);
        Capital capital8 = new Capital("Tirana", 41.31666667, 19.816667);


        Country country1 = new Country("Europe", "CY", "CYP", "Cyprus", 0.85, capital1);
        Country country2 = new Country("Europe", "MT", "MLT", "Malta", 0.44, capital2);
        Country country3 = new Country("Europe", "GR", "GRC", "Greece", 10.76, capital3);
        Country country4 = new Country("Europe", "PT", "PRT", "Portugal", 10.31, capital4);
        Country country5 = new Country("Europe", "TR", "TUR", "Turkey", 79.81, capital5);
        Country country6 = new Country("Europe", "AM", "ARM", "Armenia", 3.01, capital6);
        Country country7 = new Country("Europe", "ES", "ESP", "Spain", 46.53, capital7);
        Country country8 = new Country("Europe", "AL", "ALB", "Albania", 2.88, capital8);

        expectedCountryList.add(country1);
        expectedCountryList.add(country2);
        expectedCountryList.add(country3);
        expectedCountryList.add(country4);
        expectedCountryList.add(country5);
        expectedCountryList.add(country6);
        expectedCountryList.add(country7);
        expectedCountryList.add(country8);


        expectedVertices.add(capital1);
        expectedVertices.add(capital2);
        expectedVertices.add(capital3);
        expectedVertices.add(capital4);
        expectedVertices.add(capital5);
        expectedVertices.add(capital6);
        expectedVertices.add(capital7);
        expectedVertices.add(capital8);

        Edge<Object, Double> edge1 = new Edge<>(capital3, capital5, 818.4775977283588);
        Edge<Object, Double> edge2 = new Edge<>(capital5, capital3, 818.4775977283588);

        Edge<Object, Double> edge3 = new Edge<>(capital3, capital8, 818.4775977283588);
        Edge<Object, Double> edge4 = new Edge<>(capital8, capital3, 818.4775977283588);

        Edge<Object, Double> edge5 = new Edge<>(capital4, capital7, 818.4775977283588);
        Edge<Object, Double> edge6 = new Edge<>(capital7, capital4, 818.4775977283588);

        Edge<Object, Double> edge7 = new Edge<>(capital6, capital5, 818.4775977283588);
        Edge<Object, Double> edge8 = new Edge<>(capital5, capital6, 818.4775977283588);

        collection.add(edge1);
        collection.add(edge2);
        collection.add(edge3);
        collection.add(edge4);
        collection.add(edge5);
        collection.add(edge6);
        collection.add(edge7);
        collection.add(edge8);

    }

    @Test
    void constructor() {
        assertEquals(new MatrixGraph<>(false), graphGenerator.getGraph()); //Ensures that the graph is initialized on the constructor
    }

    @Test
    void importCountriesTest() {

        List<Country> countryList = new ArrayList<>(); //Creates new List to be filled with countries from the file

        graphGenerator.importCountries(new File(PATH_COUNTRIES_TEST), countryList); //Imports the countries from the file

        assertEquals(expectedCountryList.size(), countryList.size()); //Checks if the size of both lists is the same

        assertEquals(expectedCountryList.toString(), countryList.toString()); //Checks if the content of both lists is the same
    }

    @Test
    void capitalVertexInsertionTest() {

        List<Country> countryList = new ArrayList<>(); //Creates new List to be filled with countries from the file

        graphGenerator.importCountries(new File(PATH_COUNTRIES_TEST), countryList); //Imports the countries from the file

        graphGenerator.generateCapitalVertex(countryList); //Generates vertex for all capital from all countries

        assertEquals(graphGenerator.getGraph().vertices().size(), expectedVertices.size()); //Checks if the size of both lists is the same

        assertEquals(graphGenerator.getGraph().vertices().toString(), expectedVertices.toString()); //Checks if the content of both lists is the same

    }

    @Test
    void insertTest() {

        Capital capital1 = new Capital("Nicosia", 35.16666667, 33.366667);
        Capital same_capital = new Capital("Nicosia", 35.16666667, 33.366667);

        PortAndWareHouse portAndWareHouse1 = new PortAndWareHouse("Europe", "United Kingdom", 29002, "Liverpool", 53.46666667, -3.033333333);

        PositionData positionDataTest = new PositionData(LocalDateTime.of(2021, 11, 8, 13, 39), 10, 10, 3, 4, 5, "1", "Sopa");

        assertTrue(graphGenerator.insert(capital1)); //Inserts new capital vertex

        assertTrue(graphGenerator.insert(portAndWareHouse1)); //Inserts new port vertex

        assertFalse(graphGenerator.insert(positionDataTest)); //Try to insert new postion data object

        assertFalse(graphGenerator.insert(same_capital)); //Try to insert same capital

    }


    @Test
    void addEdgesFromBordersTest() {

        List<Country> countryList = new ArrayList<>(); //Creates new List to be filled with countries from the file

        graphGenerator.importCountries(new File(PATH_COUNTRIES_TEST), countryList); //Imports the countries from the file

        graphGenerator.generateCapitalVertex(countryList); //Generates vertex for all capital from all countries

        graphGenerator.addEdgesFromBorders(new File(PATH_BORDERS_TEST), countryList); //Add new edges from the file

        assertEquals(8, graphGenerator.getGraph().numEdges()); //Checks if number of edges is 8. Because the graph is undirected each edge is added twice(one for each side).

        assertTrue(collection.containsAll(graphGenerator.getGraph().edges()) && graphGenerator.getGraph().edges().containsAll(collection));

    }

    @Test
    void getCapitalByCountryNameTest() {

        List<Country> countryList = new ArrayList<>(); //Creates new List to be filled with countries from the file

        graphGenerator.importCountries(new File(PATH_COUNTRIES_TEST), countryList); //Imports the countries from the file

        Capital capital4 = new Capital("Lisbon", 38.71666667, -9.133333);
        Capital capital5 = new Capital("Ankara", 39.93333333, 32.866667);

        assertEquals(capital4, graphGenerator.getCapitalByCountryName("Portugal", countryList));
        assertEquals(capital5, graphGenerator.getCapitalByCountryName("Turkey", countryList));

        assertNull(graphGenerator.getCapitalByCountryName("Etiópia", countryList));

    }

    @Test
    void wrongFilePath() {
        List<Country> countryList = new ArrayList<>(); //Creates new List to be filled with countries from the file

        graphGenerator.importCountries(new File("Files/countryWrongPath.csv"), countryList); //Imports the countries from the file

        assertEquals(0, countryList.size());

        graphGenerator.addEdgesFromBorders(new File("Files/bordersWrongPath.csv"), countryList); //Add new edges from the file

        assertEquals(0, graphGenerator.getGraph().numEdges());

    }

    @Test
    void colourCountries(){
        List<Country> countryList = new ArrayList<>(); //Creates new List to be filled with countries from the file

        graphGenerator.importCountries(new File(PATH_COUNTRIES_TEST), countryList); //Imports the countries from the file

        graphGenerator.generateCapitalVertex(countryList); //Generates vertex for all capital from all countries

        graphGenerator.colourMap(countryList);


    }
}