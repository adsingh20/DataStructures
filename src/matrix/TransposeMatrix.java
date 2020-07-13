package matrix;

import java.util.Arrays;

public class TransposeMatrix {

    public static void transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols;
        int temp;
        for (int i = 0; i < rows; i++) {
            cols = matrix[i].length;
            for (int j = i + 1; j < cols; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        transposeMatrix(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
