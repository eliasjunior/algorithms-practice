public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        int n = nums.length;
        if (n < k) {
            //k = Math.abs(k - nums.length);
            k = k % n;
        }
        int[] temp = new int[nums.length];

        for (int j = 0; j < n; j++) {
            int diff = (n - 1) - j;
            System.out.println("diff=" + diff);
            if (diff < k) {
                int rem = k - diff;
                System.out.println(rem);
                temp[rem - 1] = nums[j];
            } else {
                temp[j + k] = nums[j];
            }
        }
        for (int ii = 0; ii < n; ii++) {
            nums[ii] = temp[ii];
        }
    }

    public static void main(String[] args) {
        //new RotateArray().rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        new RotateArray().rotate(new int[]{1, 2}, 5);
    }
}
