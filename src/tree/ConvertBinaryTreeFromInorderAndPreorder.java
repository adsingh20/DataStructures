package tree;

public class ConvertBinaryTreeFromInorderAndPreorder {

    int preorderIndex = 0;

    /**
     * O(n2)
     * @param preOrderTraversal
     * @param inOrderTraversal
     * @param startIndex
     * @param endIndex
     * @return
     */
    TreeNode convertTree(int[] preOrderTraversal, int[] inOrderTraversal, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        TreeNode root = new TreeNode(preOrderTraversal[preorderIndex++]);

        int inOrderIndex = -1;

        for (int i = startIndex; i < endIndex; i++) {
            if (inOrderTraversal[i] == root.getData()) {
                inOrderIndex = i;
            }
        }

        root.setLeft(convertTree(preOrderTraversal, inOrderTraversal, startIndex, inOrderIndex - 1));
        root.setRight(convertTree(preOrderTraversal, inOrderTraversal, inOrderIndex + 1, endIndex));

        return root;
    }

}
