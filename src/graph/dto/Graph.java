package graph.dto;

import java.util.ArrayList;

public class Graph {

    private ArrayList<ArrayList<Integer>> adjacencyList;
    private int numberOfVertices;

    Graph(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyList = new ArrayList<ArrayList<Integer>>(numberOfVertices);
        for (int i = 0; i < numberOfVertices; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
    }

    void addEdge(int vertex1, int vertex2) {
        if (adjacencyList.get(vertex1) != null) {
            adjacencyList.get(vertex1).add(vertex2);
        } else {
            adjacencyList.add(new ArrayList<>(vertex1));
            adjacencyList.get(vertex1).add(vertex2);
        }

        if (adjacencyList.get(vertex2) != null) {
            adjacencyList.get(vertex2).add(vertex1);
        } else {
            adjacencyList.add(new ArrayList<>(vertex2));
            adjacencyList.get(vertex2).add(vertex1);
        }
    }

    void printGraph() {
        for (int i = 0; i < adjacencyList.size(); i++){
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                System.out.println(adjacencyList.get(i).get(j));
            }
            System.out.println();
        }
    }
}
