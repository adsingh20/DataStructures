package tree;

public class CheckForBalancedTree {

    private boolean isBalancedNaiveSolution(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftSubTreeHeight = HeightOFBinaryTree.getHeight(root.getLeft());
        int rightSubTreeHeight = HeightOFBinaryTree.getHeight(root.getRight());

        return (Math.abs(leftSubTreeHeight - rightSubTreeHeight) <= 1
                && isBalancedNaiveSolution(root.getLeft())
                && isBalancedNaiveSolution(root.getRight()));
    }

    /**
     * Returns value greater than 0 in case the tree is balanced & -1 in case it is not balanced
     * @param root
     * @return
     */
    private int isBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSubTreeHeight = isBalanced(root.getLeft());
        if (leftSubTreeHeight == -1) {
            return -1;
        }
        int rightSubTreeHeight = isBalanced(root.getRight());
        if (rightSubTreeHeight == -1) {
            return -1;
        }

        if (Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
            return -1;
        } else {
             return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
        }
    }
}
