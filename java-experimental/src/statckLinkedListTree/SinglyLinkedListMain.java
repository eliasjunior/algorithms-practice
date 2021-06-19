package statckLinkedListTree;

public class SinglyLinkedListMain {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public  static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here
        if(llist == null) {
            return new SinglyLinkedListNode(data);
        }
        // insert diff pos, 0, middle
        SinglyLinkedListNode current = llist;

        if(position == 0) {
            SinglyLinkedListNode first = new SinglyLinkedListNode(data);
            first.next = current;
            return first;
        } else {
            SinglyLinkedListNode previous = null;
            while(position != 0 && current != null) {
                position--;
                previous = current;
                current = current.next;
            }

            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            node.next = current;
            previous.next = node;
            // TRICK HERE return the head reference!!
            return llist;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedListNode node = insertNodeAtPosition(null, 1, 0);
        node = insertNodeAtPosition(node, 5, 1);
        node = insertNodeAtPosition(node, 7, 0);
        node = insertNodeAtPosition(node, 9, 1);
        node = insertNodeAtPosition(node, 10, 3);

        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

    }
}
