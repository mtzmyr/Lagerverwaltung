
public class Lager {
	
	
	private int spalte;
	private int zeile;
	private Artikel[][] lager;
	
		
	public Lager() {
		super();
	}
	
	public void einlagern(Artikel artikel, Position position) throws LagerOutOfBounceException, LagerPositionBesetztException
	{
		positionPrüfen(position);
		Artikel temp = lagerInhalt(position);
		if(temp != null){
			throw new LagerPositionBesetztException(position, temp);
		}
		else{
		artikelEinlagern(position, artikel);
		System.out.println("Der Artikel ist nun an Platz "+position.spalte+"|"+position.zeile+" !");
		}
	}
	
	public void artikelEinlagern(Position position, Artikel artikel) throws  LagerOutOfBounceException{
		positionPrüfen(position);
		lager[position.spalte][position.zeile] = artikel;
	}
		
	
	public Artikel ausliefern(Position position) throws LagerOutOfBounceException, LagerPositionLeerException{
		positionPrüfen(position);
		Artikel artikel = lagerInhalt(position);
		if(artikel == null)
		{
			throw new LagerPositionLeerException(position);
		}
		else
		{
			artikelEinlagern(position, null);
			return artikel;
		}
	}
	
	public Artikel inhalt(Position position)throws LagerOutOfBounceException, LagerPositionLeerException{
		positionPrüfen(position);
		Artikel artikel = lagerInhalt(position);
		if(artikel == null)
		{
			throw new LagerPositionLeerException(position);
		}
		else
		{
			System.out.println("An der Position "+position.spalte+"|"+position.zeile + " befindet sich der Artikel "+artikel);
			return artikel;
		}
		
	}
	
	public Position position(String name) throws ArtikelNichtGefundenException{
		for(int s = 0; s < spalte; s++){
			for(int z = 0; z < zeile; z++){
				Position position = new Position(s,z);
				Artikel tempArtikel = lagerInhalt(position);
				if(tempArtikel != null && tempArtikel.getArtikelBezeichnung().equals(name)){
					return position;
					
				}
			}
		}
		throw new ArtikelNichtGefundenException(name);
		}

	public Artikel lagerInhalt(Position position)
	{
		return lager[position.spalte][position.zeile];
	}
	
	private void positionPrüfen(Position position) throws LagerOutOfBounceException {
		if (position.spalte >= spalte || position.zeile >= zeile || position.spalte < 0 || position.zeile < 0) {
			throw new LagerOutOfBounceException();
		}
	}
	
	public Artikel suchen(Position position) throws LagerOutOfBounceException {
		positionPrüfen(position);
		return lagerInhalt(position);
	}
	
	public void inventar(){
		for(int s = 0; s < lager.length; s++){
			for(int z = 0; z < lager[s].length; z++){
				Position tempPosition = new Position(s,z);
				Artikel tempArtikel = lagerInhalt(tempPosition);
				if(tempArtikel != null){
					System.out.println(tempArtikel);
				}
			}
		}

	}
	
	public void konfigurieren(Position position){
		lager = new Artikel[position.spalte][position.zeile];
		this.spalte = position.spalte;
		this.zeile = position.zeile;
		System.out.println("Neue Konfiguration: Spalte|Zeile: "+getSpalte()+"|"+getZeile());
	}
	
	public int getSpalte() {
		return spalte;
	}

	public int getZeile() {
		return zeile;
	}
		
}
