import java.util.Scanner;

class game {
    public static void main(String[] args) {
        System.out.println("Welcome to my Tic Tac Toe Game!");
        char board[][] = new char[3][3];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;

        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.print("Player " + player + " enter : ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if (gameOver) {
                    System.out.println("Congratulation Player " + player + " has Won");
                    break;
                } else {
                    // if(player == 'X'){
                    // player = 'O';
                    // } else{
                    // player = 'X';
                    // }

                    player = (player == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid Move... Try again!");
            }
        }
        printBoard(board);
    }

    private static boolean haveWon(char board[][], char player) {

        // check the rows
        for (int row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }

        }

        // for the columns
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        // for diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    private static void printBoard(char board[][]) {
        System.out.println(); // just for one line spacing
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length - 1; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}