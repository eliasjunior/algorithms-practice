//import org.junit.jupiter.api.Test;
//
//import java.util.NoSuchElementException;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class DequeTest {
//
//    @Test
//    public void test_invalidInputs() {
//        Deque<Integer> deque = new Deque();
//        assertThrows(IllegalArgumentException.class, () -> deque.addFirst(null));
//        assertThrows(IllegalArgumentException.class, () -> deque.addLast(null));
//    }
//
//    @Test
//    public void test_invalidState() {
//        Deque<Integer> deque = new Deque();
//        assertThrows(NoSuchElementException.class, () -> deque.removeFirst());
//        assertThrows(NoSuchElementException.class, () -> deque.removeLast());
//    }
//
//    @Test
//    public void test_IteratorState() {
//        Deque<Integer> deque = new Deque();
//        assertThrows(NoSuchElementException.class, () -> deque.iterator().next());
//        assertThrows(UnsupportedOperationException.class, () -> deque.iterator().remove());
//    }
//
//    @Test
//    public void test_addFirst() {
//        Deque<Integer> deque = new Deque();
//
//        deque.addFirst(5);
//        deque.addFirst(2);
//        deque.addFirst(3);
//
//        assertFalse(deque.isEmpty());
//        assertEquals(deque.front.value , 3);
//    }
//
//    @Test
//    public void test_addLast() {
//        Deque<Integer> deque = new Deque();
//
//        addNodesFront(new int[]{0, 3, 5}, deque);
//
//        assertEquals(deque.front.value, 5);
//
//        deque.addLast(9);
//
//        assertEquals(deque.tail.value, 9);
//
//        addNodesTail(new int[]{24, 100}, deque);
//
//        assertEquals(deque.tail.value, 100);
//
////        for (Object obj: deque) {
////            Node n = (Node) obj;
////            System.out.println(n.value);
////        }
//    }
//
//    @Test
//    public void test_RemoveLast() {
//        Deque<Integer> deque = new Deque();
//
//        addNodesFront(new int[]{0, 3, 5}, deque);
//
//        assertEquals(deque.front.value, 5);
//        assertEquals(deque.tail.value, 0);
//
//        assertEquals( 0,  deque.removeLast());
//        assertEquals(deque.size(), 2);
//
//        assertEquals( 3,  deque.removeLast());
//
//        assertEquals( 5,  deque.removeLast());
//
//        addNodesFront(new int[]{8, 2}, deque);
//
//        assertEquals(deque.front.value, 2);
//        assertEquals(deque.tail.value, 8);
//
//        assertEquals( 8,  deque.removeLast());
//        assertEquals(deque.size(), 1);
//    }
//
//    @Test
//    public void test_RemoveFirst() {
//        Deque deque = new Deque();
//
//        addNodesFront(new int[]{80, 20, 1000, 600}, deque);
//
//        assertEquals(deque.size(), 4);
//
//        assertEquals(deque.removeFirst(), 600);
//        assertEquals(deque.size(), 3);
//        assertEquals(deque.removeFirst(), 1000);
//        assertEquals(deque.size(), 2);
//        assertEquals(deque.removeFirst(), 20);
//
//        assertEquals(deque.size(), 1);
//
//        assertFalse(deque.isEmpty());
//
//        assertEquals(deque.removeFirst(), 80);
//
//        assertTrue(deque.isEmpty());
//    }
//
//    private void addNodesTail(int [] values, Deque deque) {
//        for (int v: values) {
//            deque.addLast(v);
//        }
//    }
//
//    private void addNodesFront(int [] values, Deque deque) {
//        for (int v: values) {
//            deque.addFirst(v);
//        }
//    }
//}