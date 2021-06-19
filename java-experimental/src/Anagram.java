import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Result {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static int makeAnagram(String a, String b) {
        // Write your code here
        int remA = removeChars(new StringBuilder(a), b);

        int remB = removeChars(new StringBuilder(b), a);

        return remA + remB;
    }

    public static int removeChars(StringBuilder s, String b) {
        Map<String, Integer> mapCounter = addFreq(b);
        int count = 0;
        // Queue<String> queue = new ArrayDeque();
        // while(queue.size() != 0) {
        int i = 0;
        while (i < s.length()) {
            String key = String.valueOf(s.charAt(i));
            Integer freq = mapCounter.get(key);
            if (freq == null) {
                //O(n)!!
                s.deleteCharAt(i);
                count++;
            } else {
                if (freq == 1) {
                    mapCounter.remove(key);
                } else {
                    mapCounter.put(key, freq - 1);
                }
                i++;
            }
        }
        return count;
    }

    public static Map<String, Integer> addFreq(String s) {
        Map<String, Integer> mapCounter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String key = String.valueOf(s.charAt(i));
            Integer freq = mapCounter.get(key);

            if (freq == null) {
                mapCounter.put(key, 1);
            } else {
                mapCounter.put(key, freq + 1);
            }
        }
        return mapCounter;
    }
}

public class Anagram {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = bufferedReader.readLine();

        String b = bufferedReader.readLine();

        int res = Result.makeAnagram(a, b);

        System.out.println("res -> " + res);

        // bufferedWriter.write(String.valueOf(res));
        //  bufferedWriter.newLine();

        bufferedReader.close();
        //  bufferedWriter.close();
    }
}
