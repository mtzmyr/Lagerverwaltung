
public class Artikel {
	private String artikelBezeichnung;
	private int artikelNummer;
	private int verpackungsEinheit;
	private String lieferant;
	private int preis;
	
	
	
	
	
	
	public Artikel(String artikelBezeichnung, int artikelNummer, int verpackungsEinheit, String lieferant,
			int preis) {
		super();
		this.artikelBezeichnung = artikelBezeichnung;
		this.artikelNummer = artikelNummer;
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
	public int getArtikelNummer() {
		return artikelNummer;
	}
	public void setArtikelNummer(int artikelNummer) {
		this.artikelNummer = artikelNummer;
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
	public int getPreis() {
		return preis;
	}
	public void setPreis(int preis) {
		this.preis = preis;
	}

	@Override
	public String toString() {
		return "- " + artikelBezeichnung + ": Nummer=" + artikelNummer
				+ "| Verpackungseinheit=" + verpackungsEinheit + "| Lieferant=" + lieferant + "| Preis=" + preis;
	}
	
	

}
