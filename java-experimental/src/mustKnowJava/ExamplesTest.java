package mustKnowJava;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExamplesTest {

    @Test
    void sortingPrimitives() {
        int [][] matrix = new int[][]{{6,2}, {1,5}};
        Examples.sortingPrimitives(matrix);


    }

    @Test
    void sortingObjects() {
        // Object Simple List
        List<Integer> myList = new ArrayList<>((Arrays.asList(5, 1, 2)));
        Collections.sort(myList);

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
}