package mustKnowJava;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HandyMethods {

    public static void main(String[] args) {

    }

    void deque() {
        Deque deque = new ArrayDeque();
        // Add at the last
        deque.add("Element 1 (Tail)");

        // Add at the first
        deque.addFirst("Element 2 (Head)");

        // Add at the last
        deque.addLast("Element 3 (Tail)");

        // stack
        deque.push(2);
        deque.pop();

        deque.offer("Element 5 (Tail)");

        // Add at the first
        deque.offerFirst("Element 6 (Head)");

        System.out.println(deque + "\n");

        // We can remove the first element
        // or the last element.
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque after removing "
                + "first and last: "
                + deque);
    }

    @Test
    void priorityQueue() {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(10);
        queue.add(20);
        queue.add(5);
        queue.add(-3);
        queue.add(25);

        System.out.println( queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    void concurrentMap() {
        // create an instance of
        // ConcurrentHashMap
        ConcurrentHashMap<Integer, String> m
                = new ConcurrentHashMap<>();

        // Insert mappings using
        // put method
        m.put(100, "Hello");
        m.put(101, "Geeks");
        m.put(102, "Geeks");

        // Here we cant add Hello because 101 key
        // is already present in ConcurrentHashMap object
        m.putIfAbsent(101, "Hello");

        // We can remove entry because 101 key
        // is associated with For value
        m.remove(101, "Geeks");

        // Now we can add Hello
        m.putIfAbsent(103, "Hello");

        // We cant replace Hello with For
        m.replace(101, "Hello", "For");
        System.out.println(m);
    }

    void maps() {
        // No need to mention the
        // Generic type twice
        HashMap<Integer, String> hm1 = new HashMap<>();

        // Initialization of a HashMap
        // using Generics
        HashMap<Integer, String> hm2
                = new HashMap<>();

        // Add Elements using put method
        hm1.put(1, "one");
        hm1.put(2, "two");
        hm1.put(3, "three");

        hm2.put(4, "four");
        hm2.put(5, "five");
        hm2.put(6, "six");

        System.out.println("Mappings of HashMap hm1 are : "
                + hm1);
        System.out.println("Mapping of HashMap hm2 are : "
                + hm2);

        for (Map.Entry<Integer, String> e : hm1.entrySet())
            System.out.println("Key: " + e.getKey()
                    + " Value: " + e.getValue());
    }

    void hashSets() {
        HashSet<String> h = new HashSet<String>();

        // Adding elements into HashSet usind add()
        h.add("India");
        h.add("Australia");
        h.add("South Africa");
        h.add("India"); // adding duplicate elements

        // Displaying the HashSet
        System.out.println(h);
        System.out.println("List contains India or not:"
                + h.contains("India"));

        // Removing items from HashSet using remove()
        h.remove("Australia");
        System.out.println("List after removing Australia:"
                + h);

        // Iterating over hash set items
        System.out.println("Iterating over list:");
        Iterator<String> i = h.iterator();
        while (i.hasNext())
            System.out.println(i.next());
    }
}
