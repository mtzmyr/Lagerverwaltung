
@SuppressWarnings("serial")
public class LagerPositionLeerException extends Exception {
	public LagerPositionLeerException(Position position) {
		super("Der Lagerplatz (" + position.spalte + "|" + position.zeile + ") ist Leer!");
	}

}
