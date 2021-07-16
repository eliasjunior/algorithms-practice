package Tree;

public class MaxDepthBST {
    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int sumL = 1, sumR = 1;
        if (node.left != null) {
            sumL += helper(node.left);
        }
        if (node.right != null) {
            sumR += helper(node.right);
        }
        return Math.max(sumR, sumL);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
