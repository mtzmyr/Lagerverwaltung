import java.util.Scanner;

public class Kommandozeile {
	
	private Lager lager;
	private Scanner scanner;
	String[][] optionen = new String[7][2];
	
	
	public Kommandozeile(Lager lager){
		this.lager = lager;
		scanner = new Scanner(System.in);
	}
	
	
	public void start(){
		System.out.println("Wählen Sie bitte die größe Ihres Lagers.");
		lager.konfigurieren(createPosition());
		hilfe();
		eingabe();
	}
	
	private  void eingabe(){
		String eingabe = aufEingabeWarten("\nNeuer Befehl: ");
		boolean correct = false;
		for(int i=0; i < optionen.length; i++){
			if(optionen[i][0].equals(eingabe)){	
				schleife(eingabe);
				correct = true;
				
			}
			
		}
		if (!correct){
			fehler();
		}
				
}
	
	private void schleife(String eingabe){
		
		
				switch (eingabe) {
				case "konfigurieren":
						lager.konfigurieren(createPosition());	
						eingabe();
					break;
				case "einlagern":
					einlagern(createArticle());				
					eingabe();				
					break;
					
				case "ausliefern":
					ausliefern();
					eingabe();
					break;
				case "position":
					position();
					eingabe();
					break;
				case "inventar":
					lager.inventar();
					eingabe();
					break;
				case "inhalt":
					inhalt(createPosition());
					eingabe();
					break;
				case "hilfe":
					hilfe();
					eingabe();
					break;
				default:
					fehler();
					break;
				}
	}
	
	private void inhalt(Position position){
		try{
			lager.inhalt(position);
		} catch (LagerOutOfBounceException e){
			System.out.println("Position nicht im Lagerhaus!");
			inhalt(position);
		} catch (LagerPositionLeerException e){
			System.out.println("An der gesuchten Position befindet sich kein Artikel!");
			inhalt(position);
		}
	}
	
	
	private void einlagern(Artikel artikel) {
		Position position = createPosition();
		try {
			lager.einlagern(artikel, position);
		} catch (LagerPositionBesetztException e) {
			System.out.println("Position bereits belegt!");
			einlagern(artikel);
		} catch (LagerOutOfBounceException e) {
			System.out.println("Position nicht im Lagerhaus!");
			einlagern(artikel);
		}
	}
	
	private void ausliefern() {
		Position position = createPosition();
		try {
			Artikel artikel = lager.ausliefern(position);
			System.out.println("Artikel " + artikel + " wurde ausgeliefert.");
		}
		catch (LagerPositionLeerException e) {
			System.out.println("Lagerplatz leer!");
		} catch (LagerOutOfBounceException e) {
			System.out.println("Position nicht im Lagerhaus!");
			ausliefern();
		}
	}
	
	private void position() {
		String eingabe = aufEingabeWarten("Geben Sie den Namen des gesuchten Artikels ein: ");
		try {
			Position position = lager.position(eingabe);
			System.out.println("Der Artikel befindet sich am Platz " + position);
		} catch (ArtikelNichtGefundenException e) {
			System.out.println("Artikel nicht im Lagerhaus!");
		}
	}
		
	
	private void hilfe(){
		System.out.println("----------Hilfe---------");
		
		optionen[0][0]= "konfigurieren";
		optionen[1][0]= "einlagern";
		optionen[2][0]= "ausliefern";
		optionen[3][0]= "position";
		optionen[4][0]= "inventar";
		optionen[5][0]= "inhalt";
		optionen[6][0]= "hilfe";
		
		optionen[0][1] = "[konfigurieren]--> Das Lager nach Zeilen und Spalten konigurieren";
		optionen[1][1] = "[einlagern]--> Artikel einlagern";
		optionen[2][1] = "[ausliefern]--> Artikel ausliefern";
		optionen[3][1] = "[position]--> Position des Artikels ausgeben";
		optionen[4][1] = "[inventar]--> Alle Artikel und deren Beschreibung ausgeben";
		optionen[5][1] = "[inhalt]--> gibt den Artikel der gesuchten Spalten/Zeilen Nummer aus";
		optionen[6][1] = "[hilfe]--> gibt eine Übersicht über alle Befehle";
		
		for(int s = 0; s < optionen.length; s++){
			for(int z = 1; z < optionen[s].length; z++ ){
				System.out.println(optionen[s][z]);
			}
			
		}
		System.out.println("------------------------");		
				
	}
	
	
	
	private String aufEingabeWarten(String text) {
		System.out.print(text);
		return scanner.next();
	}
	
	private Position createPosition() {
		String spalteEingabe= aufEingabeWarten("Spalte:");
		String zeileEingabe = aufEingabeWarten("Zeile:");
		try {
			int spalte = Integer.parseInt(spalteEingabe);
			int zeile = Integer.parseInt(zeileEingabe);
			return new Position(spalte, zeile);
		} catch (Exception e) {
			System.out.println("Fehler in der Eingabe!");
			return createPosition();
		}
	}
	
	private Artikel createArticle() {
		String name = aufEingabeWarten("Name:");
		String packungEingabe = aufEingabeWarten("Verpackungseinheit:");
		String preisEingabe = aufEingabeWarten("Preis:");
		String lieferant = aufEingabeWarten("Lieferant:");
		try {
			Double preis = Double.parseDouble(preisEingabe);
			int verpackungsEinheit = Integer.parseInt(packungEingabe);
			Artikel artikel = new Artikel(name, verpackungsEinheit, lieferant, preis);
			System.out.println("Article ID: " + artikel.getNumber());
			return artikel;
		} catch (Exception e) {
			System.out.println("Fehler in der Eingabe!");
			return createArticle();
		}
	}
	
	private void fehler(){
		System.out.println("Bitte geben Sie ein gültiges Zeichen ein!");
		eingabe();
	}
			
}
