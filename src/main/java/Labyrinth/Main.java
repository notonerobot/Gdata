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



    public static void main(String[] args){

        int sizex = 10;
        int sizey = 10;
        int maxstep = 200000;
        String avatar = ANSI_GREEN + "LoM" + ANSI_RESET;
        String wall = WHITE_BACKGROUND + "   " + ANSI_RESET;
        String space = ANSI_WHITE + "   " + ANSI_RESET;
        String exit =ANSI_GREEN + " []" + ANSI_RESET;


        Scanner scanner = new Scanner(System.in);
        String[][] arr = new String[sizex][sizey];
        Random random = new Random();
        Random rando = new Random();

        for(String[] r : arr) {
            int rand = 0;
            //System.out.println(rand);
            for (int n = 0; n < sizex; n++) {
                for (int m = 0; m < sizey; m++) {
                    /*rand = rando.nextInt(0,2);
                    if (rand == 1) {
                        arr[n][m] = wall;
                    } else {
                        arr[n][m] = space;
                    }*/
                    arr[n][m] = wall;
                    //sSystem.out.println(rand);
                }
            }
        }
        int algox = random.nextInt(sizex);
        int algoy = random.nextInt(sizey);

        //genarate path
        for (int i = 0; i < 50; i++) {
            arr[algox][algoy] = space;
            int dirAl = random.nextInt(0, 4);
            switch (dirAl) {
                case 0 -> algox++;
                case 1 -> algox--;
                case 2 -> algoy++;
                case 3 -> algoy--;
                default -> System.out.println("Geht nicht");
            }
            if (algoy < 0){
                System.out.println("das geht nicht");
                algoy++;
            } else if (algoy > (sizey-1)) {
                System.out.println("das geht nicht");
                algoy--;
            } else if (algox < 0){
                System.out.println("das geht nicht");
                algox++;
            } else if (algox > (sizex-1)) {
                System.out.println("das geht nicht");
                algox--;
            }
            arr[algox][algoy] = space;
        }

        /*
        for (int o = 0; o < sizex; o++) {
            for (int u = 0; u < sizey; u++) {

            }

        }
        */





        int posx = random.nextInt(sizex);
        int posy = random.nextInt(sizey);
        arr[posx][posy] = avatar;

        int exx = random.nextInt(sizex);
        int exy = random.nextInt(sizey);

        while (exx == posx && exy == posy) {
            System.out.println("war auf PL");
            exx = random.nextInt( sizex);
            exy = random.nextInt( sizey);
        }
        arr[exx][exy]=exit;


        for (int i = 0; i < sizex; i++) {
            for (int j = 0; j < sizey; j++)
                System.out.print(arr[i][j]);
            System.out.println();
        } //ersteinmahl das spielfeld anzeigen


        boolean finished = false;
        while(!finished) {
            //Bewegen
            System.out.println("  W");
            System.out.println("A S D");
            String direct = scanner.nextLine();
            maxstep--;

            arr[posx][posy] = space; // empty prior "room"

            switch (direct) {
                case "S", "s" -> posx++;
                case "A", "a" -> posy--;
                case "W", "w" -> posx--;
                case "D", "d" -> posy++;
                case null, default -> System.out.println("Geht nicht");
            }
            if (posy < 0){
                System.out.println("das geht nicht");
                posy++;
            } else if (posy > (sizey-1)) {
                System.out.println("das geht nicht");
                posy--;
            } else if (posx < 0){
                System.out.println("das geht nicht");
                posx++;
            } else if (posx > (sizex-1)) {
                System.out.println("das geht nicht");
                posx--;
            }

            //Hier die wand colision überprüfen
            if(arr[posx][posy] == wall){
                System.out.println("das ne' wand");
                switch (direct){
                    case "S", "s" -> posx--;
                    case "A", "a" -> posy++;
                    case "W", "w" -> posx++;
                    case "D", "d" -> posy--;
                    case null, default -> System.out.println("Geht nicht");
                }
            }


            //position setzen
            arr[posx][posy] = avatar;

            //spielfeld ausgeben

            if(arr[exx][exy] != avatar) {
                // Printing the Array
                for (int i = 0; i < sizex; i++) {
                    for (int j = 0; j < sizey; j++)
                        System.out.print(arr[i][j]);
                    System.out.println();
                }
                System.out.println(maxstep);
            } else {
                finished  = true;
                // Printing the Array a last time
                for (int i = 0; i < sizex; i++) {
                    for (int j = 0; j < sizey; j++)
                        System.out.print(arr[i][j]);
                    System.out.println();
                }
                System.out.println("Game Won!");
            }

            if(maxstep==0) {
                finished = true;
                if(arr[exx][exy] != avatar) {
                    System.out.println("Game Over");
                }
            }
        }
    }
}