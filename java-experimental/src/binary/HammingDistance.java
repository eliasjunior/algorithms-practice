package binary;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        // first I need to convert to ^, gives me diff, ^ gives the diff bits
        int diff = x ^ y;

        int countBits = 0;
        int mask = 1;
        for(int i = 0; i < 32; i++) {
            //000000000100
            //        0101
            if((diff & mask) != 0) {
                countBits++;
            }
            mask<<=1;
        }
        return countBits;
    }
}
