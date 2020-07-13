package matrix;

import java.util.Arrays;

public class RotateMatrix {

    private static void rotateMatrixBy90(int[][] matrix) {
        TransposeMatrix.transposeMatrix(matrix);
        int rows = matrix.length;
        for (int i = 0; i < matrix.length; i++){
            int[] temp = matrix[i];
            matrix[i] = matrix[rows-i-1];
            matrix[rows-i-1] = temp;
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateMatrixBy90(matrix);
    }
}
