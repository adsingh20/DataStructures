package tree;

public class BinaryTreeToDoublyLinkedList {

    TreeNode previous = null;

    TreeNode convertBinaryTreeToLinkedList(TreeNode root) {
       if (root == null) {
           return root;
       }
       TreeNode head = convertBinaryTreeToLinkedList(root.getLeft());
       if (previous == null) {
           head = root;
       } else {
           root.setLeft(previous);
           previous.setRight(root);
       }
       previous = root;
       convertBinaryTreeToLinkedList(root.getRight());
       return head;
    }
}
