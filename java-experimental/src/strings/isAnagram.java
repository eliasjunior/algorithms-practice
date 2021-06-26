package strings;

public class isAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char l = t.charAt(i);
            counter[c - 'a']++;
            counter[l - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isAnagram("roma", "amor");
    }
}
