package tree;

public class HeightOFBinaryTree {

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else {
            return Math.max(getHeight(root.getLeft()), getHeight(root.getLeft())) + 1;
        }
    }
}
