package array;

public class RemoveDuplicates {
    public int removeDuplicates2(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }

        int j = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[j] != nums[i]) {
                j = i;
            } else {
                nums[i] = -101;
            }

        }
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != -101) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
    public int removeDuplicates1(int[] nums) {
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

    public static void main(String[] args) {
        RemoveDuplicates arrayIntersection = new RemoveDuplicates();
        int [] arr = new int[]{1, 1,2};
        // int [] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        int res = arrayIntersection.removeDuplicates2(arr);
        for (int i = 0; i < res; i++  ) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
