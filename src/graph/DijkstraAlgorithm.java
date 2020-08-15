package graph;

import java.util.Arrays;

public class DijkstraAlgorithm {

    public int[] dijkstraAlgorithm(int[][] graph, int source) {
        int numberOfVertices = graph.length;
        int[] distance = new int[numberOfVertices];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[source] = 0;

        boolean[] finalizedVertices = new boolean[numberOfVertices];

        for (int count = 0; count < numberOfVertices - 1; count++) {
            int u = -1;
            for (int i = 0; i < numberOfVertices; i++) {
                if (!finalizedVertices[i] && (u == -1 || distance[i] < distance[u])) {
                    u = i;
                }
            }
            finalizedVertices[u] = true;

            for (int v = 0; v < numberOfVertices; v++) {
                if (!finalizedVertices[v] && graph[u][v] != 0) {
                    distance[v] = Math.min(distance[v], distance[u] + graph[u][v]);
                }
            }
        }
        return distance;
    }

}
