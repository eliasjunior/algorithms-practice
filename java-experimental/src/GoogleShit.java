import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GoogleShit {
    public String largestTimeFromDigits(int [] shit) {
        return helper(IntStream.of(shit).boxed().collect(Collectors.toList()), new ArrayList<>());
    }

    private String helper(List<Integer> shit, List<Integer> acc) {
       // System.out.println("call ("+ shit + ", " +acc + ")");
        if(shit.size() == 0) {
            String s = Arrays.toString(acc.stream().toArray());
            printValid(s);
            return s;
        }
        String res = "";
        for (int i = 0; i < shit.size(); i++) {
            //choose
            Integer temp = shit.get(i);
            acc.add(temp); // {a} --> 1
            shit.remove(i); // {b, c, d} --> 2
            // explore
            res = helper(shit, acc);

            //un-chose
            acc.remove(acc.size() - 1);
            // add back temp, remove from the list and add back
            shit.add(i, temp);
        }
        return res;
    }

    private void printValid(String res) {
        System.out.println(res);
    }

    public static void main(String[] args) {
        new GoogleShit().largestTimeFromDigits(new int []{1,2,3, 4});
    }
    /*
 Base Case
str.length === 0
result.push(chosen)

Loop Over the String
get current
// Chose
chosen += current
// erase from the input
chosen = erase(str, chosen)
//Recursive, without the current
permute(chosen, str) string

// Crucial! I always forget this step, don't forget
// un-choose
- chosen = chosen.replace(current, '')
    */


}
