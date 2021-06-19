import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Abs {

    public static void main(String[] args) {
        int res = minimumAbsoluteDifference(Arrays.asList(-59, -36 ,-13, 1, -53, -92, -2, -96, -54, 75));
        System.out.println(res);
    }

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        // TRICK HERE, on the second loop, do not use arr.size() - 1 just because starts from j + 1!
        int min = Integer.MAX_VALUE;
        Collections.sort(arr);

        for(int i = 0; i < arr.size() - 1; i++){
            int elem1 = arr.get(i);
            int elem2 = arr.get(i + 1);
            min = Math.min(min, Math.abs(elem1 - elem2));
        }
        return min;
//
//        return Math.abs(arr.get(0) - arr.get(1));
    }

    static class ByAbs implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            int tempA = a;
            int tempB = b;
            if(tempA < 0) {
                tempA = Math.abs(a);
            }
            if(tempB < 0) {
                tempB = Math.abs(b);
            }

            if(tempA == tempB) {
                return 0;
            } else if(tempA > tempB) {
                return 1;
            } else {
                return -1;
            }
        }
    }

}

