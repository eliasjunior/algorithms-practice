package Tree;

import java.util.*;

public class BSTLevelOrder {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        //transverse the child add to a list,
        // add to the list left first, skipping null
        // visit children
        List<List<Integer>> level = new ArrayList<>();

        if (root == null) {
            return level;
        }

        Queue<TreeNode> v = new LinkedList<>();

        v.add(root);

        // get children
        while (!v.isEmpty()) {
            //0
            TreeNode n = v.poll();
            List<TreeNode> children = getChildren(n);//1
            List<Integer> order = new ArrayList<>();

            order.add(n.val);

            for (TreeNode c :
                    children) {
                // check null
                if(c.left != null)
                    v.add(c.left);
                if(c.right != null)
                    v.add(c.right);
            }
        }

        return level;
    }

    private List<TreeNode> getChildren(TreeNode n) {
        List<TreeNode> children = new ArrayList<>();
        children.add(n.left);
        children.add(n.right);
        return children;
    }
}
