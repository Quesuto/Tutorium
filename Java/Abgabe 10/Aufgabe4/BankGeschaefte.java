package bankaccount;

public class BankGeschaefte {

	public static void main(String[] args) {
		// Die Eltern legen im Jahr 2000 ein Sparkonto mit 1500€ an,
		// die jährlichen Zinsen belaufen sich konstant auf 1.7%
		Sparkonto sparenFuerDieUni = new Sparkonto(100, 1500.0f, 0.017f);
		sparenFuerDieUni.print();
		
		// TODO: Aufgabe m:
		// Inzwischen sind genau 20 Jahre vergangen.
		// Berechnen Sie mit Hilfe der von Ihnen implementierten Funktionen
		// in der Klasse Sparkonto das Guthaben auf dem Sparkonto.
		
		for(int i = 0; i < 20; i++) {
			sparenFuerDieUni.zinsAuszahlung();
		}
		
		
		
		
		// Zeitsprung: Heute.
		// Neues Taschengeldkonto auf dem aktuell 330€ liegen
		Girokonto taschenGeldGiro = new Girokonto(101, 330.0f);
		taschenGeldGiro.print();
		
		// //////////////////////////////////////////////////////////
		// Folgende Ausgaben und Einnahmen finden im November statt:
		// //////////////////////////////////////////////////////////
		
		taschenGeldGiro.abheben(30.0f);  // Kneipenabend
		taschenGeldGiro.abheben(120.0f); // Auto abgeschleppt
		taschenGeldGiro.abheben(180.0f); // Kühlschrank kaputt
		taschenGeldGiro.monatsEnde();

		// //////////////////////////////////////////////////////////
		// Folgende Ausgaben und Einnahmen finden im Dezember statt:
		// //////////////////////////////////////////////////////////
		
		taschenGeldGiro.einzahlen(150.0f); // Taschengeld ist da
		taschenGeldGiro.einzahlen(50.0f);  // Geld von der Oma auch
		taschenGeldGiro.abheben(75.0f);    // Whiskyflasche als Weihnachtsgeschenk 
		taschenGeldGiro.abheben(100.0f);   // Deluxe Weihnachtsbaum mit Superbeleuchtung
		taschenGeldGiro.abheben(120.f);    // Neue Kopfhörer im Angebot
		taschenGeldGiro.monatsEnde();
		
		// TODO: Aufgabe m:
		// Sie möchten im nächsten Semester einen Auslandsaufenhtalt auf sich nehmen.
		// Reicht das auf dem Sparkonto angesparte Geld zusammen mit dem Geld auf Ihrem Girokonto aus,
		// um die Kosten dafür zu begleichen?
		
		float semesterKosten = 2000.0f;
		float uebrigesGeld = sparenFuerDieUni.getGuthaben() + taschenGeldGiro.getGuthaben(); // Berechnen Sie hier ihr gesamtes Guthaben.
		
		if(uebrigesGeld > semesterKosten) {
			System.out.println("Glückwunsch, auf ins Ausland");
		} else {
			System.out.println("Vielleicht weniger feiern gehen...");
		}
		
	}

}
