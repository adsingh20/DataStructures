package tree;

public class SizeOfBinaryTree {

    int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            return 1 + getSize(root.getLeft()) + getSize(root.getLeft());
        }
    }
}
