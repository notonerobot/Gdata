//TestTestTest
package Labyrinth;
import java.util.*;


public class Main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
    public static final String BLUE_BACKGROUND = "\033[44m";
    public static final String GREEN_BACKGROUND = "\033[42m";
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";
    public static final String BLACK_BACKGROUND = "\033[40m";   // BLACK
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String RED_BACKGROUND = "\u001B[41m";    // RED
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED


    private static final Random random = new Random();
    private static final int sizex = 11; //nur ungerade zahlen (opt31)
    private static final int sizey = 11; //nur ungerade zahlen (opt61)
    private static final String WALL = BLACK_BACKGROUND + "   " + ANSI_RESET;
    private static final String PATH = GREEN_BACKGROUND + "   " + ANSI_RESET;


/*
    private final int sizex;
    private final int sizey;
    private final int[][] maze;
    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};

    public MazeGenerator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.maze = new int[rows][cols];
        generateMaze();
    }*/
/*
    public Main(int rows, int sizey, int[][] maze) {
        this.sizex = rows;
        this.sizey = sizey;
        this.maze = maze;
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
        if (x < 0 || x >= sizex || y < 0 || y >= sizey || maze[x][y] == 1) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < sizex && ny >= 0 && ny < sizey && maze[nx][ny] == 1) {
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
    */
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
                case 0: nx = x - 2; break; // Up
                case 1: nx = x + 2; break; // Down
                case 2: ny = y - 2; break; // Left
                case 3: ny = y + 2; break; // Right
            }

            if (isValidMove(maze, nx, ny)) {
                maze[(x + nx) / 2][(y + ny) / 2] = PATH;
                generateMaze(maze, nx, ny);
            }
        }
    }

    private static boolean isValidMove(String[][] maze, int x, int y) {
        return x > 0 && x < sizex - 1 && y > 0 && y < sizey- 1 && maze[x][y].equals(WALL);
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

    public static void main(String[] args){

        String[][] maze = new String[sizex][sizey];
        initializeMaze(maze);
        generateMaze(maze, 1, 1);


        int maxstep = 200000;

//        String[][] Maze = new String[sizex][sizey];

        //MazeGeneratortest mazeGenerator = new MazeGeneratortest(Maze, sizex, sizey);
        String avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "LoM" + ANSI_RESET;
        String exit =GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " []" + ANSI_RESET;
        String enemy = RED_BACKGROUND + BLACK_BOLD + "x-x" + ANSI_RESET;
        String preimput = null;
        //new MazeGenerator(sizex,sizey);
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

//        for(String[] r : Maze) {
//            for (int n = 0; n < sizex; n++) {
//                for (int m = 0; m < sizey; m++) {
//                    Maze[n][m] = WALL;
//                }
//            }
//        }
        int algox = random.nextInt(sizex);
        int algoy = random.nextInt(sizey);

//        //genarate path
//        for (int i = 0; i < 1000; i++) {
//            Maze[algox][algoy] = PATH;
//            int dirAl = random.nextInt(0, 4);
//            switch (dirAl) {
//                case 0 -> algox++;
//                case 1 -> algox--;
//                case 2 -> algoy++;
//                case 3 -> algoy--;
//                default -> System.out.println("unknown random");
//            }
//            if (algoy < 1){
//                System.out.println("out of bounds genaration");
//                algox =algox+2;
//            } else if (algoy > (sizey-2)) {
//                System.out.println("out of bounds genaration");
//                algoy = algoy-2;
//            } else if (algox < 1){
//                System.out.println("out of bounds genaration");
//                algox = algox+2;
//            } else if (algox > (sizex-2)) {
//                System.out.println("out of bounds genaration");
//                algox = algox-2;
//            }
//            Maze[algox][algoy] = PATH;
//        }

        int posx = random.nextInt(sizex); //player coordanates
        int posy = random.nextInt(sizey);

        int enx = random.nextInt(sizex); //enemy coordinates
        int eny = random.nextInt(sizey);

        int exx = random.nextInt(sizex); // exit coordinates
        int exy = random.nextInt(sizey);

        while (maze[posx][posy] == WALL){
            posx = random.nextInt(sizex);
            posy = random.nextInt(sizey);
        } // Player in wall reset
        while (maze[exx][exy] == WALL) {
            System.out.println("invalid positoned");
            exx = random.nextInt( sizex);
            exy = random.nextInt( sizey);
        } //exit in wall reset
        while (maze[enx][eny] == WALL){
            enx = random.nextInt(sizex);
            eny = random.nextInt(sizey);
        } // enemy in wall reset
        while (exx == posx && exy == posy){
            exx = random.nextInt( sizex);
            exy = random.nextInt( sizey);
        } // exit and player same position reset


        maze[enx][eny] = enemy; //place enemy
        maze[posx][posy] = avatar; //place player
        maze[exx][exy]=exit; //place exit


        for (int i = 0; i < sizex; i++) {
            for (int j = 0; j < sizey; j++)
                System.out.print(maze[i][j]);
            System.out.println();
        }
        //MazeGeneratortest.printMaze(Maze);
        //ersteinmahl das spielfeld anzeigen


        boolean finished = false;
        while(!finished) {

            //Bewegen
            System.out.println("  W");
            System.out.println("A S D");
            String direct = scanner.nextLine();
            maxstep--;
            maze[posx][posy] = GREEN_BACKGROUND_BRIGHT + "   " + ANSI_RESET; // empty prior "room"
            System.out.println("preimput: " + preimput);
            switch (direct) {
                case "W", "w": posx--; avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " ^ " + ANSI_RESET;preimput = direct; break;
                case "A", "a": posy--; avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " < " + ANSI_RESET;preimput = direct; break;
                case "S", "s": posx++; avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " v " + ANSI_RESET;preimput = direct; break;
                case "D", "d": posy++; avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " > " + ANSI_RESET;preimput = direct; break;
                case null, default: switch (preimput) {
                    case "W", "w": posx--; avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " ^ " + ANSI_RESET; break;
                    case "A", "a": posy--; avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " < " + ANSI_RESET; break;
                    case "S", "s": posx++; avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " v " + ANSI_RESET; break;
                    case "D", "d": posy++; avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " > " + ANSI_RESET; break;
                    case null, default: System.out.println( preimput+ " is an unknown input player");
                }
            }

            if (posy < 0){
                System.out.println("out of bounds player");
                posy++;
            } else if (posy > (sizey-1)) {
                System.out.println("out of bounds player");
                posy--;
            } else if (posx < 0){
                System.out.println("out of bounds player");
                posx++;
            } else if (posx > (sizex-1)) {
                System.out.println("out of bounds player");
                posx--;
            }

            //Hier die wand colision überprüfen
            if(maze[posx][posy] == WALL){
                System.out.println("das ne' wand player");
                switch (direct){
                    case "W", "w": posx++; break;
                    case "A", "a": posy++; break;
                    case "S", "s": posx--; break;
                    case "D", "d": posy--; break;
                    case null, default: switch (preimput) {
                        case "W", "w": posx++; avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " ^ " + ANSI_RESET; break;
                        case "A", "a": posy++; avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " < " + ANSI_RESET; break;
                        case "S", "s": posx--; avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " v " + ANSI_RESET; break;
                        case "D", "d": posy--; avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + " > " + ANSI_RESET; break;
                        case null, default: System.out.println( preimput+ " is an unknown input player");
                    }
                }
            }

            //position setzen
            maze[posx][posy] = avatar;

            //enemy movement
            maze[enx][eny] = PATH; // empty prior "room"



            int enmove;
            boolean works = false;
            if(posx>enx){
                enmove = 2;
            } else if (posx<enx){
                enmove = 0;
            } else if (posy>eny) {
                enmove = 3;
            } else if (posy<eny) {
                enmove = 1;
            } else {
                enmove = random.nextInt(4);
            }

            while(!works) {
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

            if(maze[exx][exy] != avatar) {
                // Printing the Array

//                for (int i = 0; i < sizex; i++) {
//                    for (int j = 0; j < sizey; j++)
//                        System.out.print(Maze[i][j]);
//                    System.out.println();
//                }
                printMaze(maze);
                //mazeGenerator.printMaze();
                System.out.println(maxstep);
            } else {
                finished  = true;
                // Printing the Array a last time

//                for (int i = 0; i < sizex; i++) {
//                    for (int j = 0; j < sizey; j++)
//                        System.out.print(Maze[i][j]);
//                    System.out.println();
//                }
                avatar = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "[v] " + ANSI_RESET;
                printMaze(maze);
                //ymazeGenerator.printMaze();
                System.out.println("Game Won!");
            }

            if(maxstep==0||maze[enx][eny]!=enemy) {
                finished = true;
                if(maze[exx][exy] != avatar) {
                    System.out.println("Game Over");
                }
            }
        }
    }
}