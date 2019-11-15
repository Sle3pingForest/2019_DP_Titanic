package modele.player;

import java.util.Collection;

import modele.gestionBoat.Boat;
import modele.gestionBoat.Plateau;

public abstract class Player {
	    private Plateau plateau;
	    private int munition;
	    private Collection<Boat> boats;
	    
	    public Player(Plateau plateau, int munition, Collection<Boat> boats) {
	        this.plateau=plateau;
	        this.munition=munition;
	        this.boats=boats;
	    }
	    public abstract String playerType();
		public abstract void shoot(Plateau p);

		public Plateau getPlateau() {
			return plateau;
		}

		public void setPlateau(Plateau plateau) {
			this.plateau = plateau;
		}

		public int getMunition() {
			return munition;
		}

		public void setMunition(int munition) {
			this.munition = munition;
		}

		public Collection<Boat> getBoats() {
			return boats;
		}

		public void setBoats(Collection<Boat> boats) {
			this.boats = boats;
		}
		
		public void useMunition() {
			this.munition -=1;
		}
		public boolean noMunition() {
			return munition==0; 
		}
	    
		public void placeBoats(Plateau p , Collection<Boat>boats) {
			//complete...
		}
		
}
