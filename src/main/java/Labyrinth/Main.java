package Labyrinth;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.Random;


public class Main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
    public static final String BLUE_BACKGROUND = "\033[44m";
    public static final String BLACK_BACKGROUND = "\033[40m";   // BLACK
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";
    public static final String GREEN_BACKGROUND = "\033[42m";





    public static void main(String[] args){

        int sizex = 20;
        int sizey = 50;
        int maxstep = 200000;
        String wall = BLACK_BACKGROUND + "   " + ANSI_RESET;
        String avatar = BLUE_BACKGROUND + ANSI_WHITE + "LoM" + ANSI_RESET;
        String space = WHITE_BACKGROUND_BRIGHT + "   " + ANSI_RESET;
        String exit =WHITE_BACKGROUND_BRIGHT + ANSI_GREEN + " []" + ANSI_RESET;


        Scanner scanner = new Scanner(System.in);
        String[][] Maze = new String[sizex][sizey];
        Random random = new Random();

        for(String[] r : Maze) {
            for (int n = 0; n < sizex; n++) {
                for (int m = 0; m < sizey; m++) {
                    Maze[n][m] = wall;

                }
            }
        }
        int algox = random.nextInt(sizex);
        int algoy = random.nextInt(sizey);

        //genarate path
        for (int i = 0; i < 1000; i++) {
            Maze[algox][algoy] = space;
            int dirAl = random.nextInt(0, 4);
            switch (dirAl) {
                case 0 -> algox++;
                case 1 -> algox--;
                case 2 -> algoy++;
                case 3 -> algoy--;
                default -> System.out.println("unknown random");
            }
            if (algoy < 1){
                System.out.println("out of bounds genaration");
                algox =algox+2;
            } else if (algoy > (sizey-2)) {
                System.out.println("out of bounds genaration");
                algoy = algoy-2;
            } else if (algox < 1){
                System.out.println("out of bounds genaration");
                algox = algox+2;
            } else if (algox > (sizex-2)) {
                System.out.println("out of bounds genaration");
                algox = algox-2;
            }
            Maze[algox][algoy] = space;
        }

        int posx = random.nextInt(sizex);
        int posy = random.nextInt(sizey);

        while (Maze[posx][posy] == wall){
            posx = random.nextInt(sizex);
            posy = random.nextInt(sizey);
        }
        Maze[posx][posy] = avatar;

        int exx = random.nextInt(sizex);
        int exy = random.nextInt(sizey);

        while (exx == posx && exy == posy||Maze[exx][exy] == wall) {
            System.out.println("invalid positoned");
            exx = random.nextInt( sizex);
            exy = random.nextInt( sizey);
        }
        Maze[exx][exy]=exit;


        for (int i = 0; i < sizex; i++) {
            for (int j = 0; j < sizey; j++)
                System.out.print(Maze[i][j]);
            System.out.println();
        } //ersteinmahl das spielfeld anzeigen


        boolean finished = false;
        while(!finished) {
            //Bewegen
            System.out.println("  W");
            System.out.println("A S D");
            String direct = scanner.nextLine();
            maxstep--;

            Maze[posx][posy] = BLUE_BACKGROUND + "   " + ANSI_RESET; // empty prior "room"

            switch (direct) {
                case "W", "w": posx--; avatar = BLUE_BACKGROUND + ANSI_WHITE + " ^ " + ANSI_RESET; break;
                case "A", "a": posy--; avatar = BLUE_BACKGROUND + ANSI_WHITE + " < " + ANSI_RESET; break;
                case "S", "s": posx++; avatar = BLUE_BACKGROUND + ANSI_WHITE + " v " + ANSI_RESET; break;
                case "D", "d": posy++; avatar = BLUE_BACKGROUND + ANSI_WHITE + " > " + ANSI_RESET; break;
                case null, default: System.out.println("unknown input");
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
            if(Maze[posx][posy] == wall){
                System.out.println("das ne' wand");
                switch (direct){
                    case "W", "w" -> posx++;
                    case "A", "a" -> posy++;
                    case "S", "s" -> posx--;
                    case "D", "d" -> posy--;
                    case null, default -> System.out.println("unknown input");
                }
            }


            //position setzen
            Maze[posx][posy] = avatar;

            //spielfeld ausgeben

            if(Maze[exx][exy] != avatar) {
                // Printing the Array
                for (int i = 0; i < sizex; i++) {
                    for (int j = 0; j < sizey; j++)
                        System.out.print(Maze[i][j]);
                    System.out.println();
                }
                System.out.println(maxstep);
            } else {
                finished  = true;
                // Printing the Array a last time

                for (int i = 0; i < sizex; i++) {
                    for (int j = 0; j < sizey; j++)
                        System.out.print(Maze[i][j]);
                    System.out.println();
                }
                System.out.println("Game Won!");
            }

            if(maxstep==0) {
                finished = true;
                if(Maze[exx][exy] != avatar) {
                    System.out.println("Game Over");
                }
            }
        }
    }
}