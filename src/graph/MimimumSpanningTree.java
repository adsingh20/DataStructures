package graph;

import java.util.ArrayList;
import java.util.Arrays;

public class MimimumSpanningTree {

    /**
     * Finds weight of minimum spanning spanning tree using
     * Prims Algorithm
     * @param graph
     * @return
     */
    public int findWeightOfMST(int[][] graph) {
        int noOfVertices = graph.length;
        int[] key = new int[noOfVertices];
        int result = 0;
        Arrays.fill(key, Integer.MAX_VALUE);

        key[0] = 0;
        boolean mSet[] = new boolean[noOfVertices];

        for (int count = 0; count < noOfVertices; count++) {
            int u = -1;
            for (int i = 0; i < noOfVertices; i++) {
                if ((!mSet[i]) && (u == -1 || key[i] < key[u])) {
                    u = i;
                }
                mSet[u] = true;
                result = result + key[u];
            }

            for (int v = 0; v < noOfVertices; v++) {
                if (!mSet[v] && graph[u][v] != 0 && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                }
            }
        }

        return result;
    }


    /**
     * Finds weight of minimum spanning spanning tree using
     * Prims Algorithm
     * @param adjacencyList
     * @return
     */
    public int findWeightOfMST(ArrayList<ArrayList<Integer>> adjacencyList) {
        int result = 0;
        return result;
    }
}
