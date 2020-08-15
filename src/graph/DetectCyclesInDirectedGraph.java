package graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCyclesInDirectedGraph {

    private boolean depthFirstSearchRecursively(List<ArrayList<Integer>> adjacencyList, int source, boolean[] visited, boolean[] recursionStack) {
        visited[source] = true;
        recursionStack[source] = true;

        for (int vertex : adjacencyList.get(source)) {
            if (!(visited[vertex]) && depthFirstSearchRecursively(adjacencyList, vertex, visited, recursionStack)) {
                return true;
            } else if (recursionStack[vertex]) {
                return true;
            }
        }
        recursionStack[source] = false;
        return false;
    }


    /**
     * Using BFS to detect cycles in directed graph
     * @param adjacencyList List of connected vertices
     * @return If a cycle is present in the graph
     */
    public boolean detectCyclesInDirectedGraph(List<ArrayList<Integer>> adjacencyList) {
        boolean[] visited = new boolean[adjacencyList.size()];
        boolean[] recursionStack = new boolean[adjacencyList.size()];
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (!visited[i]) {
                if (depthFirstSearchRecursively(adjacencyList, i, visited, recursionStack)) {
                    return true;
                }
            }
        }
        return false;
    }
}
