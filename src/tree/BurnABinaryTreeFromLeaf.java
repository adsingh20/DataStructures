package tree;

public class BurnABinaryTreeFromLeaf {

    public static int result;

    /**
     * leftDepth - maximum height of left subtree
     * rightDepth - maximum height of right subtree
     * contains - stores true if tree rooted at current node
     * contains the first burnt node
     * time - time to reach fire from the initally burnt leaf
     * node to this node
     */
    class Distance {
        int leftDepth;
        int rightDepth;
        int time;
        boolean contains;

        Distance()
        {
            contains = false;
            leftDepth = rightDepth = 0;
            time = -1;
        }
    }

    /**
     * Function to calculate time required to burn tree completely
     * @param root address of current node
     * @param distance Extra information about current node
     * @param targetNodeValue Node that is fired
     */
    public void calculateDistance(TreeNode root, Distance distance, int targetNodeValue) {
        if (root == null) {
            return;
        }

        // If current node is leaf
        if (root.getLeft() == null && root.getRight() == null) {

            // If current node is the first burnt node
            if (root.getData() == targetNodeValue) {
                distance.contains = true;
                distance.time = 0;
            }
            return;
        }

        // Information about left child
        Distance leftData = new Distance();
        calculateDistance(root.getLeft(), leftData, targetNodeValue);

        // Information about right child
        Distance rightData = new Distance();
        calculateDistance(root.getRight(), rightData, targetNodeValue);

        // If left subtree contains the fired node then
        // time required to reach fire to current node
        // will be (1 + time required for left child)
        distance.time = (leftData.contains) ? (leftData.time + 1) : -1;

        // If right subtree contains the fired node then
        // time required to reach fire to current node
        // will be (1 + time required for right child)
        if (distance.time == -1)
            distance.time = (rightData.contains) ? (rightData.time + 1) : -1;

        // Storing(true or false) if the tree rooted at
        // current node contains the fired node
        distance.contains = (leftData.contains || rightData.contains);

        // Calculate the maximum depth of left subtree
        distance.leftDepth = (root.getLeft() == null) ? 0 : (1 + Math.max(leftData.leftDepth, leftData.rightDepth));

        // Calculate the maximum depth of right subtree
        distance.rightDepth = (root.getRight() == null) ? 0 : (1 + Math.max(rightData.leftDepth, rightData.rightDepth));

        // Calculating answer
        if (distance.contains) {

            // If left subtree exists and
            // it contains the fired node
            if (leftData.contains) {

                // calculate result
                result = Math.max(result, distance.time + distance.rightDepth);
            }

            // If right subtree exists and it
            // contains the fired node
            if (rightData.contains) {

                // calculate result
                result = Math.max(result, distance.time + distance.leftDepth);
            }
        }
    }


}
