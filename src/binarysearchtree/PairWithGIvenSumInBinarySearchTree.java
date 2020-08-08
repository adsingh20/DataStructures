package binarysearchtree;

import tree.dto.TreeNode;

import java.util.HashSet;

public class PairWithGIvenSumInBinarySearchTree {

    /**
     * Time Complexity O(n)
     * Auxiliary Space O(n)
     * @param root
     * @param sum
     * @param set
     * @return
     */
    boolean isPairSum(TreeNode root, int sum, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }

        if (isPairSum(root.getLeft(), sum, set)) {
            return true;
        }

        if (set.contains(sum - root.getData())) {
            return true;
        } else {
            set.add(root.getData());
        }

        return isPairSum(root.getRight(), sum, set);
    }
}
