package Labyrinth;//TestTestTest

import java.sql.SQLOutput;
import java.util.*;
public class LabyrinthGame {
    public static final String GREEN_BACKGROUND = "\033[42m";

    public static final String BLACK_BACKGROUND = "\033[40m";   // BLACK
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String RED_BACKGROUND = "\u001B[41m";    // RED

    private static final Random random = new Random();
    private static final int sizex = 11; //nur ungerade zahlen (opt31)
    private static final int sizey = 11; //nur ungerade zahlen (opt61)
    private static final String WALL = BLACK_BACKGROUND + "   " + ANSI_RESET;
    private static final String PATH = GREEN_BACKGROUND + "   " + ANSI_RESET;
    private static String avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "LoM" + ANSI_RESET;
    Point start = new Point(2, 2, null);
    Point finish = new Point(4, 3, null);

    static class Point {

        int x, y;
        Point parent;

        Point(int x, int y, Point parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }


    }

    private static boolean isValidMove(String[][] maze, int x, int y) {
        return x > 0 && x < sizex - 1 && y > 0 && y < sizey - 1 && maze[x][y].equals(WALL);
    }

    private static void shuffleArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    private static void printMaze(String[][] maze) {
        for (int i = 0; i < sizex; i++) {
            for (int j = 0; j < sizey; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    private static void initializeMaze(String[][] maze) {
        for (int i = 0; i < sizex; i++) {
            for (int j = 0; j < sizey; j++) {
                maze[i][j] = WALL;
            }
        }
    }

    private static void generateMaze(String[][] maze, int x, int y) {
        maze[x][y] = PATH;
        int[] directions = {0, 1, 2, 3};
        shuffleArray(directions);

        for (int direction : directions) {
            int nx = x, ny = y;
            switch (direction) {
                case 0:
                    nx = x - 2;
                    break; // Up
                case 1:
                    nx = x + 2;
                    break; // Down
                case 2:
                    ny = y - 2;
                    break; // Left
                case 3:
                    ny = y + 2;
                    break; // Right
            }

            if (isValidMove(maze, nx, ny)) {
                maze[(x + nx) / 2][(y + ny) / 2] = PATH;
                generateMaze(maze, nx, ny);
            }
        }
    }

    public static String PlMovement(String[][] maze, int posx, int posy, int maxstep, String preimput){
        Scanner scanner = new Scanner(System.in);

        int preposx = posx;

        //Bewegen
        System.out.println("  W");
        System.out.println("A S D");
        String direct = scanner.nextLine();
        maxstep--;

        maze[posx][posy] = GREEN_BACKGROUND_BRIGHT + "   " + ANSI_RESET; // empty prior "room"
        System.out.println("preimput: " + preimput);
        switch (direct) {
            case "W", "w":
                posx--;
                avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " ^ " + ANSI_RESET;
                preimput = direct;
                break;
            case "A", "a":
                posy--;
                avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " < " + ANSI_RESET;
                preimput = direct;
                break;
            case "S", "s":
                posx++;
                avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " v " + ANSI_RESET;
                preimput = direct;
                break;
            case "D", "d":
                posy++;
                avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " > " + ANSI_RESET;
                preimput = direct;
                break;
            case null, default:
                switch (preimput) {
                    case "W", "w":
                        posx--;
                        avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " ^ " + ANSI_RESET;
                        break;
                    case "A", "a":
                        posy--;
                        avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " < " + ANSI_RESET;
                        break;
                    case "S", "s":
                        posx++;
                        avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " v " + ANSI_RESET;
                        break;
                    case "D", "d":
                        posy++;
                        avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " > " + ANSI_RESET;
                        break;
                    case null, default:
                        System.out.println(preimput + " is an unknown input player");
                }
        }

        if (posy < 0) {
            System.out.println("out of bounds player");
            posy++;
        } else if (posy > (sizey - 1)) {
            System.out.println("out of bounds player");
            posy--;
        } else if (posx < 0) {
            System.out.println("out of bounds player");
            posx++;
        } else if (posx > (sizex - 1)) {
            System.out.println("out of bounds player");
            posx--;
        }

        //Hier die wand colision überprüfen
        if (maze[posx][posy] == WALL) {
            System.out.println("das ne' wand player");
            switch (direct) {
                case "W", "w":
                    posx++;
                    break;
                case "A", "a":
                    posy++;
                    break;
                case "S", "s":
                    posx--;
                    break;
                case "D", "d":
                    posy--;
                    break;
                case null, default:
                    switch (preimput) {
                        case "W", "w":
                            posx++;
                            avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " ^ " + ANSI_RESET;
                            break;
                        case "A", "a":
                            posy++;
                            avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " < " + ANSI_RESET;
                            break;
                        case "S", "s":
                            posx--;
                            avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " v " + ANSI_RESET;
                            break;
                        case "D", "d":
                            posy--;
                            avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " > " + ANSI_RESET;
                            break;
                        case null, default:
                            System.out.println(preimput + " is an unknown input player");
                    }
            }
        }
        return maze[posx][posy];
    }

/*
    private static List<Point> constructPath(Point finish) {
        List<Point> path = new ArrayList<>();
        for (Point p = finish; p != null; p = p.parent) {
            path.add(p);
        }
        Collections.reverse(path);
        return path;
    }

    private static boolean isValidMove(String[][] grid, int x, int y, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length &&
                !grid[x][y].equals("#") && !visited[x][y];
    }

    public static List<Point> findPath(String[][] grid, Point start, Point finish) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.x][start.y] = true;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == finish.x && current.y == finish.y) {
                return constructPath(current);
            }

            for (int[] direction : directions) {
                int newX = current.x + direction[0];
                int newY = current.y + direction[1];

                if (isValidMove(grid, newX, newY, visited)) {
                    queue.add(new Point(newX, newY, current));
                    visited[newX][newY] = true;
                }
            }
        }
        return null;
    }
*/
public static void main(String[] args) {

    String[][] maze = new String[sizex][sizey];
    initializeMaze(maze);
    generateMaze(maze, 1, 1);


    int maxstep = 200000;


    //MazeGeneratortest mazeGenerator = new MazeGeneratortest(Maze, sizex, sizey);
    String exit = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " []" + ANSI_RESET;
    String enemy = RED_BACKGROUND + BLACK_BOLD + "x-x" + ANSI_RESET;
    String preimput = null;
    //new MazeGenerator(sizex,sizey);
    Random random = new Random();


    int algox = random.nextInt(sizex);
    int algoy = random.nextInt(sizey);


    int posx = random.nextInt(sizex); //player coordanates
    int posy = random.nextInt(sizey);
    int preposx = posx;
    int preposy = posy;

    int enx = random.nextInt(sizex); //enemy coordinates
    int eny = random.nextInt(sizey);

    int exx = random.nextInt(sizex); // exit coordinates
    int exy = random.nextInt(sizey);

    while (maze[posx][posy] == WALL) {
        posx = random.nextInt(sizex);
        posy = random.nextInt(sizey);
    } // Player in wall reset
    while (maze[exx][exy] == WALL) {
        System.out.println("invalid positoned");
        exx = random.nextInt(sizex);
        exy = random.nextInt(sizey);
    } //exit in wall reset
    while (maze[enx][eny] == WALL) {
        enx = random.nextInt(sizex);
        eny = random.nextInt(sizey);
    } // enemy in wall reset
    while (exx == posx && exy == posy) {
        exx = random.nextInt(sizex);
        exy = random.nextInt(sizey);
    } // exit and player same position reset


    maze[enx][eny] = enemy; //place enemy
    maze[posx][posy] = avatar; //place player
    maze[exx][exy] = exit; //place exit


    for (int i = 0; i < sizex; i++) {
        for (int j = 0; j < sizey; j++)
            System.out.print(maze[i][j]);
        System.out.println();
    }


    boolean finished = false;
    while (!finished) {
        System.out.println("erst" + posx + " und " + posy);
        System.out.println(PlMovement(maze, posx, posy, maxstep, preimput));
        System.out.println("dann" + posx + " und " + posy);
        //enemy movement
        //position setzen
        maze[enx][eny] = PATH; // empty prior "room"


        int enmove;
        boolean works = false;
        if (posx > enx) { //spieler unter Gegner
            enmove = 2;
        } else if (posx < enx) { //spieler über Gegner
            enmove = 0;
        } else if (posy > eny) { //spieler likns von gegner
            enmove = 3;
        } else if (posy < eny) { //spieler rechts von gegner
            enmove = 1;
        } else {
            enmove = random.nextInt(4);
        }

        while (!works) {
            switch (enmove) {
                case 0 -> enx--;
                case 1 -> eny--;
                case 2 -> enx++;
                case 3 -> eny++;
                default -> System.out.println("Mein fehler enemy");
            }

            if (maze[enx][eny] == WALL) {
                System.out.println("das ne' wand enemy");
                switch (enmove) {
                    case 0 -> enx++;
                    case 1 -> eny++;
                    case 2 -> enx--;
                    case 3 -> eny--;
                    default -> System.out.println("Mein fehler enemy");
                }
                enmove = random.nextInt(4);
            } else {
                works = true;
            }
        }
        maze[enx][eny] = enemy;

        //spielfeld ausgeben

        if (maze[exx][exy] != maze[posx][posy]) {
            // Printing the Array

            printMaze(maze);
            //mazeGenerator.printMaze();
            System.out.println(maxstep);
        } else {
            finished = true;
            // Printing the Array a last time

            avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "[v] " + ANSI_RESET;
            printMaze(maze);
            //ymazeGenerator.printMaze();
            System.out.println("Game Won!");
        }
        System.out.println(maze[posx][posy]);
        if (maxstep == 0 || maze[posx][posy] == maze[enx][eny]) {
            finished = true;
            if (maze[exx][exy] != avatar) {
                System.out.println("Game Over");
            }
        }
    }
}

}
