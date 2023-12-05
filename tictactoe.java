import java.util.Scanner;
public class tictactoe {
    final static char cross = 'x';
    final static char circle = 'o';
    static int winner;
    static void displayBoard(char[][] board) {
        System.out.println("+---+---+---+");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|\n+---+---+---+");
        }
    }
    static boolean checkWinner(char[][] board) {
        //checks row wins
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == cross && board[i][1] == cross && board[i][2] == cross) {
                winner = 0;
                return true;
            }
            if(board[i][0] == circle && board[i][1] == circle && board[i][2] == circle) {
                winner = 1;
                return true;
            }
        }
        //checks column wins
        for(int i = 0; i < 3; i++) {
            if(board[0][i] == cross && board[1][i] == cross && board[2][i] == cross) {
                winner = 0;
                return true;
            }
            if(board[0][i] == circle && board[1][i] == circle && board[2][i] == circle) {
                winner = 1;
                return true;
            }
        }
        //checks diagonal wins
        if(board[0][0] == cross && board[1][1] == cross && board[2][2] == cross) {
            winner = 0;
            return true;
        } else if(board[0][0] == circle && board[1][1] == circle && board[2][2] == circle) {
            winner = 1;
            return true;
        }
        if(board[0][2] == cross && board[1][1] == cross && board[2][0] == cross) {
            winner = 0;
            return true;
        } else if(board[0][2] == circle && board[1][1] == circle && board[2][0] == circle) {
            winner = 1;
            return true;
        }
        return false;
    }
    static boolean insertMove(char[][] board, char currentMove) {
        Scanner input = new Scanner(System.in);
        System.out.printf("player %c, please enter a move (row, column): ", currentMove);
        int row = input.nextInt();
        int col = input.nextInt();
        if(row > 2 || col > 2) {
            System.out.print("out of bounds! ");
            return false;
        }
        if(board[row][col] == cross || board[row][col] == circle) {
            System.out.print("square taken! ");
            return false;
        }
        board[row][col] = currentMove;
        return true;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("hi welcome to tic tac toe. the rows and columns are numbered 0-2. who is starting? (x/o): ");
        char move = cross;
        if(input.next().equalsIgnoreCase("o")) {
            move = circle;
        }
        char[][] board = new char[3][3];
        while(!checkWinner(board)) {
            displayBoard(board);
            if(insertMove(board, move)) {
                if(move == cross) {
                    move = circle;
                } else {
                    move = cross;
                }
            } else {
                System.out.println("try again. ");
            }
            if(checkWinner(board)) {
                if(winner == 0) {
                    System.out.println("\nplayer x wins!");
                } else if(winner == 1) {
                    System.out.println("\nplayer o wins!");
                }
                displayBoard(board);
            }
        }
    }
}