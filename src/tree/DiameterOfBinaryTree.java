package tree;

public class DiameterOfBinaryTree {

    int diameter = 0;

    // Function returns height but sets the diameter based on the height
    int height(TreeNode root) {
        if (root == null) {
           return 0;
        }

        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());

        diameter = Math.max(diameter, 1 + leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight); // Calculates the height
    }
}
