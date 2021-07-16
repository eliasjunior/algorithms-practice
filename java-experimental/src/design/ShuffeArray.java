package design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffeArray {
        final int [] original;
        int [] nums;

        public ShuffeArray(int[] nums) {
            this.nums = nums;
            this.original = nums.clone();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] shuffle() {
            List<Integer> fuckThis = IntStream.of(original.clone())
                    .boxed()
                    .collect(Collectors.toList());

            List<Integer> fdp = new ArrayList<>();
            while (fuckThis.size() != 0) {
                int idx = getRandom(fuckThis.size());
                fdp.add(fuckThis.get(idx));
                fuckThis.remove(idx);
            }

            return fdp.stream().mapToInt(intinho -> intinho).toArray();
        }

        private int getRandom(int end) {
            Random r = new Random();
            return r.nextInt(end);
        }
        public int[] reset() {
            return original;
        }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
