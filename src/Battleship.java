package battleship;

public class Battleship {
    public static void main(String[] args) {
        // 1 X Carrier (5) C
        // 1 X Battleship (4) B
        // 1 X Cruiser (3) L
        // 2 X Destroyers (3) D
        // 2 X Submarines (2) S
        char[] ships = new char[]
        {'C','B','L','D','D','S','S'};
        String[] shipNames = new String[]
        {"Shokaku","Yamato","Abukuma","Shimikaze","Asashio","I-166","I-129"};
        
        Board myFleet = new Board();
        Board shootingMap = new Board();
        
        //shootingMap.ShowShootingBoard();
        System.out.println("Atention! We found there is a big fleet\n"
                + "near the bay comming to us.\n"
                + "We request your knowledge to place our ships to attack them!");
        myFleet.ShowOwnFleet();
        
        for(byte i = 0; i < ships.length; i++)
        {
            char ship = ships[i];
            myFleet.PlaceShip(ship);
        }
    }
}
