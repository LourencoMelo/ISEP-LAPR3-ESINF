package lapr.project.utils;

import lapr.project.model.PortAndCapital;
import lapr.project.utils.graph.Edge;

import java.util.LinkedList;

public class HamiltonianCycle {


    private static int MAXIMUM_SIZE;
    private final LinkedList<PortAndCapital> path;
    private final Edge<PortAndCapital, Double>[][] graph;


    public HamiltonianCycle(Edge<PortAndCapital, Double>[][] matrix) {
        MAXIMUM_SIZE = matrix.length;
        path = new LinkedList<>();
        this.graph = matrix;

    }

    public LinkedList<PortAndCapital> findHamiltonianCycle(PortAndCapital start) {

        try {
            path.add(start);  //Adds the start vertex

            solve(0);

        } catch (Exception e) {
            return path;
        }

        return null;

    }


    public void solve(int vertex_index) throws Exception {

        //System.out.println(path);

        if (graph[vertex_index][0] != null && path.size() == MAXIMUM_SIZE) {
            throw new Exception("Hamiltonian path founded");
        }

        if (path.size() == MAXIMUM_SIZE) return;

        for (int i = 0; i < MAXIMUM_SIZE; i++) {

            if (graph[vertex_index][i] != null) {

                path.add(graph[vertex_index][i].getVOrig());


                Edge<PortAndCapital, Double> aux1 = graph[vertex_index][i];
                Edge<PortAndCapital, Double> aux2 = graph[i][vertex_index];

                graph[vertex_index][i] = null;
                graph[i][vertex_index] = null;

                if (!isPresent(aux1.getVDest())) {
                    solve(i);
                }

                graph[vertex_index][i] = aux1;
                graph[i][vertex_index] = aux2;

                path.remove(graph[vertex_index][i].getVOrig());

            }

        }

    }


    public boolean isPresent(PortAndCapital vertex) {

        for (int i = 0; i < path.size() - 1; i++) {
            if (path.contains(vertex)) return true;
        }

        return false;

    }

    public int getIndexVertex(PortAndCapital vertex, Edge<PortAndCapital, Double>[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].getVDest().equals(vertex)) {
                    return i;
                }
            }
        }

        return 0;
    }


}
