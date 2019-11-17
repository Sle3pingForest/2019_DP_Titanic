package modele.gestionBoat;

public class EpoqueXVI extends AbstractEpoqueFactory {

	@Override
	public Boat buildShip(String name,int x, int y, int size, boolean horizontal) {
		
		return new BoatXVI( name,x, y, size, horizontal) ;
	}

	@Override
	public String nameEpoch() {
		return "XVI";
	}

}
