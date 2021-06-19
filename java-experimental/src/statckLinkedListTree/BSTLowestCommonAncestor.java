package statckLinkedListTree;

public class BSTLowestCommonAncestor {

    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.
        // search v2, and keep the parent
        Node current = root;
        Node parent = null;
        while (current != null && parent == null) {
            if( v1 > current.data &&  v2 > current.data) {
                current = current.right;
            } else if( v1 < current.data && v2 < current.data){
                current = current.left;
            } else {
                parent = current;
            }
        }
        return parent;
    }

    private class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}

