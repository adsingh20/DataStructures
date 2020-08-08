package binarysearchtree;

import tree.dto.TreeNode;
import util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBinaryTree {

    void printTopViewOfBinaryTree(final TreeNode root) {
        Queue<Pair> horizontalDistanceQueue = new LinkedList<>();
        TreeMap<Integer, Integer> verticalTraversalMap = new TreeMap<>();

        horizontalDistanceQueue.add(new Pair(0, root));

        while (!horizontalDistanceQueue.isEmpty()) {
            final Pair currentNode = horizontalDistanceQueue.poll();
            final int horizontalDistance = currentNode.getHorizontalDistance();
            final int data = currentNode.getNode().getData();
            if (!verticalTraversalMap.containsKey(horizontalDistance)) {
                verticalTraversalMap.put(horizontalDistance, data);
            }

            if (currentNode.getNode().getLeft() != null) {
                horizontalDistanceQueue.add(new Pair(horizontalDistance - 1, currentNode.getNode()));
            }
            if (currentNode.getNode().getRight() != null) {
                horizontalDistanceQueue.add(new Pair(horizontalDistance + 1, currentNode.getNode()));
            }
        }

        //Printing the nodes
        for (Map.Entry<Integer, Integer> set: verticalTraversalMap.entrySet()) {
            System.out.println(set.getValue());
        }

    }
}
