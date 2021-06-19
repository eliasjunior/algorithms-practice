import java.util.Arrays;
import java.util.List;

public class BitManipulation {
    public static void main(String[] args) {
        int res = findUniqueInteger(Arrays.asList(6,1,6,8,8));
        System.out.println("res " + res);
    }

    private static int findUniqueInteger(List<Integer> asList) {
        int remainder = asList.get(0) ^ asList.get(1);
        for (int i = 2; i < asList.size(); i++) {
            int cur = asList.get(i);
            remainder = remainder ^ cur;
        }
        return remainder;
    }

}
