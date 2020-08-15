package graph;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    /**
     * Does DFS for given adjacency list from the source vertex for connected graph
     * @param adjacencyList List of connected vertices
     * @param source Vertex from where graph has to be traversed
     */
    public void depthFirstSearchForConnectedGraph(List<ArrayList<Integer>> adjacencyList, int source) {
        boolean[] visited = new boolean[adjacencyList.size()];
        depthFirstSearchRecursively(adjacencyList, source, visited);
    }

    /**
     * Does DFS for given adjacency list from the source vertex for disconnected graph
     * @param adjacencyList List of connected vertices
     */
    public void depthFirstSearchForDisconnectedGraph(List<ArrayList<Integer>> adjacencyList) {
        boolean[] visited = new boolean[adjacencyList.size()];
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (!visited[i]) {
                depthFirstSearchRecursively(adjacencyList, i, visited);
            }
        }
    }


    /**
     * Gives number of connected components
     * @param adjacencyList
     * @return Count of connected components
     */
    public int countConnectedComponents(List<ArrayList<Integer>> adjacencyList) {
        boolean[] visited = new boolean[adjacencyList.size()];
        int count = 0;
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (!visited[i]) {
                depthFirstSearchRecursively(adjacencyList, i, visited);
                ++count;
            }
        }
        return count;
    }

    private void depthFirstSearchRecursively(List<ArrayList<Integer>> adjacencyList, int source, boolean[] visited) {
        visited[source] = true;
        System.out.println(source);

        for (int vertex : adjacencyList.get(source)) {
            if (!visited[vertex]) {
                depthFirstSearchRecursively(adjacencyList, vertex, visited);
            }
        }
    }
}
