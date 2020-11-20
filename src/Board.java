package battleship;
import java.util.Scanner;
import java.lang.IllegalAccessError;
import java.lang.ArrayIndexOutOfBoundsException;
public class Board {
    
    private char[][] board = new char[10][10];
    private String[] positionNumber2 = new String[] 
        {"0","1","2","3","4","5","6","7","8","9"};
    private String[] positionNumber = new String[] 
        {"+","0","1","2","3","4","5","6","7","8","9"};
    private Scanner readKeys = new Scanner(System.in);
    private byte row, column;
    private char direction;
    
    public Board()
    {
        for(byte i = 0; i < board.length; i++)
        {
            for(byte j = 0; j < board.length; j++)
            {
                board[i][j] = '~';
            }
        }
    }
    
    public void ShowShootingBoard()
    {
        System.out.println("    American fleet last seen");
        System.out.println(" -------------------------------");
        for(byte i = 0; i < board.length; i++)
        {
            System.out.print(positionNumber2[i] + "  ");
            
            for(byte j = 0; j < board.length; j++)
            {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println("");
            if(i == 9)
            {
                for(byte k = 0; k < positionNumber.length; k++)
                {
                    System.out.print(positionNumber[k] + "  ");
                }
            }
        }
        System.out.println("\n --------------------------------");
    }
    
    public void ShowOwnFleet()
    {
        System.out.println("\n         Japanese Fleet");
        System.out.println(" -------------------------------");
        for(byte i = 0; i < board.length; i++)
        {
            System.out.print(positionNumber2[i] + "  ");
            
            for(byte j = 0; j < board.length; j++)
            {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println("");
            if(i == 9)
            {
                for(byte k = 0; k < positionNumber.length; k++)
                {
                    System.out.print(positionNumber[k] + "  ");
                }
            }
        }
        System.out.println("\n --------------------------------");
    }
    
    
    public void PlaceShip(char ship)
    {
        System.out.printf("%s Vertically(V) or Horizontally(H)?: ",ship);
        direction = readKeys.next().toUpperCase().charAt(0);
        
        System.out.println("Whitch row?");
        row = readKeys.nextByte();
        
        System.out.println("Whitch column?");
        column = readKeys.nextByte();
        
        byte limit = 0;
        byte lenght = 0;
        switch(ship)
        {
            case 'C': lenght = 5; break; //Carrier
            case 'B': lenght = 4; break; //Battleship
            case 'L': lenght = 3; break; //Light Cruiser
            case 'D': lenght = 3; break; //Destroyer
            case 'S': lenght = 2; break; //Submarine
        }
        
        switch(direction)
        {
            case 'V':
                limit = (byte) (row + lenght);
                try
                {
                    for(byte i = row; i < limit; i++)
                    {
                        if(board[i][column] != '~')
                            throw new IllegalAccessException("Illegal Move");
                        if(i > 10 || column > 10)
                            throw new ArrayIndexOutOfBoundsException("Array Index out of bounds.");
                    }
                }
                catch(IllegalAccessException iae)
                {
                    System.out.print("\n------------------------------------------\n");
                    System.out.println("ERROR, ILLEGAL MOVE:\n"
                            + "A ship cannot overlap another ship!\n"
                            + "Please choose another position: ");
                    System.out.print("------------------------------------------\n");
                    System.out.println("");
                    PlaceShip(ship);
                }
                catch(ArrayIndexOutOfBoundsException aioobe)
                {
                    System.out.print("\n------------------------------------------\n");
                    System.out.println("ERROR, ARRAY Index Out of Bounds:\n"
                            + "The selected ship is Out of Bounds.\n"
                            + "Please choose another position: ");
                    System.out.print("------------------------------------------\n");
                    System.out.println("");
                    PlaceShip(ship);
                }
                
                try //TEMPORARY SOLUTION
                {
                    limit = (byte) (row + lenght);
                    for(byte i = row; i < limit; i++)
                    {
                        System.out.println("Limit " + limit);
                        board[i][column] = ship;
                    }
                }
                finally
                {
                    ShowOwnFleet();
                } 
                    
                break;
                
            case 'H':
                limit = (byte) (column + lenght);
                try
                {
                    for(byte i = column; i < limit; i++)
                    {
                        if(board[row][i] != '~')
                            throw new IllegalAccessException("Illegal Move.");
                        if(i > 10 || row > 10)
                            throw new ArrayIndexOutOfBoundsException("Array Index out of bounds.");
                        board[row][i] = ship;
                    }
                }
                
                catch(IllegalAccessException iae)
                {
                    System.out.print("\n------------------------------------------\n");
                    System.out.println("ERROR, ILLEGAL MOVE:\n"
                            + "A ship cannot overlap another ship!\n"
                            + "Please choose another position: ");
                    System.out.print("------------------------------------------\n");
                    System.out.println("");
                    PlaceShip(ship);
                }
                catch(ArrayIndexOutOfBoundsException aioobe)
                {
                    System.out.print("\n------------------------------------------\n");
                    System.out.println("ERROR, ARRAY Index Out of Bounds:\n"
                            + "The selected ship is Out of Bounds.\n"
                            + "Please choose another position: ");
                    System.out.print("------------------------------------------\n");
                    System.out.println("");
                    PlaceShip(ship);
                }
                
                try //TEMPORARY SOLUTION
                {
                    for(byte i = column; i < limit; i++)
                    {
                        board[row][i] = ship;
                    }
                }
                
                finally
                {
                    ShowOwnFleet();
                } 
                break;
        }
    }
}
