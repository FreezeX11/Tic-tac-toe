import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) throws IOException {
        String asciiArt1 = FigletFont.convertOneLine("Welcome to Freeze");
        System.out.println(asciiArt1);

        String asciiArt2 = FigletFont.convertOneLine("Tic Tac Toe Game");
        System.out.println(asciiArt2);

        TicTacToe ticTacToe = new TicTacToe();
        Player[] players = new Player[2];

        boolean win = false;
        boolean isBoardFull = false;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            int playerNumber = i+ 1;

            System.out.print("Player " + playerNumber + " enter your name: ");
            String name = scanner.nextLine();

            Player player;
            if (i == 0) {
                player = new Player(name, 'X');
            } else {
                player = new Player(name, 'O');
            }
            players[i] = player;
        }

        ticTacToe.setPlayers(players);
        Player currentPlayer = ticTacToe.players[0];
        Player winner = currentPlayer;

        while (!win && !isBoardFull) {
            System.out.println("It's your turn " + currentPlayer.getName());

            ticTacToe.displayBoard();

            System.out.print("Enter the row number: ");
            int row = scanner.nextInt();

            System.out.print("Enter the column number: ");
            int column = scanner.nextInt();

            boolean isValidMove = ticTacToe.isValidMove(row, column);
            boolean canInsert = isValidMove && ticTacToe.canInsert(row, column);

            while (!canInsert) {

                if (!isValidMove) {
                    System.out.println("Please enter position that inside the board");
                } else {
                    System.out.println("Please chose an empty space");
                }

                System.out.print("Enter the row number: ");
                row = scanner.nextInt();

                System.out.print("Enter the column number: ");
                column = scanner.nextInt();

                canInsert = ticTacToe.canInsert(row, column);
            }

            ticTacToe.insert(row, column, currentPlayer);

            win = ticTacToe.isWin(currentPlayer);
            isBoardFull = ticTacToe.isBoardFull();

            if (win) winner = currentPlayer;

            currentPlayer = ticTacToe.players[0] == currentPlayer ? ticTacToe.players[1] : ticTacToe.players[0];
        }

        ticTacToe.displayBoard();

        if (win) {
            String congrats = FigletFont.convertOneLine("Congratttttttttttttttttttttttttttttttttttttts");
            System.out.println(congrats);

            String winnerName = FigletFont.convertOneLine(winner.getName() + " you are the winner :)");
            System.out.println(winnerName);
            exit(0);
        }

        String draw = FigletFont.convertOneLine("DRAAAAAAAAAAAAAAWWWWWWWWWWWWWWWWW");
        System.out.println(draw);

    }
}
