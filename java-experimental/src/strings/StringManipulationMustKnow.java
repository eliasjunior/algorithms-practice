package strings;

public class StringManipulationMustKnow {
    //horizontal scanning
    private String longestPrefixString(String s1, String s2) {
        String prefix = s1; // flower
        // gives 0 when matches a prefix, for ex abbc == > ab == 0
        while(s2.indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }

        return prefix;
    }

    private String smallestCommonString(String s1, String s2) {
        int i = 0, j = 0;
        StringBuilder sub1 = new StringBuilder(s2.charAt(i));
        String min = s2;
        while( j < s2.length() &&  i < s1.length() &&
                sub1.indexOf(s2.substring(0, j)) == 0) {
            sub1.append(s1.charAt(i++)); // O(1), like ArrayList add operation
            // calculate the min
            // N log N
            if(isDivisible(sub1.toString(), s1)) {
                if(min.length() > sub1.length()) {
                    min = sub1.toString();
                }
            }
        }
        return min;
    }

    private boolean isDivisible(String s, String divisor) {
        StringBuilder sb = new StringBuilder(s);
        // log N ==> N Log N
        while(sb.length() < divisor.length()) {
            sb.append(sb); // O(N) because it add the whole string, just like a addAll
        }
        return sb.toString().equals(divisor);
    }


    public static void main(String[] args) {
        System.out.println(new StringManipulationMustKnow().longestPrefixString("flower", "flight"));
        System.out.println(new StringManipulationMustKnow().smallestCommonString("bcdbcdbcdbcd", "bcdbcd"));
    }
}
