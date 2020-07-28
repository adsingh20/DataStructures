package tree.levelorder;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    void printLevel(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
    }

    void printLevelLineByLine(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        while (queue.size() > 1) {
            TreeNode currentNode = queue.poll();

            if (currentNode == null) {
                queue.add(null);
            } else {
                System.out.println(currentNode.getData());
                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }
        }
    }

    void printLevelLineByLine2(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode currentNode = queue.poll();
                System.out.println(currentNode.getData());
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
