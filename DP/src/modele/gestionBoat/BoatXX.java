package modele.gestionBoat;

public class BoatXX extends Boat{

	public BoatXX(String name,int id,int x, int y, int size, int direction) {
		super(name,id,x, y, size, direction);
		this.hp = 2;
	}
	
	public String getName() {
		return this.name;
	}

}
