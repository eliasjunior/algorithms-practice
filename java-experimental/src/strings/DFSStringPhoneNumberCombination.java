package strings;

import java.util.ArrayList;
import java.util.List;

public class DFSStringPhoneNumberCombination {
    /*
    1 2 3
    4 5 6
    7 8 9
    letters display in the number as it follow the array, index 0 and 1 are empty
    because 0 is not in the phone and 1 does not have letter, also could store in a HashMap
    https://www.youtube.com/watch?v=nNGSZdx6F3M
     */
    final static String [] PHONE_LETTERS = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno" , "pqrs", "tuv" , "wxyz"};
    static List<String> result = new ArrayList<>();
    public void letterCombination(String digits) {
        dfs(digits, new StringBuilder(), 0);
    }

    private void dfs(String digits, StringBuilder chosen, int index) {
        String sindent = print(index);
        if(index == digits.length()) {
            System.out.println(sindent + " nothing for " + chosen.charAt(chosen.length() - 1));
            // in this case, all combinations are valid, but there are different problems that I have should not add to the result
            result.add(chosen.toString());
            return;
        }

        System.out.println(sindent + " DFS " +digits.charAt(index));

        int digitIndex = Character.getNumericValue(digits.charAt(index));
        String letters = PHONE_LETTERS[digitIndex];

        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            System.out.println(sindent + " choose " + c);
            chosen.append(c); //a
            dfs(digits, chosen, index + 1);
            System.out.println(sindent + " un-chose " + chosen.charAt(chosen.length() - 1));
            chosen.deleteCharAt(chosen.length() - 1);
        }

    }

    private String print(int length) {
        String s = "";
        for (int i = 0; i < length; i++) {
            s += "----";
        }
        return s;
    }

    public static void main(String[] args) {
        new DFSStringPhoneNumberCombination().letterCombination("23");
        System.out.println(result.toString());
    }
}
