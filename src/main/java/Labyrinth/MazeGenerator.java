package Labyrinth;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class MazeGenerator {
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";
    public static final String BLACK_BACKGROUND = "\033[40m";   // BLACK
    public static final String ANSI_RESET = "\u001B[0m";
    private final int rows;
    private final int cols;
    private final int[][] maze;
    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};

    public MazeGenerator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.maze = new int[rows][cols];
        generateMaze();
    }

    private void generateMaze() {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, 0});
        maze[0][0] = 1;

        while (!stack.isEmpty()) {
            int[] current = stack.peek();
            int x = current[0];
            int y = current[1];

            Integer[] directions = {0, 1, 2, 3};
            Collections.shuffle(Arrays.asList(directions));

            boolean moved = false;
            for (int direction : directions) {
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                if (isValidMove(nx, ny)) {
                    maze[nx][ny] = 1;
                    stack.push(new int[]{nx, ny});
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                stack.pop();
            }
        }
    }

    private boolean isValidMove(int x, int y) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || maze[x][y] == 1) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && maze[nx][ny] == 1) {
                count++;
            }
        }
        return count <= 1;
    }

    public void printMaze() {
        for (int[] row : maze) {
            for (int cell : row) {
                System.out.print(cell == 1 ? WHITE_BACKGROUND_BRIGHT + "   " + ANSI_RESET : BLACK_BACKGROUND + "   " + ANSI_RESET);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MazeGenerator mazeGenerator = new MazeGenerator(20, 50);
        mazeGenerator.printMaze();
    }
}