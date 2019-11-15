package modele.gestionBoat;

public class BoatXVI extends Boat {

	public BoatXVI(int x, int y, int size, boolean horizontal) {
		super(x, y, size, horizontal);
		this.hp = 1;
	}
	
	public String getName() {
		return "Boat XVI";
	}

}
