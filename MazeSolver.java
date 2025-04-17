import javax.swing.*;

public class MazeSolver {
    public static void main(String[] args) {
        int rows = 20, cols = 20, cellSize = 30;

        // Generate the maze
        Maze maze = new Maze(rows, cols);

        // Create the visualization window
        JFrame frame = new JFrame("Maze Solver");
        MazeVisualizer visualizer = new MazeVisualizer(maze, cellSize);

        frame.add(visualizer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Request focus for the visualizer to capture keyboard input
        SwingUtilities.invokeLater(() -> visualizer.requestFocusInWindow());
    }
}