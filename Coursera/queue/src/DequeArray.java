//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//public class Deque<Item> implements Iterable<Item> {
//    public Item[] stack;
//    public Node tail;
//    public Node front;
//
//    // construct an empty deque
//    public Deque(int capacity) {
//        stack = (Item[]) new Object[capacity];
//    }
//
//    // is the deque empty?
//    public boolean isEmpty() {
//        return front == null;
//    }
//
//    // return the number of items on the deque
//    public int size() {
//        return -1;
//    }
//
//    // add the item to the front
//    public void addFirst(Item item) {
//        validateInputs(item);
//
//        if(stack.length == tail) {
//            stack = resize();
//        }
//        stack[tail--] = item;
//    }
//
//    // add the item to the back
//    public void addLast(Item item) {
//        validateInputs(item);
//    }
//
//    // remove and return the item from the front
//    public Item removeFirst() {
//        if(isEmpty()) {
//            throw new NoSuchElementException();
//        }
//        return null;
//    }
//
//    // remove and return the item from the back
//    public Item removeLast() {
//        if(isEmpty()) {
//            throw new NoSuchElementException();
//        }
//        return null;
//    }
//
//    // return an iterator over items in order from front to back
//    public Iterator<Item> iterator() {
//        return new JuninhoIterator();
//    }
//
//    private Item[] resize() {
//        Item [] copy = (Item[]) new Object[stack.length * 2];
//        for (int i = 0; i < stack.length; i++) {
//            copy[i] = stack[i];
//        }
//        return copy;
//    }
//
//    private class JuninhoIterator implements Iterator {
//        private Node iTail = tail;
//        private Node iFront = front;
//
//        @Override
//        public boolean hasNext() {
//            return i > stack.length;
//        }
//
//        @Override
//        public Item next() {
//            if(i == 0) {
//                throw new NoSuchElementException();
//            }
//            return stack[tail--];
//        }
//
//        public void remove() {
//            throw new UnsupportedOperationException();
//        }
//    }
//
//    // unit testing (required)
//    public static void main(String[] args){
//
//    }
//
//    private void validateInputs(Item item) {
//        if(item == null) {
//            throw new IllegalArgumentException();
//        }
//    }
//
//}