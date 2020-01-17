package bestellung;

public class ProduktStatus {
	private int anzahl;
	private Produkt produkt;

	ProduktStatus(Produkt produkt, int anzahl) {
		this.produkt = produkt;
		this.anzahl = anzahl;
	}

	public float gesamtPreis() {
		return produkt.getPreis() * anzahl;
	}
}
