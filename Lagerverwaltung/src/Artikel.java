
public class Artikel extends Seriennummer{
	private String artikelBezeichnung;
	private int verpackungsEinheit;
	private String lieferant;
	private double preis;
	
	
	
	
	
	
	public Artikel(String artikelBezeichnung, int verpackungsEinheit, String lieferant,
			double preis) {
		super();
		this.artikelBezeichnung = artikelBezeichnung;
		this.verpackungsEinheit = verpackungsEinheit;
		this.lieferant = lieferant;
		this.preis = preis;
	}
	
	public String getArtikelBezeichnung() {
		return artikelBezeichnung;
	}
	public void setArtikelBezeichnung(String artikelBezeichnung) {
		this.artikelBezeichnung = artikelBezeichnung;
	}
	
	public int getVerpackungsEinheit() {
		return verpackungsEinheit;
	}
	public void setVerpackungsEinheit(int verpackungsEinheit) {
		this.verpackungsEinheit = verpackungsEinheit;
	}
	public String getLieferant() {
		return lieferant;
	}
	public void setLieferant(String lieferant) {
		this.lieferant = lieferant;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}

	@Override
	public String toString() {
		return "\n-" + artikelBezeichnung + ": Verpackungseinheit=" + verpackungsEinheit + " Lieferant=" + lieferant + " Preis=" + preis
				+"\n"+ "Seriennummer: " +super.nummer;
	}
	
	

}
