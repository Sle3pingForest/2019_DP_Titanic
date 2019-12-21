package modele.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Scanner;


import modele.gestionBoat.Boat;
import modele.gestionBoat.Plateau;
import modele.player.stategy.Strategy;

public abstract class Player {
	private ArrayList<Boat> boats;
	private int munition;
	private Plateau plateau;
	protected boolean isIA, ready;


	public Player(Plateau plateau, int munition, Collection<Boat> boats) {
		this.plateau=plateau;
		this.munition=munition;
		this.boats=(ArrayList<Boat>) boats;
		isIA = false;
	}

	public ArrayList<Integer> validePosition(int x , int y, int idBoat) {
		
		return plateau.boatPositionEmpty(plateau.getGrillPlayer(),x,y, idBoat);
	}

	//function who place the boat in the player grille
	public boolean placeBoat(int x , int y, int direction, int idBoat){
			boats.get(idBoat).setPosX(x);
			boats.get(idBoat).setPosY(y);
			if(direction == 0) {
				for(int i = 0 ;i <  boats.get(idBoat).getSize(); i++) {
					this.plateau.setGrilleValue(boats.get(idBoat).getPosX() + i, boats.get(idBoat).getPosY(), idBoat);
					plateau.getGrillPlayer()[x+i][y].setX(x+i);
					plateau.getGrillPlayer()[x][y].setY(y);
					boats.get(idBoat).setDirection(direction);
				}
				
			}
			else if(direction == 1){
				for(int i = 0 ;i <  boats.get(idBoat).getSize(); i++) {
					this.plateau.setGrilleValue(boats.get(idBoat).getPosX(), boats.get(idBoat).getPosY()+ i,idBoat);
					plateau.getGrillPlayer()[x][y].setX(x);
					plateau.getGrillPlayer()[x][y+i].setY(y+i);
					boats.get(idBoat).setDirection(direction);
				}
			}
			

			else if(direction == 2){
				for(int i = 0 ;i <  boats.get(idBoat).getSize(); i++) {
					this.plateau.setGrilleValue(boats.get(idBoat).getPosX() - i, boats.get(idBoat).getPosY(), idBoat);
					plateau.getGrillPlayer()[x-i][y].setX(x-i);
					plateau.getGrillPlayer()[x][y].setY(y);
					boats.get(idBoat).setDirection(direction);
				}
			}

			else if(direction == 3){
				for(int i = 0 ;i <  boats.get(idBoat).getSize(); i++) {
					this.plateau.setGrilleValue(boats.get(idBoat).getPosX(), boats.get(idBoat).getPosY()-i,idBoat);
					plateau.getGrillPlayer()[x][y].setX(x);
					plateau.getGrillPlayer()[x][y-i].setY(y-i);
				}
			}
			return true;
		
	}
	
	
	public boolean tireTouched(int x, int y) {
		return this.plateau.strike(x,y);
	}

	public abstract String playerType();
	
	public void isReady(boolean b) {
		ready = b;
	}
	
	public boolean getReady() {
		return ready;
	}
	
	public boolean isIA() {
		return isIA;
	}

	public void setIA(boolean isIA) {
		this.isIA = isIA;
	}
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

