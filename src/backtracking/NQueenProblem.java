package backtracking;

public class NQueenProblem {

    int numberOfQueens;
    boolean [][] solutionBoard = new boolean[numberOfQueens][numberOfQueens];

    boolean solve() {
        if
    }

    boolean solveRecursively(int column) {
        if (column == numberOfQueens) {
            return true;
        }

        for (int i = 0; i < numberOfQueens; i++) {
            if (isSafe(i, numberOfQueens)) {
                solutionBoard[i][numberOfQueens] = true;
                if (solveRecursively(column + 1)) {
                    return true;
                }
                solutionBoard[i][numberOfQueens] = false;
            }
        }
        return false;
    }

    boolean isSafe(int row, int column) {

        // Check presence of queen in the row
        for (int i = 0; i < column; i++) {
            if (solutionBoard[row][i]) {
                return false;
            }
        }

        /* Check upper left and lower left diagonal only
        / We dont check lower right and upper right because they have not been
        / traversed yet because we traverse through columns */

        // Check upper left diagonal
        for (int i = row, j = column; i >= 0 && j >= 0 ; i--, j--) {
            if (solutionBoard[i][j]) {
                return false;
            }
        }

        // Check lower left diagonal
        for (int i = row, j = column; i < numberOfQueens && j >= 0 ; i++, j--) {
            if (solutionBoard[i][j]) {
                return false;
            }
        }

        return true;
    }
}
