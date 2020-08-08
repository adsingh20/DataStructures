package binarysearchtree;

import tree.dto.TreeNode;

import java.util.TreeMap;

public class VerticalSumInABinaryTree {

    /**
     * Time Complexity O(n * log horizontalDistance + horizontalDistance) =>
     * O(n * log horizontalDistance)
     * @param root
     * @param horizontalDistance
     * @param mapOfVerticalSum
     */
    void getVerticalSum(TreeNode root,
                        int horizontalDistance,
                        TreeMap<Integer, Integer> mapOfVerticalSum) {
        if (root == null) {
            return;
        }

        getVerticalSum(root.getLeft(), horizontalDistance - 1, mapOfVerticalSum);

        mapOfVerticalSum.put(horizontalDistance,
                mapOfVerticalSum.getOrDefault(horizontalDistance, -1) + 1);

        getVerticalSum(root.getRight(), horizontalDistance + 1, mapOfVerticalSum);
    }

    void getVerticalSum(TreeNode root) {
        TreeMap<Integer, Integer> mapOfVerticalSum = new TreeMap<>();
        getVerticalSum(root, 0, mapOfVerticalSum);
        System.out.println(mapOfVerticalSum);
    }
}
