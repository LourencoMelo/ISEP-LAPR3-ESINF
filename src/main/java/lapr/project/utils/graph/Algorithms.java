package lapr.project.utils.graph;

import lapr.project.utils.graph.matrix.MatrixGraph;

import java.util.*;
import java.util.function.BinaryOperator;

/**
 * @author DEI-ISEP
 */
public class Algorithms {

    //Procura em largura

    /**
     * Performs breadth-first search of a Graph starting in a vertex
     *
     * @param g    Graph instance
     * @param vert vertex that will be the source of the search
     * @return a LinkedList with the vertices of breadth-first search
     */
    public static <V, E> LinkedList<V> BreadthFirstSearch(Graph<V, E> g, V vert) {

        if (!g.validVertex(vert)) return null;

        LinkedList<V> listToReturn = new LinkedList<>();
        LinkedList<V> aux = new LinkedList<>();

        listToReturn.add(vert);
        aux.add(vert);

        Map<V, Boolean> isVisited = new HashMap<>();

        for (int i = 0; i < g.numVertices(); i++) {
            if (g.vertex(i).equals(vert)) {
                isVisited.put(g.vertex(i), true);
            } else {
                isVisited.put(g.vertex(i), false);
            }
        }

        V orig;

        while (!aux.isEmpty()) {

            orig = aux.removeFirst();

            for (V adjVertex : g.adjVertices(orig)) {
                if (!isVisited.get(adjVertex)) {
                    listToReturn.add(adjVertex);
                    aux.add(adjVertex);

                    isVisited.put(adjVertex, true);
                }
            }

        }

        return listToReturn;

    }

    //Procura em profundidade recursiva

    /**
     * Performs depth-first search starting in a vertex
     *
     * @param g       Graph instance
     * @param vOrig   vertex of graph g that will be the source of the search
     * @param visited set of previously visited vertices
     * @param qdfs    return LinkedList with vertices of depth-first search
     */
    private static <V, E> void DepthFirstSearch(Graph<V, E> g, V vOrig, boolean[] visited, LinkedList<V> qdfs) {

        if (visited[qdfs.size()]) return;

        qdfs.add(vOrig);

        visited[qdfs.indexOf(vOrig)] = true;

        for (V adj : g.adjVertices(vOrig)) {
            DepthFirstSearch(g, adj, visited, qdfs);
        }

    }

    /**
     * Performs depth-first search starting in a vertex
     *
     * @param g    Graph instance
     * @param vert vertex of graph g that will be the source of the search
     * @return a LinkedList with the vertices of depth-first search
     */
    public static <V, E> LinkedList<V> DepthFirstSearch(Graph<V, E> g, V vert) {

        if (!g.validVertex(vert)) return null;

        LinkedList<V> qdfs = new LinkedList<>();

        boolean[] visited = new boolean[g.numVertices()];

        Arrays.fill(visited, false);

        DepthFirstSearch(g, vert, visited, qdfs);

        return qdfs;
    }


    /**
     * Returns all paths from vOrig to vDest
     *
     * @param g       Graph instance
     * @param vOrig   Vertex that will be the source of the path
     * @param vDest   Vertex that will be the end of the path
     * @param visited set of discovered vertices
     * @param path    stack with vertices of the current path (the path is in reverse order)
     * @param paths   ArrayList with all the paths (in correct order)
     */
    private static <V, E> void allPaths(Graph<V, E> g, V vOrig, V vDest, boolean[] visited,
                                        LinkedList<V> path, ArrayList<LinkedList<V>> paths) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Returns all paths from vOrig to vDest
     *
     * @param g     Graph instance
     * @param vOrig information of the Vertex origin
     * @param vDest information of the Vertex destination
     * @return paths ArrayList with all paths from vOrig to vDest
     */
    public static <V, E> ArrayList<LinkedList<V>> allPaths(Graph<V, E> g, V vOrig, V vDest) {

        throw new UnsupportedOperationException("Not supported yet.");
    }


