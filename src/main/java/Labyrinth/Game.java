package Labyrinth;

import java.util.Scanner;

public class Game {
    private Room currentRoom;

    public Game() {

        createRooms();
    }
    public class Area {



    }

    private void createRooms() {
        Room room1 = new Room("you can go south");
        Room room2 = new Room("you can go east");
        Room room3 = new Room("you can go south and west");
        Room room4 = new Room("you can go north and east");
        Room room5 = new Room("you can go east and west");
        Room room6 = new Room("you can go north and south");
        Room room7 = new Room("you can go east");
        Room room8 = new Room("you can go east and west");
        Room room9 = new Room("you can go north and west");

        room1.setExits(null, null, room4, null);
        room2.setExits(null, room3, null, null);
        room3.setExits(null, null, room6, room2);
        room4.setExits(room1, room5, null, null);
        room5.setExits(null, room6, null, room4);
        room6.setExits(room3, null, room9, room5);
        room7.setExits(null, room8, null, null);
        room8.setExits(null, room9, null, room7);
        room9.setExits(room6,null,null,room8);


        currentRoom = room1;

    }

    private void printWelcome() {
        System.out.println(currentRoom.getDescription());
    }

    private void printHelp() {
        System.out.println("You can move by typing 'go north', 'go south', 'go east', or 'go west'.");
    }

    private void goRoom(String direction) {
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("You can't go that way!");
        } else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getDescription());
        }
    }

    public void play() {

        Scanner scanner = new Scanner(System.in);
        printWelcome();

        boolean finished = false;


        while (!finished) {

            System.out.println(currentRoom);
            System.out.print("> ");
            String input = scanner.nextLine();

            //if(){}

            if (input.equalsIgnoreCase("quit")) {
                finished = true;
            } else if (input.equalsIgnoreCase("help")) {
                printHelp();
            } else if (input.startsWith("go ")) {
                String direction = input.substring(3);
                goRoom(direction);
            } else {
                System.out.println("I don't understand that command.");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
