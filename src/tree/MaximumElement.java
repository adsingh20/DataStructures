package tree;

public class MaximumElement {

    int getMaximumNode(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        else {
            return Math.max(root.getData(),
                    Math.max(getMaximumNode(root.getLeft()), getMaximumNode(root.getLeft())));
        }
    }
}
