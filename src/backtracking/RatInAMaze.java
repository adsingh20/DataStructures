package backtracking;

public class RatInAMaze {

    int n;
    boolean[][] maze = new boolean[n][n];
    boolean[][] solution = new boolean[n][n];

    boolean solveMaze() {
        if (!solveMazeRecursively(0, 0)) {
            return false;
        } else {
            System.out.println(solution);
            return true;
        }
    }

    boolean solveMazeRecursively(int i, int j) {
        if (i == n - 1 && j == n - 1) {
            solution[i][j] = true;
            return true;
        }

        if (isSafe(i, j)) {
            solution[i][j] = true;
            if (solveMazeRecursively( i + 1, j)) {
                return true;
            } else if (solveMazeRecursively( i, j + 1)) return true;
        }
        solution[i][j] = false;
        return false;
    }

    boolean isSafe(int i, int j) {
        return (i < n && j < n && maze[i][j]);
    }
}
