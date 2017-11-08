import java.util.UUID;


public class Seriennummer {
	protected String nummer;
	public Seriennummer(String nummer) {
		this.nummer = nummer;
	}
	
	public Seriennummer() {
		nummer = UUID.randomUUID().toString();
	}
	
	@Override
	public boolean equals(Object objekt) {
		if (objekt instanceof Seriennummer) {
			Seriennummer serienNummer = (Seriennummer) objekt;
			return (serienNummer.getNumber().equals(this.getNumber()));
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return nummer.hashCode();
	}
	
	public String getNumber() {
		return nummer;
	}

}
