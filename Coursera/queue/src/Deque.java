import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Deque.Node tail;
    private Deque.Node front;
    private int n;

    // construct an empty deque
    public Deque() {
        this.front = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return front == null && tail == null;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        validateInputs(item);

        Deque.Node previousFront = front;
        front = new Deque.Node(item);
        front.next = previousFront;
        if (front.next == null && tail == null) {
            tail = front;
        }
        // new one for the other way
//       Node inverseNext = tail.next;
//       tail.next = new Node((Integer)item);
//       tail.next.next = inverseNext;

        n++;
    }

    // add the item to the back
    public void addLast(Item item) {
        validateInputs(item);
        Deque.Node oldTail = tail;
        tail = new Deque.Node(item);
        if (front == null) {
            front = tail;
        }
        if (oldTail != null) {
            oldTail.next = tail;
        }
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item result;
        result = (Item) front.value;
        front = front.next;
        if (front == null) {
            tail = null;
        }

        n--;
        return result;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item result;
        Deque.Node current = front;
        Deque.Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        result = (Item) current.value;
        if (previous != null) {
            tail = previous;
            if (tail == null) {
                front = null;
            } else {
                tail.next = null;
            }
        } else {
            front = null;
            tail = null;
        }

        n--;
        return result;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new JuninhoIterator();
    }

    private class JuninhoIterator implements Iterator {
        private Deque.Node current = front;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Item result = (Item) current.value;
            current = current.next;
            return result;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> d = new Deque<>();

        assert d.firstTest();
        assert d.testCheckRandomCalls();
        assert d.testCheckRandom2();
        assert d.testAddLastRemoveLastIsEmpty();
        assert d.testAddFirstRemoveFirstIsEmpty();
        assert d.testIterator();
        assert d.testMoreIsEmpty();
    }

    private void validateInputs(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
    }

    private class Node<Integer> {
        Integer value;
        Node next;

        Node(Integer value) {
            this.value = value;
        }
    }

    private boolean firstTest() {
        Deque<Integer> d = new Deque<>();
        d.addFirst(100);
        d.addLast(200);
//        StdOut.println(d.size());
//        StdOut.println(d.isEmpty());
//        StdOut.println( d.removeLast());
//        StdOut.println(d.removeFirst());
        return true;
    }

    private boolean testCheckRandomCalls() {
        //0.4, 0.4, 0.0, 0.0, 0.0, 0.2, 0.0
        Deque<Double> d = new Deque<>();

//        d.addFirst(0.4);
//        d.addFirst(0.4);
        //       d.addLast(0.0);
        d.size();

        d.addLast(0.2);
        d.addLast(0.2);
        d.addLast(0.2);

        assert d.size() == 3;

        d.addFirst(0.0);

        return d.size() == 4;
    }

    private boolean testCheckRandom2() {
        //0.4, 0.4, 0.0, 0.0, 0.0, 0.2, 0.0
        Deque<Double> d = new Deque<>();

        d.addLast(0.2);
        d.addLast(0.0);
        d.addLast(0.4);
        d.addFirst(0.0);

        for (Double item :
                d) {
            //  System.out.println(item);
        }

        return d.size() == 4;
    }

    private boolean testAddLastRemoveLastIsEmpty() {
        //(0.0, 0.8, 0.1, 0.0, 0.1, 0.0, 0.0)
        Deque<Double> d = new Deque<>();

        d.addLast(0.2);
        d.removeLast();
        d.addFirst(0.0);

        return d.size() == 1;

    }

    private boolean testAddFirstRemoveFirstIsEmpty() {
        //(0.0, 0.8, 0.1, 0.0, 0.1, 0.0, 0.0)
        Deque<Double> d = new Deque<>();
        d.addFirst(0.2);
        d.removeFirst();

        assert d.isEmpty() == true;


        d.addLast(0.8);
        d.removeFirst();

        assert d.isEmpty() == true;

        return true;
    }

    private boolean testIterator() {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        for (Integer item :
                deque) {
            assert item == 1;
        }
        assert deque.removeFirst() == 1;
        deque.addLast(4);
        deque.addFirst(5);
        assert deque.removeLast() == 4;

//        List<Integer> result = new ArrayList<>();
//        for (Integer item:
//                deque) {
//                result.add(item);
//            // [5, 1]
//        }
        //  assert result.containsAll(Arrays.asList(5));
        return true;
    }

    private boolean testMoreIsEmpty() {
        Deque<Integer> deque = new Deque<>();

        assert deque.isEmpty() == true;
        assert deque.isEmpty() == true;
        deque.addLast(3);
        assert deque.removeLast() == 3;
        assert deque.isEmpty()  == true;


        deque.addFirst(9);
        deque.removeFirst();
        assert deque.isEmpty()  == true;

        deque.addFirst(9);
        deque.removeLast();
        assert deque.isEmpty()  == true;

        deque.addLast(9);
        deque.removeFirst();

        assert deque.isEmpty()  == true;
        return true;
    }
}