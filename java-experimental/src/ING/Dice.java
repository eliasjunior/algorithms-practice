package ING;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Dice {
    Map<Integer, Integer> oppositeMap;
    Dice() {
        oppositeMap = new HashMap<>();
        oppositeMap.put(1, 6);
        oppositeMap.put(6, 1);
        oppositeMap.put(2, 5);
        oppositeMap.put(5, 2);
        oppositeMap.put(3, 4);
        oppositeMap.put(4, 3);
    }
    public int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Map<Integer, Integer> freqs = new HashMap<>();
        for (Integer n : A) {
            freqs.put(n, freqs.getOrDefault(n, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : freqs.entrySet()) {
            Integer key = entry.getKey();
            Integer freq = entry.getValue();
            int minMoveList = A.length;

            // sub size - freq
            int moves = minMoveList - freq;
            // 6
            // always bring someone
            Integer opposite = oppositeMap.get(key);

            // from the freqs is my Opp pair there ?
            Integer oppFreq = freqs.get(opposite);

            if (oppFreq != null) {
                // replace 1 move by 2
                moves = moves - oppFreq;
                moves = oppFreq * 2 + moves;
            }
            min = Math.min(min, moves);
        }
        return min;
    }

    @Test
    public void testAll() {
        Dice dice = new Dice();
        Assertions.assertEquals(2, dice.solution(new int[]{1, 2, 3}));
        Assertions.assertEquals(2, dice.solution(new int[]{1, 1, 6}));
        Assertions.assertEquals(3, dice.solution(new int[]{1, 6, 2, 3}));
        Assertions.assertEquals(4, dice.solution(new int[]{1, 2, 3, 4, 5}));
    }
}

