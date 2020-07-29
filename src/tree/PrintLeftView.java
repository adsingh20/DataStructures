package tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftView {

    private static int maxLevel = 0;

    void printLeftRecursively(TreeNode root, int level) {
        if (root == null)
            return;
        if (maxLevel < level) {
            System.out.println(root.getData());
            ++maxLevel;
        }
        printLeftRecursively(root.getLeft(), level + 1);
        printLeftRecursively(root.getRight(), level + 1);
    }

    void printLeftIteratively(TreeNode root, int level) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode currentNode = queue.poll();
                // Print Only the first node of the level
                if (i == 0) {
                    System.out.println(currentNode.getData());
                }
                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }
        }
    }
}
