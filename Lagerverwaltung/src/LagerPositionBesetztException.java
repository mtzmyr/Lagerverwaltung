
@SuppressWarnings("serial")
public class LagerPositionBesetztException extends Exception {
	
	public LagerPositionBesetztException(Position position, Artikel artikel) {
		super("Die ausgewählte Position (Spalte: " + position.spalte + " Zeile: " + position.zeile + ") ist besetzt von " + artikel + "!");
	}

}
