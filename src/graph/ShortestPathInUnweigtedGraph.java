package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUnweigtedGraph {

    /**
     * BFS Traversal O(V+E)
     * @param adjacencyList
     * @param sourceVertex
     */
    public void findShortestPathInUnweigtedGraph(List<ArrayList<Integer>> adjacencyList, int sourceVertex) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjacencyList.size()];
        int[] distance = new int[adjacencyList.size()];

        distance[sourceVertex] = 0;

        queue.add(sourceVertex);
        visited[sourceVertex] = true;

        while (!queue.isEmpty()) {
            final Integer vertex1 = queue.poll();
            System.out.println(vertex1);
            for (int vertex2 : adjacencyList.get(vertex1)) {
                if (!visited[vertex2]) {
                    distance[vertex2] = distance[vertex1] + 1;
                    visited[vertex2] = true;
                    queue.add(vertex2);
                }
            }
        }
    }
}
