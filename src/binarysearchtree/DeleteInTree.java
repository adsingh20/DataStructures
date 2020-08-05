package binarysearchtree;

import tree.TreeNode;

public class DeleteInTree {

    /**
     * Deletes the node from a binary search tree
     * Three Cases
     * 1. Node to be deleted doesn't have any children - we just delete the node
     * 2. Node to be deleted has only one children - Replace the children node with parent
     * 3. Node to be deleted has two children - Find the Inorder successor which is smallest larger value
     * Time Complexity - O(h)
     * Auxiliary Space - O(h)
     * @param root Root Node of the BST
     * @param x Value to be deleted
     * @return TreeNode after deletion of the node
     */
    TreeNode deleteNode(TreeNode root, int x) {
        if (root == null) {
            return null;
        }

        if (root.getData() > x) {
            root.setLeft(deleteNode(root.getLeft(), x));
        } else if (root.getData() < x) {
            root.setRight(deleteNode(root.getRight(), x));
        } else {
            if (root.getLeft() == null) {
                return root.getRight(); // Set the right child as parent left or right node (line 13 or 15)
            } else if (root.getRight() == null){
                return root.getLeft(); // Set the left child as parent left or right node (line 13 or 15)
            } else {
                // Case when node to be deleted has both left and right children, in this case we find inorder sucessful
                // which is the smallest larger value. Found through getSuccessor function

                // Largest Small Value
                TreeNode successor = getSuccessor(root);
                root.setData(successor.getData());
                deleteNode(root.getRight(), successor.getData());

            }
        }

        return root;
    }

    private TreeNode getSuccessor(TreeNode root) {
        TreeNode current = root.getRight();
        while (current != null && current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }
}
