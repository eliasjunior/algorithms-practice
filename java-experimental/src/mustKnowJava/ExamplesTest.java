package mustKnowJava;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ExamplesTest {

    @Test
    void sortingPrimitives() {
        int [][] matrix = new int[][]{{6,2}, {1,5}};
        Examples.sortingPrimitives(matrix);
    }

    @Test
    void sortingObjects() {
        List<Integer> row1 = new ArrayList<>((Arrays.asList(5, 1)));
        List<Integer> row2 = new ArrayList<>((Arrays.asList(3, 8)));
        List<Integer> row3 = new ArrayList<>((Arrays.asList(2, 3)));
        List<List<Integer>> objMatrix = new ArrayList<>();
        objMatrix.add(row1);
        objMatrix.add(row2);
        objMatrix.add(row3);

        Examples.sortingObjects(objMatrix);
    }

    @Test
    void matrix() {
        Examples.matrix( new int[][]{{1,2}, {3,5}});
    }

    @Test
    void convertObjListToPrimitive() {
        int [] arr = Examples.convertObjListToPrimitive( new ArrayList<>(Arrays.asList(1, 2, 3)));
        assertArrayEquals(new int[]{1,2,3}, arr);
    }

    @Test
    void convertArrayToCollection() {
        int [] arr = new int[]{1,2,3};

        List<Integer> toTest = Examples.convertArrayToCollection(arr);
        for (Integer i: toTest) {
            System.out.println(i);
        }
    }

    @Test
    void maps() {
        Map<Integer,Integer> mapFreqs = new HashMap<>();
        Map<Integer, Integer> map = Examples.maps(mapFreqs,2, 1);
        assertEquals(1, map.get(2));

        map = Examples.maps(map, 2, 1);

        assertEquals(2, map.get(2));
    }


    @Test
    void justRUn() {

        String [] strs = new String[]{"biba", "alias", "wido", "farmer"};

        Arrays.sort(strs);
        String prefix = strs[0];
        System.out.println( strs[1].indexOf(prefix));
    }


/*
[
[".",".","4", ".",".",".","6","3","."],
[".",".",".", ".",".",".",".",".","."],
["5",".",".", ".",".",".",".","9","."],

[".",".",".", "5","6",".", ".",".","."],
["4",".","3", ".",".",".", ".",".","1"],
[".",".",".", "7",".",".", ".",".","."],

[".",".",".", "5",".",".", ".",".","."],
[".",".",".", ".",".",".", ".",".","."],
[".",".",".", ".",".",".", ".",".","."]
]
 */
}