package array;

public class MergeTwoArrays {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (nums2.length == 0 || nums1.length == 0) {
                return;
            }

            int p1 = m - 1;
            int p2 = n - 1;

            for(int p = m + n - 1; p >=0; p--) {
                if(p2 < 0) {
                    break;
                }
                if(p1 >= 0 && nums1[p1] >= nums2[p2]) {
                    nums1[p] = nums1[p1--];
                } else {
                    nums1[p] = nums2[p2--];
                }
            }

//         int p1 = 0;
//         int p2 = 0;

//         int zero = m;
//         while (p1 < nums1.length && p2 < n) {
//             if (p1 >= zero) {
//                 nums1[p1] = nums2[p2];
//                 p1 = p2;
//                 p2++;
//                 zero++;
//             } else if (nums1[p1] >= nums2[p2]) {
//                 int tmp = nums2[p2];
//                 nums2[p2] = nums1[p1];
//                 //   nums1[zero++] = nums1[p1];
//                 nums1[p1] = tmp;
//                 p1++;
//             } else {
//                 p1++;
//             }
//         }
        }
}
