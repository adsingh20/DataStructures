package tree.dto;

public class AugmentedTreeNode extends TreeNode {

    // Variable storing number of elements in left subtree
    int leftSubtreeCount;

    public AugmentedTreeNode(int data, int leftSubtreeCount) {
        super(data);
        this.leftSubtreeCount = leftSubtreeCount;
    }

    public AugmentedTreeNode(int data,
                             TreeNode left,
                             TreeNode right,
                             int leftSubtreeCount) {
        super(data, left, right);
        this.leftSubtreeCount = leftSubtreeCount;
    }

    public int getData() {
        return super.getData();
    }

    public void setData(int data) {
        super.setData(data);
    }

    public AugmentedTreeNode getLeft() {
        return (AugmentedTreeNode) super.getLeft();
    }

    public void setLeft(TreeNode left) {
        super.setLeft(left);
    }

    public AugmentedTreeNode getRight() {
        return (AugmentedTreeNode) super.getRight();
    }

    public void setRight(TreeNode right) {
        super.setRight(right);
    }

    public int getLeftSubtreeCount() {
        return leftSubtreeCount;
    }

    public void setLeftSubtreeCount(int leftSubtreeCount) {
        this.leftSubtreeCount = leftSubtreeCount;
    }

    public void incrementLSTCount() {
     ++this.leftSubtreeCount;
    }

    public static AugmentedTreeNode insert(AugmentedTreeNode root, int x)
    {
        if (root == null)
            return new AugmentedTreeNode(x, 0);

        // If a node is inserted in left subtree, then
        // lCount of this node is increased. For simplicity,
        // we are assuming that all keys (tried to be
        // inserted) are distinct.
        if (x < root.getData()) {
            root.setLeft(insert(root.getLeft(), x));
            root.incrementLSTCount();
        }

        else if (x > root.getData())
            root.setRight(insert(root.getRight(), x));
        return root;
    }
}
