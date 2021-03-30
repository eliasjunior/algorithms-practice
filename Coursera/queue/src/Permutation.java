import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {
    //private String list [] = new String[8];

    public static void main(String[] args) {
        RandomizedQueue<String> rQueue = new RandomizedQueue<>();
        int k = Integer.parseInt(args[0]);

        int n = 0;
       // String res;
        StringBuilder builder = new StringBuilder();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
          //  StdOut.println("-->" + str);
            builder.append(str);
          //  permutation.list[n] = str;
            n++;
        }
        //StdOut.println("Result " + builder.toString());
        for (int i = 0; i < k; i++) {
            int num =  StdRandom.uniform(n);
            StdOut.println(builder.toString().charAt(num));
        }
    }
//    private void resize(int capacity) {
//        String [] copy = new String[capacity];
//
//        for (int i = 0; i < list.length; i++) {
//          //  StdOut.println( list[i]);
//            copy[i] = list[i];
//        }
//        list = copy;
//    }
}
