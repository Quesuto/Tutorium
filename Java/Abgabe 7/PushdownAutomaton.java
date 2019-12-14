import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PushdownAutomaton {
	// Member Variablen
	private int mState; // aktueller Zustand des endlichen Automaten
	private Stack<Character> mStack; // Keller
	private int[] mEndStates; // Liste mit allen Endzustaenden
	// Der Konstruktor wird beim Erstellen einer Instanz dieser Klasse aufgerufen.
	// Dabei werden alle Member Variablen dieser Klasse initialisiert. So starten
	// wir im Zustand 0, erzeugen einen leeren Keller und fuegen alle Endzustaende
	// (hier nur der Endzustand 3) zu unserer Liste von Endzustaenden.

	public PushdownAutomaton() {
		// wir starten im ersten Zustand
		mState = 0;
		// initialisiere den Keller
		mStack = new Stack<Character>();
		// initialisiere Endzustaende mit dem Zustand 3
		mEndStates = new int[] { 3 };
	}

	// main ist der Startpunkt unseres Programms
	public static void main(String args[]) {
        PushdownAutomaton pda = new PushdownAutomaton();
         
        // Eingabe 1
        String input = "abaa";
        System.out.println("Akzeptiert der Kellerautomat die Eingabe " + input + "?");
        boolean status = pda.accept(input);
        System.out.println("Erwarte: true");
        System.out.println("Bekomme: " + status + "\n");
         
        // Eingabe 2
        input = "aba";
        System.out.println("Akzeptiert der Kellerautomat die Eingabe " + input + "?");
        status = pda.accept(input);
        System.out.println("Erwarte: false");
        System.out.println("Bekomme: " + status + "\n");
         
        // Eingabe 3
        input = "aaabaaaaaa";
        System.out.println("Akzeptiert der Kellerautomat die Eingabe " + input + "?");
        status = pda.accept(input);
        System.out.println("Erwarte: true");
        System.out.println("Bekomme: " + status + "\n");
         
        // Eingabe 4
        input = "acaa";
        System.out.println("Akzeptiert der Kellerautomat die Eingabe " + input + "?");
        status = pda.accept(input);
        System.out.println("Erwarte: false");
        System.out.println("Bekomme: " + status + "\n");
         
        // Eingabe 5
        input = "aabaa";
        System.out.println("Akzeptiert der Kellerautomat die Eingabe " + input + "?");
        status = pda.accept(input);
        System.out.println("Erwarte: false");
        System.out.println("Bekomme: " + status + "\n");
         
        // Eingabe 6
        input = "aabbaaaa";
        System.out.println("Akzeptiert der Kellerautomat die Eingabe " + input + "?");
        status = pda.accept(input);
        System.out.println("Erwarte: true");
        System.out.println("Bekomme: " + status + "\n");
         
        // Eingabe 7
        input = "aabaaaaba";
        System.out.println("Akzeptiert der Kellerautomat die Eingabe " + input + "?");
        status = pda.accept(input);
        System.out.println("Erwarte: false");
        System.out.println("Bekomme: " + status + "\n");
    }

	// accept nimmt einen String bestehend aus den Buchstaben a und b

	// und gibt true zurueck wenn die Eingabe die Form a^n b^m a^(2n) hat
	// und false andernfalls. Dabei muessen n,m groesser als 0 sein.
	public boolean accept(String input) {
		// Setze den Zustand des Kellerautomaten auf den
		// Startzustand zurueck
		mState = 0;
		mStack.clear();
		// iteriere ueber alle Buchstaben der Eingabe
		for (int i = 0; i < input.length(); i++) {
			// nehme den naechsten Buchstaben aus der Eingabe
			char character = input.charAt(i);
			// lese das aktuelle oberste Element des Kellers
			char top;
			if (mStack.empty())
				top = '#';
			else
				top = mStack.peek();
			// gebe den aktuellen Zustand des Kellerautomates aus
			printAutomatonState(character, top, mState, mStack);
			// fuere Keller Operation basieren auf der aktuellen
			// Eingabe, oberstem Keller Element und Zustand aus
			stackAction(character, top, mState, mStack);
			// wechsele in den naechsten Zustand mithilfe der
			// Zustandsaenderungsfunktion
			mState = nextState(character, top, mState);
		}
		// gebe den finalen Zustand des Kellerautomates aus
		char top;
		if (mStack.empty())
			top = '#';
		else
			top = mStack.peek();
		printAutomatonState(' ', top, mState, mStack);
		// pruefe ob Eingabe akzeptiert wird.
		return checkIfInputIsAccepted(mState, mEndStates, mStack);
	}
	

	private void printAutomatonState(char character, char top, int state, Stack<Character> stack) {
		String stackVis = "";
		for (int k = 0; k < mStack.size(); k++)
			stackVis += mStack.get(k);
		stackVis += "#";
		System.out.println(character + " " + top + " " + state + " - " + stackVis);
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private void stackAction(char character, char top, int state, Stack<Character> stack) {
		if (state == 0 && character == 'a') stack.push('A');
		else if (state == 2 && character == 'a' && top == 'A') stack.pop();
	}

	private int nextState(char character, char top, int state) {
		if (state == 0 && character == 'a' && (top == 'A'||top == '#')) return 0;
		//else if (state == 0 && character == 'a' && top == '#') return 0;
		else if ((state == 0 ||state == 1) && character == 'b' && top == 'A') return 1;
		//else if (state == 1 && character == 'b' && top == 'A') return 1;
		else if ((state == 1||state == 3) && character == 'a' && top == 'A') return 2;
		// else if (state == 3 && character == 'a' && top == 'A') return 2;
		else if (state == 2 && character == 'a' && top == 'A') return 3;
		else
			return -1; 
	}

	private boolean checkIfInputIsAccepted(int state, int[] endStates, Stack<Character> stack) {
		boolean foundEndState = false;
		// for (int i = 0; i < endStates.length; i++) {
		// 	if (state == endStates[i])
		// 		foundEndState = true;
		// }

		for (int x: endStates) {
			if (state == x)
				foundEndState = true;
		}
		return stack.empty() && foundEndState;
	}
}