package tree;

import com.sun.source.tree.Tree;

public class ChildrenSumProperty {

    boolean isChildrenSumPropertyValid(TreeNode root) {
        int sum = 0;

        if (root == null) {
            return true;
        }

        if (root.getLeft() == null && root.getRight() == null) {
            return true;
        }

        if (root.getLeft() != null) {
            sum += root.getLeft().getData();
        }

        if (root.getRight() != null) {
            sum += root.getRight().getData();
        }

        return sum == root.getData() && isChildrenSumPropertyValid(root.getLeft())
                && isChildrenSumPropertyValid(root.getRight());

    }
}
