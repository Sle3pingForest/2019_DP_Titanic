package modele.gestionBoat;

public class BoatXVI extends Boat {

	public BoatXVI(String name,int x, int y, int size, boolean horizontal) {
		super(name,x, y, size, horizontal);
		this.hp = 1;
	}
	
	public String getName() {
		return this.name;
	}

}
