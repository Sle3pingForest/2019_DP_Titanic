package modele.gestionBoat;

public class EpoqueXX extends AbstractEpoqueFactory {

	@Override
	public Boat buildShip(String name,int id, int x, int y, int size, int horizontal) {
		// TODO Auto-generated method stub
		return new BoatXX( name,id,x, y, size, horizontal);
	}

	@Override
	public String nameEpoch() {
		// TODO Auto-generated method stub
		return "XX";
	}

}
