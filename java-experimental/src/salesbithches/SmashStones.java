package salesbithches;


// [1, 2, 3, 6, 7, 7] => 0
// [2 , 4, 5] => 1

import multithreading.SalesService;

import java.util.*;

public class SmashStones {

    // sort the array to get always 2 greatest
    public static int lastStoneWeight(List<Integer> stones) {
        Collections.sort(stones);

        Deque<Integer> deque = new ArrayDeque<>();
        for (Integer val: stones) {
            deque.push(val);
        }

        int current = deque.pop();
        int next = deque.pop();
        deque.push(Math.abs(current - next));
        while (deque.size() > 1) {
            current = deque.pop();
            next = deque.pop();
            deque.push(Math.abs(current - next));
        }
        return deque.pop();
    }

    public static void main(String[] args) {
        System.out.println(SmashStones.lastStoneWeight(Arrays.asList(1, 2, 3, 6, 7, 7)));
        System.out.println(SmashStones.lastStoneWeight(Arrays.asList(2 ,4, 5)));
        System.out.println(SmashStones.lastStoneWeight(Arrays.asList(2, 3, 0, 4, 7)));
    }
}
