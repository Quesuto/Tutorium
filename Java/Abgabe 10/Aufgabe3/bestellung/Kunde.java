package bestellung;

public abstract class Kunde {
	private String name;
	private String adresse;

	public Kunde(String name, String adresse) {
		this.name = name;
		this.adresse = adresse;
	}

	public abstract float berechneDiscount();
}
