import java.util.Random;

public class Maze {
    private final int rows;
    private final int cols;
    private final int[][] maze;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.maze = new int[rows][cols];
        generateMaze();
    }

    private void generateMaze() {
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = random.nextDouble() < 0.3 ? 1 : 0; // 30% chance of a wall
            }
        }
        maze[0][0] = 0; // Ensure start is a path
        maze[rows - 1][cols - 1] = 0; // Ensure end is a path
    }

    public int[][] getMaze() {
        return maze;
    }

    public boolean isWall(int x, int y) {
        return maze[x][y] == 1;
    }
}