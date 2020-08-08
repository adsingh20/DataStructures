package binarysearchtree;

import tree.dto.TreeNode;

public class CheckIfBinarySearchTree {

    /**
     * Checks if the Tree is a BST or not using preorder traversal
     * Pass a range which has to be checked for every node.
     * A root the range is negative min as lower bound and positive max as upper bound
     * For left child's recursive call, we update upper bound of the range as root's value
     * For right child's recursive call, we update upper bound of the range as root's value
     * @param root Current Node which is being checked for BST property
     * @param min Lower Bound of the range
     * @param max Upper Bound of the range
     * @return If the current's node are BST are not
     */
    public boolean isBinarySearchTree(TreeNode root, int min, int max) {

        // There is nothing to be processed in this recursive so return true
        if (root == null) {
            return true;
        }

        return (root.getData() > min
                && root.getData() < max
                && isBinarySearchTree(root.getLeft(), min, root.getData())
                && isBinarySearchTree(root.getRight(), root.getData(), root.getData()));
    }

    int previous = Integer.MIN_VALUE;
    /**
     * Binary Search Tree is valid only if its inorder traversal is in sorted order
     * Time Complexity O(h)
     * Auxilary Space O(h)
     * @param root Current Node which is being checked for BST property
     * @return If the current's node are BST are not
     */
    public boolean isBinarySearchTree(TreeNode root) {

        // There is nothing to be processed in this recursive so return true
        if (root == null) {
            return true;
        }

        if (!isBinarySearchTree(root.getLeft())) {
            return false;
        }

        if (root.getData() <= previous) {
            return false;
        }

        previous = root.getData();

        return isBinarySearchTree(root.getRight());
    }
}
