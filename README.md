# -Maze-Generator
This is a simple Java-based Maze Solver application that generates a random maze, allows manual traversal using arrow keys, and provides automatic solving using algorithms like DFS and BFS.
This is a simple Java-based Maze Solver application that generates a random maze, allows manual traversal using arrow keys, and provides automatic solving using algorithms like DFS and BFS.

Features
Maze Generation: Randomly generates a maze with walls and paths.
Manual Traversal: Navigate through the maze using arrow keys (red dot represents the player).
Goal: The green dot marks the destination in the maze.
Automatic Solving: Implements Depth-First Search (DFS) and Breadth-First Search (BFS) algorithms to solve the maze programmatically.
Requirements
Java Development Kit (JDK) 8 or later.
Any IDE supporting Java (e.g., IntelliJ IDEA, Eclipse, VS Code) or command-line tools.
Project Structure
MazeSolverProject/
├── src/
│   ├── MazeSolver.java            # Main entry point
│   ├── Maze.java                  # Maze generation logic
│   ├── MazeVisualizer.java        # Handles graphical rendering and user interaction
│   ├── MazeSolverAlgorithms.java  # Implements BFS and DFS for automatic solving
│   ├── README.md 
How to Run the Project
Using an IDE
Clone or download the repository to your local machine.
Open the project in your favorite IDE.
Mark the src folder as the source root (if required).
Run the MazeSolver.java file.
Using Command Line
Navigate to the project directory:
cd MazeSolverProject/src
Compile the project:
javac *.java
Run the project:
java MazeSolver
Controls
Arrow Keys: Use to move the red dot (player) in the maze.
Objective: Reach the green dot (destination).
Algorithms
Depth-First Search (DFS)
A recursive backtracking algorithm that explores all possible paths until the goal is reached or no further path exists.
Breadth-First Search (BFS)
An iterative algorithm that explores all nodes at the present depth level before moving deeper.
