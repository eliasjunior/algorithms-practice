package strings;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) {
            return strs[0];
        }
        StringBuilder maxCommon = new StringBuilder();
        maxCommon.append(strs[0]);// add whole word

        for (int i = 0; i < strs.length - 1; i++) {
            String word = strs[0];
            String next = strs[ i + 1];
            int k = 0;
            int j = 0;
            StringBuilder temp = new StringBuilder();
            // System.out.println(word);
            // System.out.println(next);
            while(k < word.length() && j < next.length()) {
                char c1 = word.charAt(k);
                char c2 = next.charAt(j);

                if(c1 == c2) {
                    temp.append(c2);
                } else {
                    break;
                }
                k++;
                j++;
            }
            // System.out.println(temp.length() + " < " +  maxCommon.length());
            if(temp.length() == 0) {
                return "";
            }
            if( temp.length() < maxCommon.length()) {
                maxCommon = temp;
            }
        }

        return maxCommon.toString();
    }

    public static void main(String[] args) {
        new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"});
    }
}
