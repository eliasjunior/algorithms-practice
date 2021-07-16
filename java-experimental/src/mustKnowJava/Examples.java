package mustKnowJava;

import java.util.*;
import java.util.stream.Collectors;

public class Examples {
    // Fill with sentinel value representing not-calculated recursions.
    //Arrays.fill(this.memo, -1); memo is a primitive array int [100]

    public static void sortingPrimitives(int [][] matrix) {
        System.out.println("Primitive Matrix,COMPARING the first POS of the row/col, its a MATRIX!");
        //1
        Arrays.sort(matrix, (a, b) -> Integer.compare(b[0], a[0]));
        //2
      //  Arrays.sort(matrix, Comparator.comparingInt(a -> a[0]));

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

    public static Integer[] convertPrimitiveInteger(int[] arr) {
        return Arrays.stream(arr).boxed().toArray(Integer[]::new);
    }
    public static int[] convertIntegerToPrimitive(Integer[] newInt) {
        return Arrays.stream(newInt).mapToInt(value -> value.intValue()).toArray();
    }

    public static Map<Integer, Integer> maps( Map<Integer,Integer> mapFreqs,
                                              Integer key, Integer defaultValue) {
        Integer val = mapFreqs.getOrDefault(key, defaultValue);
        if(val == 1) {
            mapFreqs.put(key, val + 1);
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, Integer> entry : mapFreqs.entrySet()) {
           sb.append(entry.getKey() + entry.getValue());
        }
        return mapFreqs;
    }

    public static String reverseStr(String inputString)
    {
        // convert input string to char array
        // 1
        char tempArray [] = new StringBuilder(inputString).reverse().toString().toCharArray();
        for (int i = 0; i < tempArray.length; i++) {
            System.out.println(tempArray[i]);
        }

        // 2
        char temp2 [] = inputString.toCharArray();
        int j = inputString.length() - 1;
        for (int i = 0; i < j; i++) {
            char tmp = temp2[i];
            temp2[i] = temp2[j];
            temp2[j] = tmp;
        }
      //  return new String(tempArray);
        return new String(temp2);
    }

    public static int [] sortArrayDesc(int [] arr) {
        // A LOT OF work
        Integer [] newInt = convertPrimitiveInteger(arr);
        Arrays.sort(newInt, Collections.reverseOrder());
        return convertIntegerToPrimitive(newInt);
    }
}
