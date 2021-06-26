package strings;

public class MyAtoi {
    public int myAtoi(String s) {
        if(s.length() == 0 || s.trim().length() == 0) {
            return 0;
        }
        StringBuilder res = new StringBuilder();
        boolean hasNumber = false;
        int start = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (isValidInit(c)) {
                boolean isNum = isNumber(c);
                if (c != ' ' || c != '0') {
                    if (c == '-' || c == '+' || isNum) {
                        if (c == '-') {
                            res.append(c);
                        } else if (isNum) {
                            res.append(c);
                            hasNumber = true;
                        }
                        start = i;
                        break;
                    }
                }
            } else {
                return 0;
            }
        }

        for (int i = start + 1; i < n; i++) {
            char c = s.charAt(i);
            if(isNumber(c)) {
                res.append(c);
                hasNumber = true;
            } else if(!hasNumber){
                return 0;
            } else {
                break;
            }
        }

        if(!hasNumber) {
            return 0;
        }

        String str = res.toString();
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            if (!str.startsWith("-")) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
    }

    private boolean isValidInit(char c) {
        return (c == ' ' || c == '0' || c == '+' || c == '-' || isNumber(c));
    }

    private boolean isNumber(char c) {
        return String.valueOf(c).matches("^[0-9]");
    }

    public static void main(String[] args) {
        test("+", 0);
        test("-", 0);
        test("+5", 5);
        test("+5 ", 5);
        test("-42", -42);
        test("3.933", 3);
        test("3 933", 3);
        test("3933 rr", 3933);
    }

    private static void test(String input, int expected) {
        int res = new MyAtoi().myAtoi(input);
        boolean b = (res == expected);
        String message = "input "+input+", result " + res;
        if(!b) {
            System.err.println(message);
        } else {
            System.out.println(message);
        }
    }
}
