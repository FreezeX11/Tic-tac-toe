public class TicTacToe {
    char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    Player[] players;

    public TicTacToe() {
        this.players = new Player[2];
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public boolean canInsert(int row, int column) {
        return this.board[row][column] == ' ';
    }

    public void insert(int row, int column, Player currentPlayer) {
        this.board[row][column] = currentPlayer.getSymbol();
    }

    public boolean checkHorizontally(Player currentPlayer) {
        char symbol = currentPlayer.getSymbol();

        for (int i = 0; i < board.length; i++) {
            boolean lineWin = true;

            for (int j = 0; j < board[i].length; j++) {
                if (symbol != board[i][j]) {
                    lineWin = false;
                    break;
                }
            }

            if (lineWin) return true;
        }

        return false;
    }

    public boolean checkVertically(Player currentPlayer) {
        char symbol = currentPlayer.getSymbol();

        for (int j = 0; j < board[0].length; j++) {
            boolean columnWin = true;

            for (int i = 0; i < board.length; i ++) {
                if (symbol != board[i][j]) {
                    columnWin = false;
                    break;
                }
            }

            if (columnWin) return true;
        }

        return false;
    }

    public boolean checkFirstDiagonal(Player currentPlayer) {
        char symbol = currentPlayer.getSymbol();

        for (int i = 0; i < board.length; i++) {
            if (symbol != board[i][i])
                return false;
        }

        return true;
    }

    public boolean checkSecondDiagonal(Player currentPlayer) {
        char symbol = currentPlayer.getSymbol();
        int j = board[0].length - 1;
        for (int i = 0; i < board.length; i ++) {
            if (symbol != board[i][j])
                return false;

            j -= 1;
        }

        return true;
    }

    public boolean checkDiagonal(Player currentPlayer) {
        return checkFirstDiagonal(currentPlayer) || checkSecondDiagonal(currentPlayer);
    }

    public boolean isWin(Player currentPlayer) {
        return checkHorizontally(currentPlayer) || checkVertically(currentPlayer) || checkDiagonal(currentPlayer);
    }

    public boolean isBoardFull() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (' ' == board[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
