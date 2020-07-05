package binarytree.arraysequential;

class ArrayTree {
    public static void main(String[] args)
    {
        BinaryTreeThroughArray obj = new BinaryTreeThroughArray();
        obj.addRoot("A");
        obj.addLeftNode("B", 0);
        obj.addRightNode("C", 0);
        obj.addLeftNode("D", 1);
        obj.addRightNode("E", 1);
        obj.addLeftNode("F", 2);
        obj.printInorderTraversalTree();
    }
}

public class BinaryTreeThroughArray {
    static int root = 0;
    static String[] str = new String[10];

    public void addRoot(String key){
        str[0] = key;
    }

    public void addLeftNode(String key, int root){
        int pointer = (root * 2) + 1;
        if (str[root] == null) {
            System.out.println("Can't set child no parent found at root");
        } else {
            str[pointer] = key;
        }
    }

    public void addRightNode(String key, int root){
        int pointer = (root * 2) + 2;
        if (str[root] == null) {
            System.out.println("Can't set child no parent found at root");
        } else {
            str[pointer] = key;
        }
    }

    public void printPreorderTraversalTree() {
        for (int i = 0; i < str.length; i++) {
            if (str[i] != null)
                System.out.print(str[i]);
            else
                System.out.print("-");
        }
    }

    public void printInorderTraversalTree() {
        for (int i = 0; i < str.length; i++) {
            if (str[i] != null)
                System.out.print(str[i]);
            else
                System.out.print("-");
        }
    }

    public void printPostorderTraversalTree() {
        for (int i = 0; i < str.length; i++) {
            if (str[i] != null)
                System.out.print(str[i]);
            else
                System.out.print("-");
        }
    }
}