    /**
     * Computes shortest-path distance from a source vertex to all reachable
     * vertices of a graph g with non-negative edge weights
     * This implementation uses Dijkstra's algorithm
     *
     * @param g        Graph instance
     * @param vOrig    Vertex that will be the source of the path
     * @param visited  set of previously visited vertices
     * @param pathKeys minimum path vertices keys
     * @param dist     minimum distances
     */
    private static <V, E> void shortestPathDijkstra(Graph<V, E> g, V vOrig, Comparator<E> ce, BinaryOperator<E> sum, E zero, boolean[] visited, V[] pathKeys, E[] dist) {

        int verticeKey = g.key(vOrig);              //key do vertice de origem
        dist[verticeKey] = zero;                    //starts distance with 0 received
        pathKeys[verticeKey] = vOrig;               //Starts the path with the origin vertice

        while (vOrig != null) {
            verticeKey = g.key(vOrig);              //Updates the vertice key
            visited[verticeKey] = true;             //Changes the vertice to visited

            for (Edge<V, E> edge : g.outgoingEdges(vOrig)) {          //Percorre todas as edges adjacentes possíveis
                int verticeKeyAdj = g.key(edge.getVDest());         //key do vertice adjacente

                if (!visited[verticeKeyAdj]) {                                                               //Verifica se o vértice adjacente já foi visitado. Senão entra
                    E distance = sum.apply(dist[verticeKey], edge.getWeight());                             //Soma a distancia e guarda na variável distance
                    if (dist[verticeKeyAdj] == null || ce.compare(dist[verticeKeyAdj], distance) > 0) {      //
                        dist[verticeKeyAdj] = distance;
                        pathKeys[verticeKeyAdj] = vOrig;
                    }
                }
            }

            E minDist = null;
            vOrig = null;

            for (V vert : g.vertices()) {
                int i = g.key(vert);
                if (!visited[i] && (dist[i] != null) && ((minDist == null) || ce.compare(dist[i], minDist) < 0)) {
                    minDist = dist[i];
                    vOrig = vert;
                }
            }

        }

    }


    /**
     * Shortest-path between two vertices
     *
     * @param g         graph
     * @param vOrig     origin vertex
     * @param vDest     destination vertex
     * @param ce        comparator between elements of type E
     * @param sum       sum two elements of type E
     * @param zero      neutral element of the sum in elements of type E
     * @param shortPath returns the vertices which make the shortest path
     * @return lenght of the path. Null if the vertice doesn't exist
     */
    public static <V, E> E shortestPath(Graph<V, E> g, V vOrig, V vDest, Comparator<E> ce, BinaryOperator<E> sum, E zero, LinkedList<V> shortPath) {

        if (!g.validVertex(vOrig) || !g.validVertex(vDest))
            return null;         //Verifica se os vértices de origem e destino existem no grafo

        shortPath.clear();      //Cleares the shortest path linked list

        int number_of_vertices = g.numVertices();       //Número de vértices do grafo

        boolean[] visited = new boolean[number_of_vertices];    //Cria array boolean para verificar se um vértice já foi visitado

        @SuppressWarnings("unchecked")
        V[] pathKeys = (V[]) new Object[number_of_vertices];  //minimum path vertices keys

        @SuppressWarnings("unchecked")
        E[] distance = (E[]) new Object[number_of_vertices];  //minimum distance

        shortestPathDijkstra(g, vOrig, ce, sum, zero, visited, pathKeys, distance); //Executa o algoritmo Dijkstra e preenche as arrays com infomação do caminho mais curto

        E path_lenght = distance[g.key(vDest)];     //Calcula a distância total do shortest path através do índex do vértice destino na array de distâncias

        if (path_lenght == null) return null;

        getPath(g, vOrig, vDest, pathKeys, shortPath);  //Executa o algoritmo para retirar o path e guarda na linked list "shortpath"

        System.out.println(shortPath);

        return path_lenght;
    }

