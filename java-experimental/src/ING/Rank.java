package ING;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Rank {
    public int solution(int[] ranks) {
        if(ranks.length == 0) {
            return 0;
        }
        // n log n
        Arrays.sort(ranks);
        int count = 1;
        int result = 0;
        int prev = ranks[0];
        for (int i = 1; i < ranks.length; i++) {
            int r = ranks[i];
            if(r == prev) {
                count++;
            } else {
                if(r == prev + 1) {
                    result += count;
                }
                count = 1;
                prev = r;
            }
        }
        return result;
    }
    public int solution2(int[] ranks) {
        // write your code in Java SE 8
        Map<Integer, Integer> rankFrequency = new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            int key = ranks[i];
            rankFrequency.put(key, rankFrequency.getOrDefault(key, 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : rankFrequency.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            Integer superior = rankFrequency.get(key + 1);
            if (superior != null) {
                result += value;
            }
        }
        return result;
    }

    @Test
    public void testAll() {
        Rank rank = new Rank();
        Assertions.assertEquals(5, rank.solution(new int[]{3, 4, 3, 0, 2, 2, 3, 0, 0}));
        Assertions.assertEquals(0, rank.solution(new int[]{4, 2, 0}));
        Assertions.assertEquals(3, rank.solution(new int[]{4, 4, 3, 3, 0, 1}));
        Assertions.assertEquals(0, rank.solution(new int[]{2, 2}));
        Assertions.assertEquals(1, rank.solution(new int[]{2, 1}));
        Assertions.assertEquals(0, rank.solution(new int[]{2}));
        Assertions.assertEquals(0, rank.solution(new int[]{}));
    }
}
