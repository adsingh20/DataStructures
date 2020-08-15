package graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCyclesInUndirectedGraph {

    private boolean depthFirstSearchRecursively(List<ArrayList<Integer>> adjacencyList, int source, boolean[] visited, int parent) {
        visited[source] = true;

        for (int vertex : adjacencyList.get(source)) {
            if (!visited[vertex]) {
                if (depthFirstSearchRecursively(adjacencyList, vertex, visited, source)){
                    return true;
                }
            } else if (vertex != parent) {
                return true;
            }
        }
        return false;
    }

    /**
     * Does DFS for given adjacency list from the source vertex for disconnected graph
     * @param adjacencyList List of connected vertices
     */
    public boolean detectCyclesInUndirectedGraph(List<ArrayList<Integer>> adjacencyList) {
        boolean[] visited = new boolean[adjacencyList.size()];
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (!visited[i]) {
                if (depthFirstSearchRecursively(adjacencyList, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
