package tree;

public class CountNodesInACompleteBinaryTree {

    /**
     * This solutions works on the premise that if the left height and right of a subtree are same then we need not
     * count each individual nodes, we can have height from the formula (2*exp(n)) -1. In the case that the heights are
     * not same then we count the number of individual nodes. Time Complexity - O(logn)
     * @param root Root node of the subtree
     * @return Height of subtree
     */
    long countNodes(TreeNode root) {
        int leftHeight = 0, rightHeight = 0;
        TreeNode current = root;

        while (current != null) {
            ++leftHeight;
            current = current.getLeft();
        }

        current = root;
        while (current != null) {
            ++rightHeight;
            current = current.getRight();
        }

        if (leftHeight == rightHeight) {
            return Math.round(Math.pow(2, leftHeight) - 1);
        }

        return 1 + countNodes(root.getLeft()) + countNodes(root.getRight());
    }

}
