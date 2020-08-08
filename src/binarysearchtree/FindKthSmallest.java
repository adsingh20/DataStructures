package binarysearchtree;

import tree.dto.AugmentedTreeNode;

public class FindKthSmallest {

    /**
     * Compare leftSubTreeCount with k
     * a) If same return the root
     * b) If greater then recur for left subtree with same k since kth smallest element will
     * be present in left subtree as it has elements smaller than the root
     * c) If smaller then recur for right subtree with k as (k - leftSubTreeCount - 1)
     * @param root Node to be searched
     * @param k Value of k to be search
     * @return kth smallest node if found otherwise return null
     */
    public static AugmentedTreeNode kthSmallest(AugmentedTreeNode root, int k)
    {
        // base case
        if (root == null)
            return null;

        int count = root.getLeftSubtreeCount() + 1;
        if (count == k)
            return root;

        if (count > k)
            return kthSmallest(root.getLeft(), k);

        // else search in right subtree
        return kthSmallest(root.getRight(), k - count);
    }
}
