package array;

public class MoveZeros {
        public void moveZeroes(int[] nums) {
            // [0]

            // k = 2, length == k
//         [0,1,0,3,12]
//           [1, 3, 12]
//         [1, 0, 3, 12, 0] -- length - k0s k = 0 -> n
//         [1, 3, 12, 0, 0]
            // k = 4
            // i = 0, 1
            // k - i
            //[1, 2, 0, 0, 0, 0]
            //
            int z = 0;
            int k = 0;
            for(int i = 0; i < nums.length; i++) {
                int n = nums[i];

                if(n == 0) {
                    z++;
                } else {
                    nums[i] = 0;
                    nums[k++] = n;
                }
            }
        }
}
