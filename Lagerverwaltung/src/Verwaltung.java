
public class Verwaltung {
	
	public static void main(String[] args){
		
		Lager lager = new Lager();
		Kommandozeile kommandozeile = new Kommandozeile(lager);
		kommandozeile.start();
		
	}

}
