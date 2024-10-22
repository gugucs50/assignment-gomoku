import java.util.Scanner;

public class gomokuGame {
    public static void main(String[] args) {
        int[][] board = new int[10][10];
        boolean inGame = true;
        boolean displayTable = true;
        boolean inputting = true;
        boolean isPlayer1turn = true;
        boolean isPlayer2 = false;
        boolean playing = true;
        int row = 0, col = 0;
        Scanner playerInput = new Scanner(System.in);
        
        while (inGame) {        
            // Present the board itself
            if (displayTable){
                printBoard(board, row, col);
                inputting = true;
                displayTable = false;
            }
            
            // Output whose turn is it
            if (playing) {
                if (checkWin(board)) {
                    if (!isPlayer1turn) {
                        System.out.println("\nPlayer 1 wins!");
                        System.exit(0);
                    }
                    else {
                        System.out.println("\nPlayer 2 wins!");
                        System.exit(0);
                    }
                }

                if (checkDraw(board)) {
                    System.out.println("It's a draw!");
                    System.exit(0);
                }


                if (isPlayer1turn) 
                    System.out.println("\nPlayer 1's turn.");
                
                if (!isPlayer1turn)
                    System.out.println("\nPlayer 2's turn.");
                playing = false;
            }
            
            // Gathering player input
            if (inputting) {
                boolean retry = true;
                while(retry) {
                    System.out.print("Enter row and column (e.g., 0 1): ");
                    row = playerInput.nextInt();
                    col = playerInput.nextInt();
                    if (row > 9 || col > 9 || row < 0 || col < 0) {
                        System.out.println("Out of reach! Input again. ");
                        retry = true;
                        continue;
                    } else if (board[row][col] > 0) {
                        System.out.println("Invalid move. Try Again.");
                        retry = true;
                        continue;
                    } else {
                        isPlayer2 = makeTurn(board, row, col, isPlayer1turn);
                        retry = false;
                    }        
                }
                if (isPlayer2) 
                    isPlayer1turn = false;
                else
                    isPlayer1turn = true;
                displayTable = true;
                playing = true;
                inputting = false;
            }
        }

        playerInput.close();
    }
    
    public static void printBoard(int[][] board, int row, int col) {
        System.out.println("");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.println("  +---------------------");
        
        System.out.print("    ");
        
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
    }

    public static boolean makeTurn(int[][] board, int row, int col, boolean player1Turn) {

        if (player1Turn) {
            board[row][col] = 1;
            return true;
        } 
        if (!player1Turn) {
            board[row][col] = 2;
            return false;
        }

        return true;
    }
    
    public static boolean checkWin(int[][] board) {
        // check for HORIZONTAL 4 same numbers
        int count = 0;
        boolean contSearch = false;
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 7; col++) {
                if (board[row][col] > 0) {
                    contSearch = true;
                }

                while (contSearch && count != 3) {
                    if (board[row][col] == board[row][col + 1]) {
                        col += 1;
                        count++;
                    } else {
                        count = 0;
                        contSearch = false;
                    }
                }

                if (count == 3) {
                    return true;
                }
            }
        }
        
        // check for VERTICAL 4 same numbers
        for (int col = 0; col < 10; col++) {
            for (int row = 0; row < 7; row++) {
                if (board[row][col] > 0) {
                    contSearch = true;
                }

                while (contSearch && count != 3) {
                    if (board[row][col] == board[row + 1][col]) {
                        row += 1;
                        count++;
                    } else {
                        count = 0;
                        contSearch = false;
                    }
                }
                if (count == 3) {
                    return true;
                }
            }
        }
        
        // check for DIAGONAL 4 same numbers
        // first check from top left to bottom right 
        for (int row = 0; row < 7; row++) {
            for (int col = 0; col < 7; col++) {
                if (board[row][col] > 0) {
                    contSearch = true;
                }

                while (contSearch && count != 3) {
                    if (board[row][col] == board[row + 1][col + 1]) {
                        row += 1;
                        col += 1;
                        count++;
                    } else {
                        count = 0;
                        contSearch = false;
                    }
                }

                if (count == 3) {
                    return true;
                }
            }
        }

        // then check for top right to bottom left
        for (int row = 0; row < 7; row++) {
            for (int col = 3; col < 10; col++) {
                if (board[row][col] > 0) {
                    contSearch = true;
                }

                while (contSearch && count != 3) {
                    if (board[row][col] == board[row + 1][col - 1]) {
                        row += 1;
                        col -= 1;
                        count++;
                    } else {
                        count = 0;
                        contSearch = false;
                    }
                }

                if (count == 3) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean checkDraw(int[][] board) {
        // If board is full and no one wins
        int i = 0, j = 0;
        while (board[i][j] != 0) {
            if (j == 9){
                i++;
                j = 0;
            } else
                j++;
            if (i == 9 && j == 9) 
                return true;
        }

        return false;
    }
}