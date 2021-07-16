package ING;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindError {
    public void solution(int N) {
        int enable_print = N % 10;
        Deque<Integer> d = new ArrayDeque();
        while (N > 0) {
            if (enable_print == 0 || N % 10 != 0) {
                enable_print = 1;
            }
            if (enable_print == 1) {
               // System.out.print(N % 10);
                d.push(N % 10);
            }
            N = N / 10;
        }

        while(!d.isEmpty()) {
            System.out.print(d.pop());
        }
    }

    public static void main(String[] args) {
        new FindError().solution(9);
    }
}
