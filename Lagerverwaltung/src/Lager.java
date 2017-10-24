
public class Lager {
	
	
	private int spalte;
	private int zeile;
	Artikel[][] lager;
	
		
	public Lager() {
		super();
	}
	
	public void einlagern(Artikel artikel, int spalte, int zeile)
	{
		if(lager[spalte][zeile] != null){
			System.out.print("Dieser Platz ist bereits belegt!");
		}
		else{
			
		lager[spalte][zeile] = artikel;
		System.out.println("Der Artikel ist nun an Platz "+spalte+"|"+zeile+" !");
		}
	}
	
	public void ausliefern(String artikelBezeichnung){
		boolean correct = false;
		for(int s = 0; s < lager.length; s++){
			for(int z = 0; z <lager[s].length; z++){
				Artikel artikel = lager[s][z];
				if(artikel != null && artikel.getArtikelBezeichnung().equals(artikelBezeichnung)){
					lager[s][z] = null;
					correct = true;
				}
				
			}
			
		}
		if(!correct){
			System.out.println("Der eingegebene Artikel existiert nicht!");
		}
	}
	
	public void position(String artikelBezeichnung){
		boolean correct = false;
		for(int s = 0; s < lager.length; s++){
			for(int z = 0; z < lager[s].length; z++){
				Artikel artikel = lager[s][z];
				if(artikel != null && artikel.getArtikelBezeichnung().equals(artikelBezeichnung)){
					System.out.println("Der Artikel " + artikelBezeichnung + " hat folgende Position: " + s + "|"+ z);
					correct = true;
				}
			}
		}
		if(!correct){
			System.out.println("Es gibt keinen Artikel mit diesem Namen!");
		}
	}
	
	public Artikel suchen(int spalte, int zeile){
		if(lager[spalte][zeile] == null){
			System.out.println("Dieser Platz ist leer!");
			return null;
		}
		else{
			System.out.println(lager[spalte][zeile].getArtikelBezeichnung()+" | "+lager[spalte][zeile].getLieferant()+" | "+lager[spalte][zeile].getArtikelNummer()+" | "+lager[spalte][zeile].getPreis()+" | "+lager[spalte][zeile].getVerpackungsEinheit());
			return lager[spalte][zeile];
			
		}
		
		
		
	}
	
	public void inventar(){
		for(int s = 0; s < lager.length; s++){
			for(int z = 0; z < lager[s].length; z++){
				if(lager[s][z] != null){
					Artikel artikel = lager[s][z];
					
					System.out.println("- "+artikel.toString()+ " --> Position: "+s+" | "+ z+ "\n");
					
				}
			}
		}
	}
	
	public void konfigurieren(int spalte, int zeile){
		lager = new Artikel[spalte][zeile];
		this.spalte = spalte;
		this.zeile = zeile;
		System.out.println("Neue Konfiguration: Spalte|Zeile: "+getSpalte()+"|"+getZeile());
	}
	
	public int getSpalte() {
		return spalte;
	}

	public int getZeile() {
		return zeile;
	}
		
}
