public class RotateImage {

    public int[][] rotateImage(int [][] matrix) {
        return rotate(matrix);
    }
    private int [][] rotate(int [][] matrix){
        //transpose
        matrix = swapColsRows(matrix, 1, 1);
        matrix = reverse(matrix, 0, matrix.length - 1);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

       return matrix;
    }
 // transpose -> exchange places
    private int[][] swapColsRows(int [][] matrix,
                                 int start,
                                 int colStart) {
        int size = matrix.length;
        if(start > size) {
            return matrix;
        }

        int j = colStart;
        int i = start;// row pos, never inc
        int rowFixedPos = i - 1;
        int colFixedPos = j - 1;
        while(j < size && i < size) {
            int temp = matrix[rowFixedPos][j]; //8
            matrix[rowFixedPos][j] = matrix[i][colFixedPos]; //6
            matrix[i][colFixedPos] = temp;
            j++;
            i++;
        }
        return swapColsRows(matrix, start + 1, colStart + 1);
    }

    private int[][] reverse(int [][] matrix, int colStart, int colEnd) {
        if(colStart >= colEnd) {
            return matrix;
        }
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][colStart];
            matrix[i][colStart] = matrix[i][colEnd];
            matrix[i][colEnd] = temp;
        }
        return reverse(matrix, colStart + 1, colEnd - 1);
    }

    // other soluction
    static class Solution2{
        public void rotate(int[][] matrix) {
            transpose(matrix);
            reflect(matrix);
            System.out.println("\nSolution 2");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        public void transpose(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                   // for diagonals is the same 0,0; 1,1; 2,2, so on and so forth, it replaces with it self
                    int tmp = matrix[j][i];
                    matrix[j][i] = matrix[i][j];
                    matrix[i][j] = tmp;
                }
            }
        }

        public void reflect(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = tmp;
                }
            }
        }
    }

    // end second solution

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);

        int [] [] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(matrix);

        matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16},
        };
      //  rotateImage.rotate(matrix);

        Solution2 solution2 = new Solution2();
        solution2.rotate(matrix);

    }
}
