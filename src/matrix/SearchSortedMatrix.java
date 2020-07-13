package matrix;

import javafx.util.Pair;

public class SearchSortedMatrix {

    private static Pair<Integer, Integer> search(int[][] matrix, int searchNumber, int rows, int cols) {
        Pair<Integer, Integer> indices;
        if (searchNumber < matrix[0][0])
            return new Pair<>(-1, -1);
        if (searchNumber > matrix[rows - 1][cols - 1])
            return new Pair<>(-1, -1);
        int rowIndex = 0, colIndex = cols - 1;
        while (rowIndex < rows && colIndex >= 0) {
            if (matrix[rowIndex][colIndex] == searchNumber) {
                return new Pair<>(rowIndex, colIndex);
            } else if (matrix[rowIndex][colIndex] > searchNumber){
                colIndex--;
            } else {
                rowIndex++;
            }
        }
        return new Pair<>(-1, -1);
    }

    public static void main(String[] args) {
        int[][] matrix = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
        System.out.println(search(matrix,29, 4, 4));
        System.out.println(search(matrix,50, 4, 4));
        System.out.println(search(matrix,22, 4, 4));
        System.out.println(search(matrix,70, 4, 4));
    }
}
