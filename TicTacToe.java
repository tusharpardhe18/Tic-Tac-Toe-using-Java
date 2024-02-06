import java.util.*;

public class TicTacToe {
    static String[] board;
    static String turn;

    static String checkWinner() {
        String line = null;
        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2]; // x+x+x=xxx
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO")) {
                return "O";
            }
        }
        for (int j = 0; j < 9; j++) {
            if (Arrays.asList(board).contains(String.valueOf(j + 1))) {
                break;
            } else if (j == 8) {
                return "It's a draw :(";
            }
        }
        return null;
    }

    static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " | ");
        System.out.println("----------");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " | ");
        System.out.println("----------");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " | ");
        System.out.println("|---|---|---|");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;

        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }

        System.out.println("Welcome to 3x3 Tic Tac Toe game");
        System.out.print("Enter Player 1 name : ");
        String name1 = sc.nextLine();
        System.out.println();
        System.out.print("Enter Player 2 name : ");
        String name2 = sc.nextLine();
        System.out.println();
        System.out.println("Player 1 : "+name1);
        System.out.println("Player 2 : "+name2);
        printBoard();
        System.out.println("X will play first. Enter a slot number to place X in:");

        while (winner == null) {
            int numInput;
            try {
                numInput = sc.nextInt();
                if (!(numInput > 0 && numInput <= 9)) {
                    System.out.println("Invalid Input. Re-enter slot number: ");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Re-enter slot number: ");
                sc.next(); // Clear the invalid input from the scanner
                continue;
            }
            if (board[numInput - 1].equals(String.valueOf(numInput))) {
                board[numInput - 1] = turn;
                if (turn.equals("X")) {
                    turn = "O";
                } else {
                    turn = "X";
                }
                printBoard();
                winner = checkWinner();
            } else {
                System.out.println("Slot already taken. Re-enter slot number: ");
            }
        }

        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a draw! Thanks for playing.");
        } 
        else if(winner.equals(name2)) {
            System.out.println("Congratulations " + name2 + "! " +
                    "You won! Thanks for playing.");
        }else{
            System.out.println("Congratulations " + name1 + "! " +
                    "You won! Thanks for playing.");
        }


        sc.close();
    }
}