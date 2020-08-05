package binarysearchtree;

import tree.TreeNode;

public class InsertInTree {

    /**
     * Time Complexity O(h)
     * Space Complexity O(h)
     * @param root
     * @param x
     * @return
     */
    public TreeNode insertRecursively(TreeNode root, int x) {
        if (root == null) {
            return new TreeNode(x);
        }
        if (root.getData() > x) {
            root.setLeft(insertRecursively(root.getLeft(), x));
        } else if (root.getData() < x) {
            root.setRight(insertRecursively(root.getRight(), x));
        }
        return root;
    }

    /**
     * Time Complexity O(h)
     * Space Complexity O(1)
     * @param root
     * @param x
     * @return
     */
    public TreeNode insertIteratively(TreeNode root, int x) {
        TreeNode temp = new TreeNode(x);
        TreeNode parent = null, current = root;

        while (current != null) {
            parent = current;
            if (current.getData() > x) {
                current = current.getLeft();
            } else if (current.getData() < x) {
                current = current.getRight();
            } else {
                return root;
            }
        }

        if (parent == null) {
            return temp;
        }

        if (parent.getData() > x) {
            parent.setLeft(temp);
        } else {
            parent.setRight(temp);
        }

        return root;
    }
}
