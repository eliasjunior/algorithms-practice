package ING;

import java.util.HashMap;
import java.util.Map;

public class Dice {
    // Dice movements
    // 1 and 6, 2 and 5, 3 and 4;
    public int solution(int[] A) {
        Map<Integer, Integer> oppositeMap = new HashMap<>();
        oppositeMap.put(1, 6);
        oppositeMap.put(6, 1);
        oppositeMap.put(2, 5);
        oppositeMap.put(5, 2);
        oppositeMap.put(3, 4);
        oppositeMap.put(4, 3);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int cur = A[i];
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    int myPair = A[j];
                    Integer opposite = oppositeMap.get(cur);
                    if (opposite == myPair) {
                        count = count + 2;
                    } else if(myPair != cur) {
                        count = count + 1;
                    }
                }
            }
            min = Math.min(min, count);
        }
        return min;
    }

    public static void main(String[] args) {
        display(new int[]{1, 2, 3});
        display(new int[]{1, 1, 6});
        display(new int[]{1, 6, 2 , 3});
        display(new int[]{1,2,3,4,5});
    }

    private static void display(int [] arr) {
        Dice dice = new Dice();
        System.out.print("Input Dices [");
        for (int n:arr) {
            System.out.print(n + " ");
        }
        System.out.println("], min moves " + dice.solution(arr));
    }
}
