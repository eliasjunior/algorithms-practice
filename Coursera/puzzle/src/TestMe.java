public class TestMe {
    public static void main(String[] args) {

    }

    public void findInOrderSuccessor(Node inputNode) {
        if(inputNode.right != null) {
            // get child
            Node current = inputNode.right;
            if(current.left != null) {
                while(current.left != null) {
                    current = current.left;
                }
            }
            System.out.println(current.key);
        } else {
            Node parent = inputNode.parent;
            // parent lesser, input node is on its right
            while(parent.key < inputNode.key) {
                parent = parent.parent;
            }
            System.out.println(parent.parent.key);
        }
        // 12, no 14
        //if right
         // if left, go to the bottom
         // left return


        // parent is on my right
        //     find next parent on left side then return
        // if left return

        // edge cases, largest element 25
    }
    private class Node {
        Node left;
        Node right;
        Node parent;
        int key;
    }
}
