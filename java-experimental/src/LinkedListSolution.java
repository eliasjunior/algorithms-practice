public class LinkedListSolution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        // base case when second pointer finds null or they meet,
        ListNode slow = head;
        if (slow == null || slow.next == null) {
            return false;
        }
        ListNode fast = slow.next.next;

        while (fast != slow && fast != null) {
            slow = slow.next;
            fast = fast.next != null ? fast.next.next : null;
        }
        return slow == fast;
    }
}
