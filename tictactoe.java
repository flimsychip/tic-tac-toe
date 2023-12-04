import java.util.Scanner;
public class tictactoe {
    final static char cross = 'x';
    final static char circle = 'o';
    static void displayBoard(char[][] board) {
        System.out.println("+---+---+---+");
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.print("+---+---+---+");
    }
    static boolean checkWinner(char[][] board) {
        //checks row wins
        for(int i = 0; i < 3; i++) {
            if(board[i][0] == cross && board[i][1] == cross && board[i][2] == cross) {
                return true;
            }
            if(board[i][0] == circle && board[i][1] == circle && board[i][2] == circle) {
                return true;
            }
        }
        //checks column wins
        for(int i = 0; i < 3; i++) {
            if(board[0][i] == cross && board[1][i] == cross && board[2][i] == cross) {
                return true;
            }
            if(board[0][i] == circle && board[1][i] == circle && board[2][i] == circle) {
                return true;
            }
        }
        //checks diagonal wins
        if(board[0][0] == cross && board[1][1] == cross && board[2][2] == cross) {
            return true;
        } else if(board[0][0] == circle && board[1][1] == circle && board[2][2] == circle) {
            return true;
        }
        if(board[0][2] == cross && board[1][1] == cross && board[2][0] == cross) {
            return true;
        } else if(board[0][2] == circle && board[1][1] == circle && board[2][0] == circle) {
            return true;
        }
        return false;
    }
    static boolean insertMove(char[][] board, char currentMove) {
        Scanner input = new Scanner(System.in);
        System.out.printf("player %c, please enter a move (row, column): ", currentMove);
        int move = input.nextInt();
        return false;
    }
    public static void main(String[] args) {
        char[][] test = {{cross, circle, circle}, {circle, cross, circle}, {circle, circle, cross}};
        displayBoard(test);
        checkWinner(test);
    }
}