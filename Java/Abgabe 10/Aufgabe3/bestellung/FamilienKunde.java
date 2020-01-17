package bestellung;

public class FamilienKunde extends Kunde {
	private Kunde[] familienMitglieder;

	public FamilienKunde(String name, String adresse) {
		super(name, adresse);

		familienMitglieder = new Kunde[4];
	}

	public void familienMitgliedHinzufuegen(Kunde kunde) {
		if (kunde == this)
			return;

		for (int i = 0; i < 4; i++) {
			if (familienMitglieder[i] == null) {
				familienMitglieder[i] = kunde;
				break;
			}
		}
	}

	public float berechneDiscount() {
		int n = 0;
		for (int i = 0; i < 4; i++) {
			if (familienMitglieder[i] != null)
				n++;
		}
		return 0.05f * n;
	}
}
