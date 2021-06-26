package mustKnowJava;

import java.util.*;
import java.util.stream.Collectors;

public class Examples {
    public static void sortingPrimitives(int [][] matrix) {
        System.out.println("Primitive Matrix,COMPARING the first POS of the row/col, its a MATRIX!");
        //1
        Arrays.sort(matrix, (a, b) -> Integer.compare(a[0], b[0]));
        //2
        //Arrays.sort(matrix, Comparator.comparingInt(a -> a[0]));

        //Testing, should print 1 and 6
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][0]);
        }
    }

    public static void sortArrays() {
        // Object SIMPLE List
        List<Integer> myList = new ArrayList<>((Arrays.asList(5, 1, 2)));
        Collections.sort(myList, (a, b) -> Integer.compare(b, a));
    }

    public static void sortingObjects( List<List<Integer>> objMatrix) {

        //COMPARING the first POS of the row/col, its a MATRIX!
        Collections.sort(objMatrix, (a, b) -> Integer.compare(a.get(0), b.get(0)));
        System.out.println("Object Matrix");
        for (int i = 0; i < objMatrix.size(); i++) {
            System.out.println(objMatrix.get(i).get(0));
        }
    }

    public static void matrix( int [][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            int [] row = matrix[i];

            for (int j = 0; j < row.length; j++) {
                int value = row[j];
                System.out.print(value + " ");
            }
        }
    }

    public static int[] convertObjListToPrimitive(List<Integer> result) {
        return result.stream().mapToInt(i -> i).toArray();
    }
    public static List<Integer> convertArrayToCollection(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static Map<Integer, Integer> maps( Map<Integer,Integer> mapFreqs,
                                              Integer key, Integer defaultValue) {
        Integer val = mapFreqs.getOrDefault(key, defaultValue);
        if(val == 1) {
            mapFreqs.put(key, val + 1);
        }
        String res = "";
        for(Map.Entry entry : mapFreqs.entrySet()) {
            res += entry.getKey().toString() + entry.getValue().toString();
        }
        return mapFreqs;
    }

    public static String sortString(String inputString)
    {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);
        HashMap<String,Integer> map = new HashMap();

        // return new sorted string
        return new String(tempArray);
    }
}
