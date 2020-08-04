package tree;

import java.util.ArrayList;

public class FindLowestCommonAncestor {

    boolean findPath(TreeNode root, ArrayList<TreeNode> listPath, int data) {
        if (root == null) {
            return false;
        }
        listPath.add(root);
        if (root.getData() == data) {
            return true;
        }

        // Following conditions makes sure that recursive call stack returns the control to its parent
        if (findPath(root.getLeft(), listPath, data) || findPath(root.getRight(), listPath, data)) {
            return true;
        }

        listPath.remove(listPath.size() - 1); // Element is not found so remove the last element added

        return false;
    }

    // Two Traversal for Binary Tree needed
    TreeNode findLCA(TreeNode root, int data1, int data2) {
        ArrayList<TreeNode> data1Path = new ArrayList<>();
        ArrayList<TreeNode> data2Path = new ArrayList<>();

        if (!findPath(root, data1Path, data1) || !findPath(root, data2Path, data2)) {
            return null;
        }

        for (int i = 0; i < data1Path.size() - 1 && i < data2Path.size() - 1; i++) {
            if (data1Path.get(i + 1) != data2Path.get(i + 1)) {
                return data1Path.get(i);
            }
        }

        return null;
    }

    /**
     * This solution requires one traversal for Binary Tree needed but works on pre-requisite that
     * both data1 and data2 should be present in the Binary Tree
     * It works based on following four cases for every node
     * 1. If data1 and data2 are same then we return the root as LCA
     * 2. If left subtree contains data1 and right subtree contains data2 then we return the root as LCA
     * 3. If either the left subtree or right subtree contains both data1 and data2 then we return that respective LCA
     * 4. If neither of the subtrees contains any of n1 and n2 then we return null
     * @param root
     * @param data1
     * @param data2
     * @return
     */
    TreeNode findLCAEfficientSolution(TreeNode root, int data1, int data2) {
        if (root == null) {
            return null;
        }

        if (root.getData() == data1 || root.getData() == data2) {
            return root;
        }

        TreeNode lca1 = findLCAEfficientSolution(root.getLeft(), data1, data2);
        TreeNode lca2 = findLCAEfficientSolution(root.getLeft(), data1, data2);

        if (lca1 != null && lca2 != null) {
            return root;
        }

        if (lca1 != null) {
            return lca1;
        }

        return lca2;
    }
}
