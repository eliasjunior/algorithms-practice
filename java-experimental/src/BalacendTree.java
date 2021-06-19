public class BalacendTree {
    public boolean isValidBST(Node root) {
        // check edge cases, left is null what to return, same for the right
        boolean left = isLeftBalanced(root.left, root);
        boolean right = isRightBalanced(root.right, root);

        return left && right;
    }

    boolean isLeftBalanced(Node current, Node parent) {
        while(current != null) {
            if(current.data > parent.data) {
                return false;
            }

            if(current.right != null) {
                boolean resfromRight = isRightBalanced(current.right, current);
                //check grampa
                if( current.right.left != null && current.right.left.data > parent.data) {
                    return false;
                }
            }
            parent = current;
            current = current.left;
        }
        return true;
    }
    boolean isRightBalanced(Node current, Node parent) {
        while(current != null) {
            if(current.data < parent.data) {
                return false;
            }

            if(current.left != null  ) {
                if(current.left.right != null && current.left.right.data > parent.data) {
                    return false;
                }
            }
            parent = current;
            current = current.right;
        }
        return true;
    }
    class Node {
        int data;
        Node left;
        Node right;
    }
}
