package binarysearchtree;

import tree.TreeNode;

public class CeilInTree {

    /**
     * Time Complexity O(n)
     * Space Complexity O(1)
     * @param root
     * @param x
     * @return
     */
    TreeNode findCeil(TreeNode root, int x) {
        TreeNode result = null;
        while (root != null) {
            if (root.getData() == x) {
                return root;
            } else if (root.getData() < x) {
                root = root.getRight();
            } else {
                result = root;
                root = root.getLeft();
            }
        }
        return result;
    }
}
