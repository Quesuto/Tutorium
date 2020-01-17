package bestellung;

public class PremiumKunde extends Kunde {
	private float discount;

	public PremiumKunde(String name, String adresse, float discount) {
		super(name, adresse);
		this.discount = discount;
	}

	public float berechneDiscount() {
		return discount;
	}
}
