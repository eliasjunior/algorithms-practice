import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationArraysSwap {

    public static void main(String[] args) {
        // search largest and swap with first position
        // search second largest and swap with second position

        PermutationArraysSwap p = new PermutationArraysSwap();
        // List<Integer> res = p.largestPermutation(2, Arrays.asList(4, 1, 3, 2));
        // List<Integer> res = p.largestPermutation(2, Arrays.asList(1, 2, 3, 4));
        // List<Integer> res = p.largestPermutation(1, Arrays.asList(4, 2, 3, 5, 1));
        // List<Integer> res = p.largestPermutation(1, Arrays.asList(1, 2));

        // List<Integer> res = largestPermutation(4, Arrays.asList(4, 1, 3, 5, 2, 8));

        // for (Integer integer : res) {
        // System.out.print(integer + " ");
        // }

        String resBracked = isBalanced("(");
        System.out.println("====== " + resBracked);

    }

    public static List<Integer> largestPermutation(int k, List<Integer> arr) {
        // Write your code here

        Integer[] sorted = new Integer[arr.size()];
        Map<Integer, Integer> keys = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = arr.get(i);
            keys.put(arr.get(i), i);
        }

        Arrays.sort(sorted, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            int currentLarg = sorted[i];
            int index = keys.get(currentLarg);

            int value = arr.get(i);

            arr.set(i, currentLarg);
            arr.set(index, value);

            // now swap value has changed the index
            keys.put(value, index);
            keys.put(currentLarg, i);

        }

        return arr;
    }

    public static String isBalanced(String s) {
        if (s == null || s.trim().length() == 0) {
            return "NO";
        }
        s = s.trim();
        // Write your code here
        List<String> stack = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));

            if (current.equals("{") || current.equals("[") || current.equals("(")) {
                // push
                stack.add(current);
            } else {
                // pop
                if (stack.size() == 0) {
                    return "NO";
                }
                String closedBracket = stack.remove(stack.size() - 1);
                if (current.equals("}") && !closedBracket.equals("{")) {
                    return "NO";
                } else if (current.equals("]") && !closedBracket.equals("[")) {
                    return "NO";
                } else if (current.equals(")") && !closedBracket.equals("(")) {
                    return "NO";
                }

            }
        }
        if (stack.size() > 0) {
            return "NO";
        }
        return "YES";
    }
}
