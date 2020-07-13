package matrix;

public class PrintMatrix {

    private static void printSnakePattern(int[][] matrix) {
        int rows = matrix.length;
        int cols;
        for (int i = 0; i < rows; i++) {
            cols = matrix[i].length;
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    System.out.println(matrix[i][j]);
                }
            } else {
                for (int j = cols - 1; j >= 0; j--) {
                    System.out.println(matrix[i][j]);
                }
            }
        }
    }

    private static void printBoundedElements(int[][] matrix, int rows, int columns) {
        if (rows == 1) {
            for (int j = 0; j < columns; j++) {
                System.out.println(matrix[0][j]);
            }
        }
        else if (columns == 1) {
            for (int j = 0; j < columns; j++) {
                System.out.println(matrix[j][0]);
            }
        } else {
            for (int j = 0; j < columns; j++) {
                System.out.println(matrix[0][j]);
            }
            for (int j = 1; j < rows; j++) {
                System.out.println(matrix[j][columns - 1]);
            }
            for (int j = columns - 2; j >= 0; j--) {
                System.out.println(matrix[rows - 1][j]);
            }
            for (int j = rows - 2; j >= 1; j--) {
                System.out.println(matrix[j][0]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printSnakePattern(matrix);
        printBoundedElements(matrix, 4, 4);
    }
}
