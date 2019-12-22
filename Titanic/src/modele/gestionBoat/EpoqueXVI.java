package modele.gestionBoat;

public class EpoqueXVI extends AbstractEpoqueFactory {

	@Override
	public Boat buildShip(String name,int id,int x, int y, int size, int horizontal) {
		
		return new BoatXVI( name,id,x, y, size, horizontal) ;
	}

	@Override
	public String nameEpoch() {
		return "XVI";
	}

}
