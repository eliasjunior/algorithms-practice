import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoStackQueueTest {


    @Test
    public void testQueue() {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.push(1);
        twoStackQueue.push(2);
        twoStackQueue.push(3);

        assertEquals(1, twoStackQueue.peek());
        assertEquals(1, twoStackQueue.pop());
        assertEquals(2, twoStackQueue.peek());

        assertEquals(2, twoStackQueue.pop());
        assertEquals(3, twoStackQueue.pop());
        assertTrue(twoStackQueue.empty());
    }
}