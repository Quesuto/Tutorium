package bestellung;

import jdk.nashorn.internal.objects.annotations.Getter;

public class Produkt {
	private String name;
	private float preis;

	public Produkt(String name, float preis) {
		this.name = name;
		this.preis = preis;
	}

	public String getName() {
		return name;
	}

	public float getPreis() {
		return preis;
	}
}