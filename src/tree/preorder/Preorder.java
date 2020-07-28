package tree.preorder;

import tree.TreeNode;

public class Preorder {

    void preOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }
}
