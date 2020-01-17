package info1Classes;

import info1Classes.Player;

public class Game {

	public static void main(String[] args) {
		
		// Die folgenden Zeilen sollen nachher alle Funktionieren.
		// Entfernen Sie daher alle Kommentarsymbole "//" vor den Codezeilen,
		// Wenn Sie die Klassen Player und Physics implementiert haben.
		
		// ///////////////
		// Starting Game with new players
		// //////////////
		System.out.println("----Spiel beginnt.----");
		
		Player player1 = new Player();
		Player player2 = new Player();
		
		// ///////////////
		// Changing names
		// //////////////
		
		player1.setName("Peter");
		player2.setName("Petra");
		
		// ///////////////
		// After some rounds, points are added
		// //////////////
		
		float[] points1 = {3,2,7};
		player1.setPoints(points1);
		float[] points2 = {0,1,7,3};
		player2.setPoints(points2);
		
		// ///////////////
		// Compare Points:
		// //////////////
		
		System.out.println("----Vergleiche Punkte----");
		
		float[] differences = player1.pointDiff(player2);
		
		// ///////////////
		// Create two new players
		// //////////////
		
		Player player3 = new Player("Parcival", differences, 44);
		Player player4 = new Player(player3);
		
		// ///////////////
		// Show points for all players:
		// //////////////
		System.out.println("----Punktestand----");
		
		player1.showPoints();
		player2.showPoints();
		player3.showPoints();
		player4.showPoints();
		
		System.out.println("----Spiel beendet----");
	}

}