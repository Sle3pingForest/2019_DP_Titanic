package modele.gestionBoat;


public abstract class AbstractEpoqueFactory {
	
	protected String epoqueName;
	
	public AbstractEpoqueFactory(){
	}
	
	public abstract Boat buildShip(String name,int id,int x, int y, int size, int horizontal);
	public abstract String nameEpoch();

	
	public String toString() {
		return epoqueName;
	}
}
