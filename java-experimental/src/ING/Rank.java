package ING;

import java.util.HashMap;
import java.util.Map;

public class Rank {
    public int solution(int[] ranks) {
        // write your code in Java SE 8
        // TODO adge cases
        Map<Integer, Integer> rankFrequency = new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            int key = ranks[i];
            rankFrequency.put(key, rankFrequency.getOrDefault(key, 0) + 1);
        }
        int result = 0;
        for (Map.Entry entry : rankFrequency.entrySet()) {
            int key = (int) entry.getKey();
            int value = (int) entry.getValue();

            Integer superior = rankFrequency.get(key + 1);
            if (superior != null) {
                result += value;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int res = new Rank().solution(new int []{3 ,4 ,3 , 0, 2, 2, 3 , 0 ,0});
        System.out.println("res " + res);

        res = new Rank().solution(new int []{4, 2, 0});

        System.out.println("res " + res);
        res = new Rank().solution(new int []{4,4, 3, 3, 0, 1});
        System.out.println("res " + res);

        res = new Rank().solution(new int []{2,2});
        System.out.println("res " + res);
        res = new Rank().solution(new int []{2,1});
        System.out.println("res " + res);
        res = new Rank().solution(new int []{2});
        System.out.println("res " + res);
    }

}
