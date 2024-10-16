public class gomokuGame {
    public static void main(String[] args) {
        // Present the board itself
        int[][] mTable = new int[10][10];
        
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
        
    }
}
