package Labyrinth;

public class Room {
    private String description;
    private Room north;
    private Room east;
    private Room south;
    private Room west;

    public Room(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setExits(Room north, Room east, Room south, Room west) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
    }

    public Room getExit(String direction) {
        switch (direction.toLowerCase()) {
            case "north": return north;
            case "east": return east;
            case "south": return south;
            case "west": return west;
            default: return null;
        }
    }
}
