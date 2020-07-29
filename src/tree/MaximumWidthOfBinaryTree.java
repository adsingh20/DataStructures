package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {

    int findMaximumWidth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int result = 0;

        while (!queue.isEmpty()) {
            int count = queue.size();
            result = Math.max(count, result);
            for (int i = 0; i < count; i++) {
                TreeNode currentNode = queue.poll();
                // Print Only the first node of the level
                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }
        }
        return result;
    }
}
