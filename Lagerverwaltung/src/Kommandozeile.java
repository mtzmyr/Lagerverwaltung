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
		lager.konfigurieren(eingabeSpalte(), eingabeZeile());
		hilfe();
		eingabe();
	}
	
	private  void eingabe(){
		System.out.println("\nNeuer Befehl: ");
		String eingabe = eingabeString();
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
						lager.konfigurieren(eingabeSpalte(), eingabeZeile());	
						eingabe();
					break;
				case "einlagern":
					System.out.println("Artikelbezeichnung: ");
					String artikelBezeichnung = eingabeString();
					System.out.println("Artikelnummer: ");
					int artikelNummer = eingabeInt();
					System.out.println("Verpackungseinheit: ");
					int verpackungsEinheit = eingabeInt();
					System.out.println("Lieferant: ");
					String lieferant = eingabeString();
					System.out.println("Preis: ");
					int preis = eingabeInt();			
					Artikel artikel = new Artikel(artikelBezeichnung, artikelNummer, verpackungsEinheit, lieferant, preis);
					lager.einlagern(artikel, eingabeSpalte(), eingabeZeile());					
					eingabe();				
					break;
					
				case "ausliefern":
					System.out.println("Geben Sie den Namen des gesuchten Artikels ein!");
					artikelBezeichnung = eingabeString();
					lager.ausliefern(artikelBezeichnung);
					eingabe();
					break;
				case "position":
					System.out.println("Geben Sie den Namen des gesuchten Artikels ein!");
					artikelBezeichnung = eingabeString();
					lager.position(artikelBezeichnung);
					eingabe();
					break;
				case "inventar":
					lager.inventar();
					eingabe();
					break;
				case "inhalt":
					lager.suchen(eingabeSpalte(), eingabeZeile());
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
		
	
	public int eingabeSpalte(){
		int spalte;
		System.out.println("Geben sie die Spaltennummer ein!");
		spalte = eingabeInt();
		return spalte;
				
	}
	
	public int eingabeZeile(){
		int zeile;
		System.out.println("Geben Sie die Zeilennummer ein!");
		zeile = eingabeInt();
		return zeile;
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
	
	private int eingabeInt(){
		if(scanner.hasNextInt()){
			int input = scanner.nextInt();
			return input;
			
		}	
		else{
			System.out.println("Geben Sie bitte einen Integer ein!");
			return 0; 
		}
			
	}
	
	private String eingabeString(){
		String input = scanner.next();
		return input;		
	}
	
	private void fehler(){
		System.out.println("Bitte geben Sie ein gültiges Zeichen ein!");
	}
			
}
