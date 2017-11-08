

@SuppressWarnings("serial")
public class ArtikelNichtGefundenException extends Exception {
	public ArtikelNichtGefundenException(String artikel) {
		super("Artikel: " + artikel + " nicht gefunden!");
	}


}
