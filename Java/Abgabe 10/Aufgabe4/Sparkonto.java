package bankaccount;

public class Sparkonto extends Bankkonto {
	
	private float zinsen;

	public Sparkonto(int kontonummer, float zinsen) {
		super(kontonummer);
		this.zinsen = zinsen;
	}
	
	public Sparkonto(int kontonummer, float startguthaben, float zinsen) {
		super(kontonummer, startguthaben);
		this.zinsen = zinsen;
	}
	
	public void zinsAuszahlung() {
		float auszahlung = getGuthaben()* zinsen;
		einzahlen(auszahlung);
	}	
}
