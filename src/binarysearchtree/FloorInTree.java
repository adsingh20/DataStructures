package binarysearchtree;

import tree.TreeNode;

public class FloorInTree {

    /**
     * Time Complexity O(n)
     * Space Complexity O(1)
     * @param root
     * @param x
     * @return
     */
    TreeNode findFloor(TreeNode root, int x) {
        TreeNode result = null;
        while (root != null) {
            if (root.getData() == x) {
                return root;
            } else if (root.getData() > x) {
                root = root.getLeft();
            } else {
                result = root;
                root = root.getRight();
            }
        }
        return result;
    }
}