    /**
     * Shortest-path between a vertex and all others vertices
     *
     * @param g     graph
     * @param vOrig start vertex
     * @param ce    comparator between elements of type E
     * @param sum   sum two elements of type E
     * @param zero  neutral element of the sum in elements of type E
     * @param paths returns all the minimum paths
     * @param dists returns the corresponding minimum distances
     * @return all shortest paths
     */
    public static <V, E> boolean shortestPaths(Graph<V, E> g, V vOrig, Comparator<E> ce, BinaryOperator<E> sum, E zero, ArrayList<LinkedList<V>> paths, ArrayList<E> dists) {


        if (!g.validVertex(vOrig)) return false;    //Verifica se o vértice existe no grafo

        int number_of_vertices = g.numVertices();   //Guarda o número de vértices do grafo

        boolean[] visited = new boolean[number_of_vertices]; //Inicializa uma array para verificar se os vértices já foram visitados ou não

        @SuppressWarnings("unchecked")
        V[] pathkeys = (V[]) new Object[number_of_vertices];

        @SuppressWarnings("unchecked")
        E[] distances = (E[]) new Object[number_of_vertices];

        shortestPathDijkstra(g, vOrig, ce, sum, zero, visited, pathkeys, distances);

        paths.clear();      //Limpa a array de paths
        dists.clear();      //Limpa a array de distâncias

        for (int i = 0; i < number_of_vertices; i++) {
            paths.add(null);
            dists.add(null);
        }

        for (V vDest : g.vertices()){
            int i = g.key(vDest);

            if (distances[i] != null){
                LinkedList<V> shortestPath = new LinkedList<>();
                getPath(g,vOrig,vDest,pathkeys,shortestPath);
                paths.set(i,shortestPath);
                dists.set(i,distances[i]);
            }
        }

        return true;
    }

    /**
     * Extracts from pathKeys the minimum path between voInf and vdInf
     * The path is constructed from the end to the beginning
     *
     * @param g        Graph instance
     * @param vOrig    information of the Vertex origin
     * @param vDest    information of the Vertex destination
     * @param pathKeys minimum path vertices keys
     * @param path     stack with the minimum path (correct order)
     */
    private static <V, E> void getPath(Graph<V, E> g, V vOrig, V vDest, V[] pathKeys, LinkedList<V> path) {

        if (vOrig.equals(vDest)) {       //No caso de o vértice de origem ser igual ao vértice de destino insere-se o vértice de origem na list e acaba o algoritmo
            path.push(vOrig);
        } else {
            path.push(vDest);                   //Insere o vértice de destino na list porque o algoritmo é feito do fim para o início

            vDest = pathKeys[g.key(vDest)];     //Vai buscar o vértice antecessor do vértice destino atual. Desta maneira vamos percorrer o path do fim para o início
            getPath(g, vOrig, vDest, pathKeys, path); //Chama o método recursivamente atualizando apenas o vértice de destino
        }

    }

    /**
     * Calculates the minimum distance graph using Floyd-Warshall
     *
     * @param g   initial graph
     * @param ce  comparator between elements of type E
     * @param sum sum two elements of type E
     * @return the minimum distance graph
     */
    public static <V, E> MatrixGraph<V, E> minDistGraph(Graph<V, E> g, Comparator<E> ce, BinaryOperator<E> sum) {

        int numVerts = g.numVertices();
        if (numVerts == 0) return null;

        @SuppressWarnings("unchecked")
        E[][] m = (E[][]) new Object[numVerts][numVerts];

        for (int i = 0; i < numVerts; i++) {
            for (int j = 0; j < numVerts; j++) {
                Edge<V, E> e = g.edge(i, j);
                if (e != null) m[i][j] = e.getWeight();
            }
        }

        for (int k = 0; k < numVerts; k++) {
            for (int i = 0; i < numVerts; i++) {
                if (i != k && m[i][k] != null) {
                    for (int j = 0; j < numVerts; j++) {
                        if (j != i && j != k && m[k][j] != null) {
                            E s = sum.apply(m[i][k], m[k][j]);
                            if ((m[i][j] == null) || ce.compare(m[i][j], s) > 0) m[i][j] = s;
                        }
                    }
                }
            }
        }

        return new MatrixGraph<>(g.isDirected(), g.vertices(), m);
    }

}