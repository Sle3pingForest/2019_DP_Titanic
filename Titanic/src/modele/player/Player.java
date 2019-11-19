package modele.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Scanner;


import modele.gestionBoat.Boat;
import modele.gestionBoat.Plateau;

public abstract class Player extends Observable{
	private ArrayList<Boat> boats;
	private int munition;
	private Plateau plateau;

	public Player(Plateau plateau, int munition, Collection<Boat> boats) {
		this.plateau=plateau;
		this.munition=munition;
		this.boats=(ArrayList<Boat>) boats;
	}


	//function who place the boat in the player grille
	public boolean placeBoat(int x , int y, int idBoat){
			if(plateau.boatPositionEmpty(plateau.getGrillPlayer(),x,y, idBoat)) {
				boats.get(idBoat).setPosX(x);
				boats.get(idBoat).setPosY(y);
				if(boats.get(idBoat).isHorizontal()) {
					for(int i = 0 ;i <  boats.get(idBoat).getSize(); i++) {
						//plateau.getGrillPlayer()[b.getPosX() + i][b.getPosY()] = 1;
						this.plateau.setGrilleValue(boats.get(idBoat).getPosX() + i, boats.get(idBoat).getPosY(), idBoat);

						//for ilef i dont know if i should set ater to false. (NAM)
						boats.get(idBoat).setHorizontal(true);
					}
				}
				else {
					for(int i = 0 ;i <  boats.get(idBoat).getSize(); i++) {
						this.plateau.setGrilleValue(boats.get(idBoat).getPosX(), boats.get(idBoat).getPosY()+ i,idBoat);
						boats.get(idBoat).setHorizontal(false);
					}
				}
				return true;
			}
			else {
				System.out.println("placement du bateau: " + boats.get(idBoat).getName() + " incorrect ");
				return false;
			}
	}

	public abstract String playerType();
	
	public ArrayList<Boat> getBoats() {
		return boats;
	}
	public int getMunition() {
		return munition;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public boolean noMunition() {
		return munition==0; 
	}

	public void setBoats(ArrayList<Boat> boats) {
		this.boats = boats;
	}
	public void setBoats(Collection<Boat> boats) {
		this.boats = (ArrayList<Boat>) boats;
	}

	public void setMunition(int munition) {
		this.munition = munition;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
	public abstract void shoot(Plateau p);

	public void useMunition() {
		this.munition -=1;
	}
	

}

