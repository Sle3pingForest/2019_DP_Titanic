package modele.player;

import java.util.Collection;
import java.util.Scanner;

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

	//function who place the boat in the player grille
	public boolean placeBoat(int x , int y,Boat b){
			if(plateau.boatPositionEmpty(plateau.getGrillPlayer(),x,y, b)) {
				b.setPosX(x);
				b.setPosY(y);
				if(b.isHorizontal()) {
					for(int i = 0 ;i <  b.getSize(); i++) {
						//plateau.getGrillPlayer()[b.getPosX() + i][b.getPosY()] = 1;
						this.plateau.setGrilleValue(b.getPosX() + i, b.getPosY(), 0);
						b.setHorizontal(true);
					}
				}
				else {
					for(int i = 0 ;i <  b.getSize(); i++) {
						this.plateau.setGrilleValue(b.getPosX(), b.getPosY()+ i, 0);
						b.setHorizontal(false);
					}
				}
				return true;
			}
			else {
				System.out.println("placement du bateau: " + b.getName() + " incorrect ");
				return false;
			}
	}
	

}

