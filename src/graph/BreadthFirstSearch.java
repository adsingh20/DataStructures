package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    /**
     * Given undirected graph and source vertex source print BFS from given source
     * @param adjacencyList Containing List of connected vertices
     * @param source Vertex from where graph has to be traversed
     */
    public void breadthFirstSearch(ArrayList<ArrayList<Integer>> adjacencyList, int source) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjacencyList.size()];

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            final Integer vertex1 = queue.poll();
            System.out.println(vertex1);
            for (int vertex2 : adjacencyList.get(vertex1)) {
                if (!visited[vertex2]) {
                    visited[vertex2] = true;
                    queue.add(vertex2);
                }
            }
        }
    }

    /**
     * Given undirected gragh with no source and graph may be disconnected
     * @param adjacencyList List of connected vertices
     */
    public void breadthFirstSearchForDisconnectedGraph(ArrayList<ArrayList<Integer>> adjacencyList) {

        boolean[] visited = new boolean[adjacencyList.size() + 1];
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (visited[i] == false) {
                breadthFirstSearch(adjacencyList, i, visited);
            }
        }
    }

    private void breadthFirstSearch(ArrayList<ArrayList<Integer>> adjacencyList, int source, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);

        while (!queue.isEmpty()) {
            final Integer vertex1 = queue.poll();
            System.out.println(vertex1);
            for (int vertex2 : adjacencyList.get(vertex1)) {
                if (!visited[vertex2]) {
                    visited[vertex2] = true;
                    queue.add(vertex2);
                }
            }
        }
    }

    /**
     * Count connected components in an undirected graph
     * @param adjacencyList List of connected vertices
     * @return Count of connected components in the list
     */
    public int countConnectedComponentsForDisconnectedGraph(ArrayList<ArrayList<Integer>> adjacencyList) {

        boolean[] visited = new boolean[adjacencyList.size() + 1];
        int count = 0;
        for (int i = 0; i < adjacencyList.size(); i++) {
            if (visited[i] == false) {
                breadthFirstSearch(adjacencyList, i, visited);
                ++count;
            }
        }
        return count;
    }
}
