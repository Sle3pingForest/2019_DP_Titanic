package modele.gestionBoat;


public abstract class AbstractEpoqueFactory {
	
	protected String epoqueName;
	
	public AbstractEpoqueFactory(){
	}
	
	public abstract Boat buildShip(String name,int x, int y, int size, boolean horizontal);
	public abstract String nameEpoch();

	
	public String toString() {
		return epoqueName;
	}
}
