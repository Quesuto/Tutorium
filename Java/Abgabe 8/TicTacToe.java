public class TicTacToe {
    private char[][] board; // Spielfeld
    private char[] playerMarks; // Zeichen x und o
    private int player; // aktueller Spieler

    public TicTacToe() {
        board = new char[3][];
        for (int i = 0; i < 3; i++) {
            board[i] = new char[3];
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        playerMarks = new char[2];
        playerMarks[0] = 'x';
        playerMarks[1] = 'o';
        player = 0;
    }

    public void play(int i, int j) {
        if (board[i][j] != ' ')
            return;
        board[i][j] = playerMarks[player];
        printBoard();
        if (hasWon()) {
            char mark = playerMarks[player];
            System.out.println("Spieler " + mark + " hat gewonnen!");
            resetGame();
        }
        else if (isBoardFull()) {
            System.out.println("Unentschieden!");
            resetGame();
        }
        else {
            player = 1 - player;
        }
    }

    private void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        player = 0;
    }

    private boolean checkLine(char p, char a, char b, char c) {
        return p == a && p == b && p == c;
    }

    private boolean hasWon() {
        for (int i = 0; i < 3; i++) {
            char a = board[i][0];
            char b = board[i][1];
            char c = board[i][2];
            if (checkLine(playerMarks[player], a, b, c))
                return true;
        }
        for (int i = 0; i < 3; i++) {
            char a = board[0][i];
            char b = board[1][i];
            char c = board[2][i];
            if (checkLine(playerMarks[player], a, b, c))
                return true;
        }
        char f00 = board[0][0];
        char f11 = board[1][1];
        char f22 = board[2][2];
        char f02 = board[0][2];
        char f20 = board[2][0];
        if (checkLine(playerMarks[player], f00, f11, f22))
            return true;
        if (checkLine(playerMarks[player], f02, f11, f20))
            return true;
        return false;
    }

    private boolean isBoardFull() {
        boolean isFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    isFull = false;
            }
        }
        return isFull;
    }

    private void printBoard() {
        String fieldVis = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fieldVis += " " + board[i][j] + " ";
                if (j != 2)
                    fieldVis += "│";
            }
            fieldVis += "\n";
            if (i != 2)
                fieldVis += "───────────\n";
        }
        System.out.println(fieldVis);
    }

    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
        System.out.println("\n--- Spiel 1 ---\n");
        ttt.play(1, 1);
        ttt.play(0, 1);
        ttt.play(2, 0);
        ttt.play(0, 2);
        ttt.play(2, 2);
        ttt.play(2, 1);
        ttt.play(0, 0);
        System.out.println("\n--- Spiel 2 ---\n");
        ttt.play(0, 1);
        ttt.play(0, 0);
        ttt.play(2, 1);
        ttt.play(1, 1);
        ttt.play(0, 2);
        ttt.play(2, 1);
        ttt.play(1, 0);
        ttt.play(2, 0);
        ttt.play(1, 2);
        System.out.println("\n--- Spiel 3 ---\n");
        ttt.play(2, 2);
        ttt.play(0, 0);
        ttt.play(1, 2);
        ttt.play(0, 2);
        ttt.play(0, 1);
        ttt.play(1, 0);
        ttt.play(2, 0);
        ttt.play(2, 1);
        ttt.play(1, 1);
    }
}