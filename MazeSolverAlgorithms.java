

import java.util.LinkedList;
import java.util.Queue;

public class MazeSolverAlgorithms {
    private final int[][] maze;
    private final boolean[][] visited;

    public MazeSolverAlgorithms(int[][] maze) {
        this.maze = maze;
        this.visited = new boolean[maze.length][maze[0].length];
    }

    public boolean solveWithDFS(int x, int y) {
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == 1 || visited[x][y]) {
            return false;
        }
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            return true; // Reached the destination
        }

        visited[x][y] = true;

        // Explore all possible directions
        return solveWithDFS(x + 1, y) || solveWithDFS(x - 1, y) || solveWithDFS(x, y + 1) || solveWithDFS(x, y - 1);
    }

    public boolean solveWithBFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];

            if (x == maze.length - 1 && y == maze[0].length - 1) {
                return true; // Reached the goal
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isValidMove(newX, newY)) {
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }

        return false; // No solution found
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0 && !visited[x][y];
    }
}