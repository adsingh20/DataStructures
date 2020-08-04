package tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeDeserializeBinaryTree {

    private static final String SPLITTER = ",";
    private static final String NULL_NODE = "X";

    /**
     * Traverse the tree in pre-order and use "X" to denote null node and split node with a ","
     * @param root Root of the subtree
     * @return Serialized string of the binary tree in preorder
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL_NODE).append(SPLITTER);
        } else {
            sb.append(node.getData()).append(SPLITTER);
            buildString(node.getLeft(), sb);
            buildString(node.getRight(), sb);
        }
    }

    /**
     * Use of Queue to store the preorder traversal and construct tree
     * @param data Serialized string present as preorder traversal
     * @return Binary tree
     */
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>(Arrays.asList(data.split(SPLITTER)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NULL_NODE)) {
            return null;
        }
        else {
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.setLeft(buildTree(nodes));
            node.setRight(buildTree(nodes));
            return node;
        }
    }

}
