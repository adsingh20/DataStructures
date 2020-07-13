package matrix;

import java.util.Arrays;

public class SpiralTraversal {

    private static void rotateMatrixBy90(int[][] matrix, int rows, int cols) {
        int top = 0, left = 0, bottom = rows - 1, right = cols - 1;
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) {
                System.out.println(matrix[top][j]);
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                System.out.println(matrix[j][right]);
            }
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    System.out.println(matrix[bottom][j]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int j = bottom; j >= top; j--) {
                    System.out.println(matrix[j][left]);
                }
                left++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateMatrixBy90(matrix, 4, 4);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
