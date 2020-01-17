package bestellung;

import java.util.Date;

public class Bestellung {
	private Date bestellDatum;
	private Kunde kunde;
	private ProduktStatus[] produktStatii;

	public Bestellung(Date bestellDatum, Kunde kunde) {
		this.bestellDatum = bestellDatum;
		this.kunde = kunde;
		this.produktStatii = new ProduktStatus[100];
	}

	public void produktHinzufuegen(Produkt produkt, int anzahl) {
		for (int i = 0; i < 100; i++) {
			if (produktStatii[i] == null) {
				produktStatii[i] = new ProduktStatus(produkt, anzahl);
				break;
			}
		}
	}

	public float nettoPreis() {
		float summe = 0;
		int i = 0;
		while (produktStatii[i] != null && i < 100) {
			summe += produktStatii[i].gesamtPreis();
			i++;
		}

		return summe - (summe * kunde.berechneDiscount());
	}
}
