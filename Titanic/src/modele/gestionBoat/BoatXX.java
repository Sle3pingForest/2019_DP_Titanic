package modele.gestionBoat;

public class BoatXX extends Boat{

	public BoatXX(int x, int y, int size, boolean horizontal) {
		super(x, y, size, horizontal);
		this.hp = 2;
	}
	
	public String getName() {
		return "Boat XX";
	}

}
