import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Solution {
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
//            Bitwise AND Operation of 5 and 7
//            0101
//          & 0111
//            ________
//            0101  = 5 (In decimal)
            if ((n & mask) != 0) {
                bits++;
            }
            // shift one place to the left
            // e.g 5 binary
            // 0000 0101 , shift 1(left) 0000 1010 = 10
            mask <<= 1;
        }
        return bits;
    }
    public int hammingWeight2(int n) {
        if (n == 0) {
            return 0;
        }
        StringBuilder binaryNumber = new StringBuilder();
        int count = 0;
        if(n < 0) {

        }
        while (n > 0) {
            int remainder = n % 2;
            if(remainder == 1 ) {
                count++;
            }
          //  binaryNumber.append(remainder);
            n /= 2;
        }
       // binaryNumber = binaryNumber.reverse();
        // String bin = binaryNumber.toString();

        return count;

    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
       // list.add(i, ele);

        System.out.println("1".charAt(0) - '5');
    }
}