package binarysearchtree;

import tree.TreeNode;

public class SearchInTree {

    /**
     * Time Complexity O(h)
     * Auxiliary Space 0(h)
     * @param root
     * @param x
     * @return
     */
    public static boolean searchRecursive(TreeNode root, int x) {
        if (root == null) {
            return false;
        } else if (root.getData() == x) {
            return true;
        } else if (root.getData() > x) {
            searchRecursive(root.getLeft(), x);
        } else {
            searchRecursive(root.getRight(), x);
        }
        return false;
    }
}
