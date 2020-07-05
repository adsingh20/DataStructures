package binarytree.dynamicnodelinked;

import java.util.LinkedList;
import java.util.Queue;

public class InsertionBinaryTree {

    static Node root;
     static Node node = root;

    static void insert(Node node, int key){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while(!queue.isEmpty()){
            node = queue.peek();
            queue.remove();

            if(node.left == null) {
                node.left = new Node(key);
            } else {
                queue.add(node.left);
            }

            if(node.right == null) {
                node.right = new Node(key);
            } else {
                queue.add(node.right);
            }
        }
    }

    public static void main(String args[])
    {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        System.out.print( "Inorder traversal before insertion:");
        BinaryTreeTraversal.inOrder(root);

        int key = 12;
        insert(root, key);

        System.out.print("\nInorder traversal after insertion:");
        BinaryTreeTraversal.inOrder(root);
    }
}
