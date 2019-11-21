package modele;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import java.util.Scanner;

import modele.gestionBoat.Boat;
import modele.gestionBoat.Plateau;
import modele.player.Player;

public class Modele extends Observable {
	
	public Player p1;
	public Player p2;
	public Plateau plateau;
	public static String[] DIRECTION = {"EAST", "SOUTH", "WEST", "NORTH"};
	
	public Modele(Player p1, Player p2, Plateau plateau, Plateau plateau2) {
		this.p1 = p1;
		this.p2 = p2;
		this.plateau = plateau;
		this.p1.setPlateau(plateau);
		this.p2.setPlateau(plateau2);
		//this.p1.setBoats(this.plateau.getListeBoat());
		//this.p2.setBoats(this.plateau2.getListeBoat());
	}
	
	
	public ArrayList<Integer> checkPosition(int x , int y , int idBoat) {
		return p1.validePosition(x, y, idBoat);
	}
	
	public boolean settingBoatPositionP1(int x, int y, String direction, int idBoat) {
			boolean isOk = false;
			if(direction.compareTo(DIRECTION[0]) == 0) {
				isOk = p1.placeBoat(x,y,0 ,idBoat);
			}
			if(direction.compareTo(DIRECTION[1]) == 0) {
				isOk = p1.placeBoat(x,y,1 ,idBoat);
			}
			if(direction.compareTo(DIRECTION[2]) == 0) {
				isOk = p1.placeBoat(x,y,2 ,idBoat);
			}
			if(direction.compareTo(DIRECTION[3]) == 0) {
				isOk = p1.placeBoat(x,y,3 ,idBoat);
			}
	        setChanged();
	        notifyObservers();
			return isOk ;	
	}
	
	
	
	public void settingBoatPositionP2() {//Randome setting because P2 is a IA
		int i =0;
		for(Boat b: p2.getBoats()) {
			boolean isPlace = false;
			while(!isPlace) {
				System.out.println("Patient IA place ses bateaux");
				Random rnd = new Random();
				int x =rnd.nextInt(11) ;
				int y = rnd.nextInt(11);
				int direction = rnd.nextInt(4);
				isPlace = p2.placeBoat(x,y,direction,i);
			}
			i++;
		}
		
	}

	public Player getP1() {
		return p1;
	}

	public Player getP2() {
		return p2;
	}

	public void setP1(Player p1) {
		this.p1 = p1;
	}

	public void setP2(Player p2) {
		this.p2 = p2;
	}



	
}
