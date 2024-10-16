import java.util.Scanner;

public class gomokuGame {
    public static void main(String[] args) {
        // Present the board itself
        int[][] mTable = new int[10][10];
        boolean displayTable = true;

        while (displayTable){
            for (int row = 0; row < mTable.length; row++) {
                System.out.print(row + " | ");
                for (int col = 0; col < mTable[row].length; col++) {
                    System.out.print(mTable[row][col] + " ");
                }
                System.out.print("\n");
            }

            System.out.println("  +---------------------");
            
            System.out.print("    ");
            
            for (int row = 0; row < 10; row++) {
                System.out.print(row + " ");
            }

            displayTable = false;
        }

        // Output whose turn is it
        boolean isPlayer1turn = true;
        if (isPlayer1turn) {
            System.out.println("\nPlayer 1's turn.");
            isPlayer1turn = false;
        } else {
            System.out.println("\nPlayer 2's turn.");
            isPlayer1turn = true;
        }

        // Gathering player input
        Scanner playerInput = new Scanner(System.in);
        System.out.print("Enter row and column (e.g., 0 1): ");
        //
        playerInput.close();
    }
}
