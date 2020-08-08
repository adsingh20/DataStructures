package binarysearchtree;

import tree.dto.TreeNode;

public class FixBinaryTreeWithTwoSwappedNodes {

    TreeNode previous = null;
    TreeNode first = null;
    TreeNode second = null;

    public void findNodesToBeSwapped(TreeNode root) {
        if (root == null) {
            return;
        }

        findNodesToBeSwapped(root.getLeft());

        // Root data is less than previous in order traversed node which should always be lesser
        if (previous != null && root.getData() < previous.getData()) {

            /* If first is not set, then set the first to previous because
              root was the node whose value was not greater than the previous so
              previous is the node which has to be swapped
             */
            if (first == null) {
                first = previous;
            }
            second = root;
        }

        previous = root;

        findNodesToBeSwapped(root.getRight());
    }
}
