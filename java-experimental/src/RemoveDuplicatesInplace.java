public class RemoveDuplicatesInplace {
    public static void main(String[] args) {
        RemoveDuplicatesInplace arrayIntersection = new RemoveDuplicatesInplace();
        int [] arr = new int[]{1, 1,2};
       // int [] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        int res = arrayIntersection.removeDuplicates(arr);
        for (int i = 0; i < res; i++  ) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return  nums.length;
        }
        int p1 = 0;
        int p2 = p1 + 1;
        while( p2 < nums.length) {
            int pValu1 = nums[p1];
            int pValu2 = nums[p2];
            if(pValu1 != pValu2) {
                int temp = nums[p2];
                nums[p2] = 0;
                p1++;
                nums[p1] = temp;
            } else {
                nums[p2] = 0;
            }
            p2++;
        }
        return p1 + 1;
    }
}
