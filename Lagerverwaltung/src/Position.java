

public class Position {
	public int spalte;
	public int zeile;
	
	
	public Position(int spalte, int zeile) {
		this.spalte = spalte;
		this.zeile = zeile;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == Position.class) {
			Position position = (Position) obj;
			return (position.spalte == this.spalte && position.zeile == this.zeile);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Spalte|Zeile: " + spalte + "|" + zeile;
	}

}
