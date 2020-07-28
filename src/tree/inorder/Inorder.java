package tree.inorder;

import tree.TreeNode;

public class Inorder {

    void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.println(root.getData());
            inOrder(root.getRight());
        }
    }
}
