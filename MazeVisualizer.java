import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MazeVisualizer extends JPanel {
    private final int[][] mazeGrid; // Use the maze grid directly
    private final int cellSize;
    private int playerX, playerY; // Player position (red dot)

    public MazeVisualizer(Maze maze, int cellSize) {
        this.mazeGrid = maze.getMaze(); // Get the grid from the Maze object
        this.cellSize = cellSize;
        this.playerX = 0;
        this.playerY = 0;

        setPreferredSize(new Dimension(mazeGrid[0].length * cellSize, mazeGrid.length * cellSize));
        setFocusable(true);

        // Add key listener for manual movement
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                movePlayer(e.getKeyCode());
                repaint();
            }
        });
    }

    private void movePlayer(int keyCode) {
        int newX = playerX;
        int newY = playerY;

        switch (keyCode) {
            case KeyEvent.VK_UP -> newX--;
            case KeyEvent.VK_DOWN -> newX++;
            case KeyEvent.VK_LEFT -> newY--;
            case KeyEvent.VK_RIGHT -> newY++;
        }

        if (isValidMove(newX, newY)) {
            playerX = newX;
            playerY = newY;
        }
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && y >= 0 && x < mazeGrid.length && y < mazeGrid[0].length && mazeGrid[x][y] == 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the maze
        for (int i = 0; i < mazeGrid.length; i++) {
            for (int j = 0; j < mazeGrid[i].length; j++) {
                g.setColor(mazeGrid[i][j] == 1 ? Color.BLACK : Color.WHITE);
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                g.setColor(Color.GRAY);
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }

        // Draw the player
        g.setColor(Color.RED);
        g.fillOval(playerY * cellSize, playerX * cellSize, cellSize, cellSize);

        // Draw the goal
        g.setColor(Color.GREEN);
        g.fillOval((mazeGrid[0].length - 1) * cellSize, (mazeGrid.length - 1) * cellSize, cellSize, cellSize);
    }
}

