package tree;

public class PrintNodesKDistance {

    void printKDistanceNodes(TreeNode root, int k) {
        if (root == null)
            return;
        if (k == 0) {
            System.out.println(root.getData());
        } else {
            printKDistanceNodes(root.getLeft(), k - 1);
            printKDistanceNodes(root.getRight(), k - 1);
        }
    }
}

