package strings;

public class ReverseInteger {
        public int reverse(int x) {
            // convet to str
            // for -> i, j until they met
            if(x > Integer.MAX_VALUE) {
                return 0;
            }
            String nStr = String.valueOf(x);
            char [] chars = new char[nStr.length()];
            for(int i = 0; i < nStr.length(); i++) {
                chars[i] = nStr.charAt(i);
            }

            int j = chars.length - 1;
            int i = 0;
            while(i < j) {
                char tmp = chars[i];
                if(!isNumber(tmp)) {
                    // edge cases, indexOUt
                    tmp = chars[++i];
                }
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }

            try{
                return  Integer.parseInt(String.valueOf(chars));
            }catch(NumberFormatException e) {
                return 0;
            }
        }

        private boolean isNumber(char c) {
            return String.valueOf(c).matches("^[0-9]");
        }
}
