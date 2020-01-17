package bankaccount;

public class Girokonto extends Bankkonto{
	
	private int numTransaktionen;
	private final float transaktionskosten = 0.50f;
	private final int kostenloseTransaktionen = 5;
	private final float dispo = 50.0f;
	
	public Girokonto(int kontonummer) {
		super(kontonummer);
		numTransaktionen = 0;
	}
	
	public Girokonto(int kontonummer, float startguthaben) {
		super(kontonummer, startguthaben);
		numTransaktionen = 0;
	}
	
	public void abheben(float betrag) {
		if((getGuthaben() + dispo) >= betrag) {
			super.abheben(betrag);
		} else {
			super.abheben(0.5f);
		}
		numTransaktionen++;
	}
	
	public void einzahlen(float betrag) {
		super.einzahlen(betrag);
		numTransaktionen++;
	}
	
	public void monatsEnde() {
		if (numTransaktionen > kostenloseTransaktionen) {
			float abzug = (numTransaktionen-kostenloseTransaktionen) * transaktionskosten;
			abheben(abzug);
		}
		numTransaktionen = 0;
	}
	
}
