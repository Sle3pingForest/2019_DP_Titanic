package modele.gestionBoat;

public class BoatXX extends Boat{

	public BoatXX(String name,int x, int y, int size, boolean horizontal) {
		super(name,x, y, size, horizontal);
		this.hp = 2;
	}
	
	public String getName() {
		return this.name;
	}

}
