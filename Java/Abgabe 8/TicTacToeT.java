public class TicTacToe { 
    // ------------------------------------------------------------------------------------------------ //
    // a b c d kommen hier hin                                                                          //
    // ------------------------------------------------------------------------------------------------ //
     
     
    //Attribute:
    private char[][] board = new char[3][3];            //Spielfeld, als 3x3 2D Array vom Typ char
    private char[] playerMarks = new char[2];           //Zeichen der Spieler als Array der LÃ¤nge 2 vom Typ char
    private int player;                                 //zeigt an, welcher Spieler an der Reihe ist: dabei steht 0 fÃ¼r Spieler 1 und 1 fÃ¼r Spieler 2
     
    //winningPositions ist ein Array, welches alle mÃ¶glichen Anordnungen eines Zeichens auf dem Spielfeld angibt, welche in einer Zeile, Spalte oder Diagonalen sind und somit zum Sieg fÃ¼hren.
    //Dabei entspricht zum Beispiel {{0,0},{0,1},{0,2}}, der 1. Zeile des Spielfelds (also die Felder (0,0),(0,1) und (0,2) des Spielfelds)
    private static int[][][] winningPositions = {{{0,0},{0,1},{0,2}},{{1,0},{1,1},{1,2}},{{2,0},{2,1},{2,2}},{{0,0},{1,0},{2,0}},{{0,1},{1,1},{2,1}},{{0,2},{1,2},{2,2}},{{0,0},{1,1},{2,2}},{{0,2},{1,1},{2,0}}};
     
    //Konstruktor der keine Parameter entgegennimmt und das board nur mit ' ' in allen Feldern fÃ¼llt, die playerMarks auf 'x' und 'o' und den aktuellen Spieler auf Spieler 1 setzt
    public TicTacToe() {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
        playerMarks[0] = 'x';
        playerMarks[1] = 'o';
        player = 0;
    }
     
    //Funktion, welche das Spiel neustartet und dafÃ¼r das board wieder mit ' ' in allen Feldern fÃ¼llt und den aktuellen Spieler auf Spieler 1 setzt
    private void resetGame(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
        player = 0;
    }
     
    //Die Funktion hasWon Ã¼berprÃ¼ft, ob der aktuelle Spieler gewonnen hat. Sie nimmt keine Parameter entgegen und gibt einen boolean zurÃ¼ck.
    //DafÃ¼r geht sie alle Elemente des Arrays winningPositions durch (welche jeweils aus drei Positionen auf dem Spielfeld bestehen)
    //und zÃ¤hlt jeweils die Anzahl der Zeichen dieser Felder, die dem Zeichen des aktuellen Spielers entsprechen.
    //Wenn diese Anzahl 3 ist, hat der aktuelle Spieler 3 in einer Reihe und hat somit gewonnen und die Funktion gibt true zurÃ¼ck.
    //Wenn die Funktion alle Elemente von winningPositions durchgegangen ist ohne das der aktuelle Spieler gewonnen hat, gibt sie false zurÃ¼ck.
    private boolean hasWon(){
        for(int i=0;i<winningPositions.length;i++){
            int counter = 0;
            for(int j=0;j<winningPositions[i].length;j++){
                if (board[winningPositions[i][j][0]][winningPositions[i][j][1]]==playerMarks[player]) counter++;
            }
            if (counter==3) return true;
        }
        return false;
    }
     
    //Die Funktion play setzt einen Spielzug des aktuellen Spielers um, wobei sie zwei ints i und j entgegennimmt, welche fÃ¼r die i-te Zeile und die j-te Spalte des Spielfelds stehen.
    public void play (int i, int j) {
        if (board[i][j] != ' ') return;     //wenn das Feld, in das etwas eingetragen werden soll nicht leer ist (also ' ' enthÃ¤lt), so soll die Funktion sofort abgebrochen werden
         
        board[i][j] = playerMarks[player];  //ansonsten wird das Zeichen des aktuellen Spielers in die i-te Zeile und die j-te Spalte des Spielfelds eingetragen
        printBoard(board);                  //dann wird der aktuelle Zustand des boards auf der Konsole ausgegeben
        if (hasWon()) {    
            System.out.println("Spieler " + playerMarks[player] + " hat gewonnen!");    //wenn der aktuelle Spieler gewonnen hat, wird diese Nachricht ausgegeben
            resetGame();                                                                //und das Spiel wird neugestartet
        } else if (isBoardFull(board)) {
            System.out.println("Unentschieden!");                                       //wenn der aktuelle Spieler nicht gewonnen hat, aber das Spielfeld voll ist, wird "Unentschieden!" ausgegeben
            resetGame();                                                                //und das Spiel wird neugestartet
        } else {
            switch(player){                                                             //ansonsten wird der aktuelle Spieler gewechselt
                case 0: player=1; break;
                case 1: player=0; break;
            }
        }
    }
         
    // ------------------------------------------------------------------------------------------------ //
    // gegebene Methoden                                                                                //
    // ------------------------------------------------------------------------------------------------ //
     
    // prueft ob das gesamte Spielfeld mit den Zeichen der Spieler gefuellt ist.
    // wenn ja gib true zurueck, andernfalls false
    private boolean isBoardFull(char[][] board) {
        boolean isFull = true;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == ' ') isFull = false;
            }
        }
        return isFull;
    }
     
    // gibt den aktuellen Zustand des Spielfeldes auf der Konsole aus.
    private void printBoard(char[][] board) {
        String fieldVis = "";
        // zeichne Spielfeld
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                fieldVis += " " + board[i][j] + " ";
                if(j != 2) fieldVis += "|";
            }
            fieldVis += "\n";
            if(i != 2) fieldVis += "-----------\n";
        }
        System.out.println(fieldVis);
    }
     
    // ------------------------------------------------------------------------------------------------ //
    // main                                                                                             //
    // ------------------------------------------------------------------------------------------------ //
     
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