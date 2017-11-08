
@SuppressWarnings("serial")
public class LagerOutOfBounceException extends Exception {
	public LagerOutOfBounceException() {
		super("Position not in Warehouse!");
	}
}
