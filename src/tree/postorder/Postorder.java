package tree.postorder;

import tree.TreeNode;

public class Postorder {

    void preOrder(TreeNode root) {
        if (root != null) {
            preOrder(root.getLeft());
            preOrder(root.getRight());
            System.out.println(root.getData());
        }
    }
}

