package util;

import tree.dto.TreeNode;

public class Pair {
    private int horizontalDistance;
    private TreeNode node;

    public Pair(int horizontalDistance, TreeNode root) {
        this.horizontalDistance = horizontalDistance;
        this.node = root;
    }

    public int getHorizontalDistance() {
        return horizontalDistance;
    }

    public void setHorizontalDistance(int horizontalDistance) {
        this.horizontalDistance = horizontalDistance;
    }

    public TreeNode getNode() {
        return node;
    }

    public void setNode(TreeNode node) {
        this.node = node;
    }
}
