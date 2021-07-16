package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
        public int climbStairs(int n) {
        /*

         2. 11 2
         3. 111 12 21
            1111 112 121 211 22
            11111 1112 1121 1211 122 2111 221

            n = 6
            111111
            11112
            11121
            1122

            print(n - 1) + print(n - 2) + print(n - 3)

        */
            return helper(n, new HashMap<>());

        }

        private int helper(int n, Map<Integer, Integer> memo) {
            Integer res = memo.get(n);

            if(n == 1 ) {
                return n;
            } else if(n == 2) {
                return n;
            }

            if(res != null) {
                return res;
            }
            int p1 = helper(n - 1, memo);
            int p2 = helper(n - 2, memo);

            memo.put(n, p1 + p2);

            return  p1 + p2;
        }

}
