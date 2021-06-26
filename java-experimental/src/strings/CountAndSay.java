package strings;

public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 1) {
            return String.valueOf(n);
        }
        String prev = countAndSay(n - 1);
        return say(prev);
    }

    private String say(String prev) {
       // char prevChar = prev.charAt(0);
        int n = prev.length();
        int freq = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            freq++;
            if(i == n - 1 || prev.charAt(i) != prev.charAt(i + 1)) {
                sb.append(freq).append(prev.charAt(i));
                freq = 0;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
    }
}
