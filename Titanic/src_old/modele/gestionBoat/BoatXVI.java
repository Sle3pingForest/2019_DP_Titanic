package modele.gestionBoat;

public class BoatXVI extends Boat {

	public BoatXVI(String name,int id,int x, int y, int size, int direction) {
		super(name,id,x, y, size, direction);
		this.hp = 1;
	}
	
	public String getName() {
		return this.name;
	}

}
