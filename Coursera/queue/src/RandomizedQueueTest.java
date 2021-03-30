import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedQueueTest {

    @Test
    public void test_Edges() {
        RandomizedQueue<Integer> rQueue = new RandomizedQueue();
        assertThrows(IllegalArgumentException.class, () -> rQueue.enqueue(null));
        assertThrows(NoSuchElementException.class, () -> rQueue.dequeue());
        assertThrows(NoSuchElementException.class, () -> rQueue.sample());
        assertThrows(NoSuchElementException.class, () -> rQueue.iterator().next());
        assertThrows(UnsupportedOperationException.class, () -> rQueue.iterator().remove());
    }

    @Test
    public void test_isEmptyAndSize() {
        RandomizedQueue<Integer> rQueue = new RandomizedQueue();

        rQueue.enqueue(1);
        rQueue.enqueue(2);
        rQueue.enqueue(3);

        assertEquals(rQueue.size(), 3);
        assertFalse(rQueue.isEmpty());
    }

    @Test
    public void test_dequeue() {
        RandomizedQueue<Integer> rQueue = new RandomizedQueue();

        rQueue.enqueue(100);
        rQueue.enqueue(200);
        rQueue.enqueue(300);

        Integer removed = rQueue.dequeue();

        System.out.println("removed=" +removed);

        for (Integer item: rQueue) {
            System.out.println("item=" + item);
        }

    }
}