package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversalInSpiralForm {

    void printTreeTraversalInSpiralForm(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        boolean reverse = false;

        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode currentNode = queue.poll();
                if (reverse) {
                    stack.push(currentNode.getData());
                } else {
                    System.out.println(currentNode.getData());
                }
                if (currentNode.getLeft() != null) {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null) {
                    queue.add(currentNode.getRight());
                }
            }
            if (reverse) {
                while (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                }
            }
            reverse = !reverse;
        }
    }

    void printTreeTraversalInSpiralFormBetterSolution(TreeNode root) {
        if (root == null)
            return; // NULL check

        // Create two stacks to store alternate levels
        // For levels to be printed from right to left
        Stack<TreeNode> s1 = new Stack();
        // For levels to be printed from left to right
        Stack<TreeNode> s2 = new Stack();

        // Push first level to first stack 's1'
        s1.push(root);

        // Keep printing while any of the stacks has some nodes
        while (!s1.empty() || !s2.empty()) {
            // Print nodes of current level from s1 and push nodes of
            // next level to s2
            while (!s1.empty()) {
                TreeNode temp = s1.peek();
                s1.pop();
                System.out.print(temp.getData() + " ");

                // Note that is right is pushed before left
                if (temp.getRight() != null)
                    s2.push(temp.getRight());

                if (temp.getLeft() != null)
                    s2.push(temp.getLeft());
            }

            // Print nodes of current level from s2 and push nodes of
            // next level to s1
            while (!s2.empty()) {
                TreeNode temp = s2.peek();
                s2.pop();
                System.out.print(temp.getData() + " ");

                // Note that is left is pushed before right
                if (temp.getLeft() != null)
                    s1.push(temp.getLeft());
                if (temp.getRight() != null)
                    s1.push(temp.getRight());
            }
        }
    }
}
