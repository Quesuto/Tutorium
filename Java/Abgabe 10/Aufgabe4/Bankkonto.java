package bankaccount;

public class Bankkonto {
	private float guthaben;
	private int id;

	public Bankkonto(int kontonummer) {
		guthaben = 0.0f;
		id = kontonummer;
	}

	public Bankkonto(int kontonummer, float startguthaben) {
		id = kontonummer;
		guthaben = startguthaben;
	}

	public void einzahlen(float betrag) {
		if (betrag > 0)
			guthaben += betrag;
		else
			System.err.println("Nope!");
	}

	public void abheben(float betrag) {
		if (betrag > 0)
			guthaben -= betrag;
		else
			System.err.println("Nope!");
	}

	public float getGuthaben() {
		return guthaben;
	}

	public int getID() {
		return id;
	}

	public String toString() {
		return "Konto: " + id + ": " + "Guthaben = " + guthaben;
	}

	public final void print() {
		System.out.println(toString());
	}

}