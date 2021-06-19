public class ArrayIntersection {

    public static void main(String[] args) {
        ArrayIntersection arrayIntersection = new ArrayIntersection();
        int[] res = arrayIntersection.intersect(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3 ,4 });
        print(res);
        res = arrayIntersection.intersect(new int[]{1}, new int[]{1, 2});
        print(res);
        res = arrayIntersection.intersect(new int[]{1,2,2,1}, new int[]{2, 2});
        print(res);
        res = arrayIntersection.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        print(res);
        res = arrayIntersection.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,1,1,1,1,4,9,5});
        print(res);
    }

    private static void print(int[] res) {
        for (int i : res
        ) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        //edge cases, arr size == 0
        // performance, when gets to the end of the arrays

        // [1,2,2,1], nums2 = [2,2,3,1]
        // s 1, e 2
        // i = 2, j = 1;
        // ou = 2, in = 2
        int start = -1, tStart = -1;
        int end = 0, tEnd = -1;
        int max = -1;
        int j = 0;
        int i = 0;
        while (i < nums1.length) {
            while (j < nums2.length) {
                int outer = nums1[i];
                int inner = nums2[j];
                // edge cases , arr.size = 1
                // make sure s, e only overwrite by larger intersection
                if (outer == inner) {
                    if (tStart == -1) {
                        tStart = i;
                    }
                    tEnd = i;
                    j++;
                    i++;
                    if(i >= nums1.length) {
                        break;
                    }
                } else {
                    j++;
                }
            }
            j = 0;
            i++;
            // check outer size
            if (tStart >= 0 && max < (tEnd - tStart)) {
                end = tEnd;
                start = tStart;
                max = end - start;
            }
        }
        int[] finalResult = new int[max + 1];
        int l = 0;
        for (int k = start; k < end + 1; k++) {
            finalResult[l++] = nums1[k];
        }
        // convert to a int [];
        return finalResult;
    }
}
