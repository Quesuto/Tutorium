public class TicTacToe {
    private char[][] board; // Spielfeld
    private char[] playerMarks; // Zeichen x und o
    private int player; // aktueller Spieler

    public TicTacToe() {
        // initialisiere Spielfeld
        board = new char[3][];
        for (int i = 0; i < 3; i++) {
            board[i] = new char[3];
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        // initialisiere Spielerzeichen
        playerMarks = new char[2];
        playerMarks[0] = 'x';
        playerMarks[1] = 'o';
        // initialisiere Startspieler
        player = 0;
    }

    // play fuehrt einen Spielschritt aus
    // dabei wird das Feld [i][j] mit dem Zeichen des aktuellen Spielers versehen
    public void play(int i, int j) {
        // teste ob Feld bereits eine Eingabe enthaelt
        if (board[i][j] != ' ')
            return;
        // setze Zeichen des aktuellen Spielers
        board[i][j] = playerMarks[player];
        // zeichne Spielfeld
        printBoard();
        // ueberpruefe ob Spiel beendet wurde
        if (hasWon()) {
            char mark = playerMarks[player];
            System.out.println("Spieler " + mark + " hat gewonnen!");
            resetGame();
        }
        // pruefe ob Spielfeld voll ist
        else if (isBoardFull()) {
            System.out.println("Unentschieden!");
            resetGame();
        }
        // ansonsten wechsele den Spieler und mache weiter
        else {
            player = 1 - player;
        }
    }

    // setze das Spiel auf seinen Startzustand zurueck
    private void resetGame() {
        // setze Spielfeld zurueck
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        // setze Startspieler
        player = 1; //7
    }

    // hilfsfunktion die ueberprueft ob alle drei Eintraege a,b,c
    // dem Zeichen p entsprechen
    private boolean checkLine(char p, char a, char b, char c) {
        return p == a && p == b && p == c;
    }

    // pruefe ob aktueller Spieler gewonnen hat
    private boolean hasWon() {
        // prufe horizontale
        for (int i = 0; i < 3; i++) {
            char a = board[i][0];
            char b = board[i][1];
            char c = board[i][2];
            if (checkLine(playerMarks[player], a, b, c))
                return true;
        }
        // prufe vertikale
        for (int i = 0; i < 3; i++) {
            char a = board[0][i];
            char b = board[1][i];
            char c = board[2][i];
            if (checkLine(playerMarks[player], a, b, c))
                return true;
        }
        // prufe diagonale
        char f00 = board[0][0];
        char f11 = board[1][1];
        char f22 = board[2][2];
        char f02 = board[0][2];
        char f20 = board[2][0];
        if (checkLine(playerMarks[player], f00, f11, f22))
            return true;
        if (checkLine(playerMarks[player], f02, f11, f20))
            return true;
        // nichts gefunden
        return false;
    }

    // prueft ob das gesamte Spielfeld mit Zeichen gefuellt ist.
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

    // gibt das Spielfeld auf der Konsole aus
    private void printBoard() {
        String fieldVis = "";
        // zeichne Spielfeld
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