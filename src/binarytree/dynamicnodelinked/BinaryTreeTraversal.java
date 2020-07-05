package binarytree.dynamicnodelinked;

public class BinaryTreeTraversal {

    static void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.key);
        inOrder(node.right);
    }

    static void preOrder(Node node) {
        if (node == null)
            return;
        System.out.println(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key);
    }

}
