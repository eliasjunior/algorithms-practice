import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int n;
    private Item[] queue;
    private int first;
    private int last;
    private static final int INIT_CAPACITY = 8;

    // construct an empty randomized queue
    public RandomizedQueue() {
        queue = (Item[]) new Object[INIT_CAPACITY];
        first = 0;
        last = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        validateInputs(item);

        if (n == queue.length) {
            resize(queue.length * 2);
        }
        queue[last++] = item;
        if (last == queue.length) {
            last = 0;
        }

        n++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item res = queue[first];
        //if has more then 2 items
        queue[first] = null;
        first++;
        if (first == queue.length) first = 0;
        n--;

        if (n > 0 && n == queue.length/4) {
            resize(queue.length/2);
            StdRandom.shuffle(queue, first, last - 1);
        }

        return res;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[first];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueue.JuninhoIterator();
    }

    private class JuninhoIterator implements Iterator {
        private int current = 0;

        JuninhoIterator() {
            if(last - 1 > first) {
                StdRandom.shuffle(queue, first, last - 1);
            }
        }

        @Override
        public boolean hasNext() {
            return current < n;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = queue[(current + first) % queue.length];
            current++;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> r = new RandomizedQueue<>();
         for (int i = 0; i < 1; i++) {
            assert r.test_dequeueEnqueue();
            assert r.test_dequeueEnqueue2();
            assert r.test_dequeueEnqueue3();
            assert r.test_dequeueEnqueue4(r);
            assert r.test_iterator();
         }

    }

    private boolean test_dequeueEnqueue() {
        RandomizedQueue<Integer> r = new RandomizedQueue();

        r.enqueue(100);
        assert r.dequeue() == 100;
        assert r.isEmpty() == true;
        assert r.size() == 0;

        assert r.isEmpty() == true;
        return true;
    }

    private boolean test_dequeueEnqueue2() {
        RandomizedQueue<Integer> r = new RandomizedQueue();

        r.enqueue(1);
        assert r.sample() == 1;
        assert r.isEmpty() == false;

        r.enqueue(2);
        assert r.size() == 2;

        r.dequeue();
        r.enqueue(379);

        assert r.size() == 2;
        r.enqueue(276);
        r.dequeue();
        assert r.dequeue() != null;

        return true;
    }

    private boolean test_dequeueEnqueue3() {
        RandomizedQueue<Integer> r = new RandomizedQueue();

        r.enqueue(379);
        assert r.size() == 1;
        r.enqueue(276);
        r.dequeue();
        assert r.dequeue() != null;

        return true;
    }

    private boolean test_dequeueEnqueue4(RandomizedQueue queue) {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        return true;
    }

    private boolean test_iterator() {
        int n = 5;
        RandomizedQueue<Integer> queue = new RandomizedQueue<>();
        for (int i = 0; i < n; i++)
            queue.enqueue(i);

        for (int a : queue) {
            for (int b : queue)
                StdOut.print(a + "-" + b + " ");
            StdOut.println();
        }
        /*
        0-2 0-1 0-3 0-0 0-4
        1-2 1-1 1-4 1-0 1-3
        2-1 2-4 2-0 2-3 2-2
        4-2 4-3 4-4 4-1 4-0
        3-2 3-3 3-1 3-0 3-4
        */
        return true;
    }

    private void validateInputs(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = queue[(first + i) % queue.length];
        }
        queue = copy;

        first = 0;
        last = n;
    }
}
