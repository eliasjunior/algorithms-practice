import java.util.HashMap;
import java.util.Map;

public class Permutation {
    public static void main(String[] args) {
        int res = new Permutation().permutationOfGivenString("xacxzaa", "xaazxacaaxzoecazxaxaz");
        System.out.println("res=====> " + res);
    }

    public int permutationOfGivenString(String s, String b) {
        int count = 0;
        int sSize = s.length();
        final Map<String, Integer> occurMap = new HashMap<>();

        // populating the map with char occurences
        for (int i = 0; i < sSize; i++) {
            char c = s.charAt(i);

            Integer occur = occurMap.get(String.valueOf(c));
            if (occur != null) {
                occurMap.put(String.valueOf(c), occur + 1);
            } else {
                occurMap.put(String.valueOf(c), 1);
            }

        }
        int whole = b.length() - sSize;
        for (int i = 0; i < whole; i++) {
            // check
            String currentStr = b.substring(i, sSize + i);

            if (isPermutation(currentStr, occurMap)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPermutation(String currentStr, Map<String, Integer> map) {
        Map<String, Integer> occurMap = new HashMap<>(map);
        // loop cure
        // check HashMap
        // decrease
        // return false, break


        for (int i = 0; i < currentStr.length(); i++) {
            char c = currentStr.charAt(i);
            Integer freq = map.get(String.valueOf(c));
            if (freq != null) {
                // check 0
                if (freq == 0) {
                    occurMap.remove(String.valueOf(c));
                } else {
                    occurMap.put(String.valueOf(c), freq - 1);
                }

            } else {
                return false;
            }
        }

        // O(b) check all occurence has 0

        return true;
    }
}
