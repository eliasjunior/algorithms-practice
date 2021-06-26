import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.



Constraints:

    1 <= nums1.length, nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 1000

 */

public class ArrayIntersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer,Integer> mapFreqs = new HashMap<>();

        for(int n: nums1) {
            mapFreqs.put(n, mapFreqs.getOrDefault(n , 0) + 1);
        }

        int k = 0;
        for (int i = 0; i < nums2.length; i++) {
            int n = nums2[i];

            Integer freq = mapFreqs.getOrDefault(n, 0);

            if(freq > 0) {
                // this way I dont need to create the ArrayList
                nums1[k++] = n;
                mapFreqs.put(n, freq - 1);
            }
        }

        return Arrays.copyOfRange(nums1, 0, k);
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
