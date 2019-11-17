package modele.gestionBoat;

import java.util.ArrayList;
import java.util.Collection;

public class Plateau {
	protected int[][] grillPlayer ;
	protected int[][] grillOpponent;
	protected ArrayList<Boat> listeBoatPlayer;
	public static final int  WIDTH = 11;
	public static final int  HIGHT = 11;
	public static final String XVI ="XVI";
	public static final String XX = "XX";

	public Plateau(String epoch) {
		this.grillPlayer = new int[WIDTH][HIGHT];
		this.grillOpponent = new int[WIDTH][HIGHT];
		initializerPlateau();
		this.listeBoatPlayer = new ArrayList<Boat>();
		settingBoat(epoch);

	}
	//function who bluid 5 boat at position 0 0
	public void settingBoat(String epoch) {
		Boat portAvion,  croiseur, sousMarins,  sousMarins2,  torpilleur;
		if(epoch.compareTo(XVI) == 0) {
			portAvion = new BoatXVI("Porte Avion",0, 0, 5, true);
			croiseur = new BoatXVI("Croiseur", 0,0, 4, true);
			sousMarins2 = new BoatXVI("Sous Marins 2",0, 0, 3, true);
			sousMarins = new BoatXVI("Sous Marins",0, 0, 3, true);
			torpilleur = new BoatXVI("Torpilleur",0,0,2,true);
		}
		else {
			portAvion = new BoatXX("Porte Avion",0, 0, 5, true);
			croiseur = new BoatXX("Croiseur", 0,0, 4, true);
			sousMarins2 = new BoatXX("Sous Marins 2",0, 0, 3, true);
			sousMarins = new BoatXX("Sous Marins",0, 0, 3, true);
			torpilleur = new BoatXX("Torpilleur",0,0,2,true);
		}

		this.listeBoatPlayer.add(portAvion);
		this.listeBoatPlayer.add(croiseur);
		this.listeBoatPlayer.add(sousMarins);
		this.listeBoatPlayer.add(torpilleur);
		this.listeBoatPlayer.add(sousMarins2);
	}

	public void initializerPlateau() {
		int i ,j;
		for(i=0; i<WIDTH; i++) {
			for(j=0; j<HIGHT; j++) {
				grillPlayer[i][j]=-1;//Empty
				grillOpponent[i][j]=-1;
			}
		}

	}
	public boolean isEmpty(int[][] grille,int x , int y) { 	 
		return grille[x][y]==-1;//true if is Empty
	}
	
	//check if can place the boat with no collison on other , and the boat stay on plateau on out range
	public boolean boatPositionEmpty(int[][] grille,int x , int y,Boat boat) { 
		boolean empty=true;
		if(boat.isHorizontal()) {
			if(isEmpty(grille,x,y) && (x+ boat.getSize() <= WIDTH) ){
				int i = x+1 ;
				while(i <= boat.getSize() && empty==true) {
					if(isEmpty(grille,i,y))
						i++;
					else 
						empty= false;

				}
			}
			else {
				empty = false;
			}
		}
		if(!boat.isHorizontal() ) {
			if(isEmpty(grille,x,y) && (y+ boat.getSize() <= HIGHT) ){
				int i = y+1 ;
				while(i <= boat.getSize() && empty==true) {
					if(isEmpty(grille,x,i))
						i++;
					else 
						empty= false;

				}

			}
			else {
				empty = false;
			}
		}
		return empty;
	}




	//getter and setter

	public void setGrilleValue(int i, int j, int val) {
		this.grillPlayer[i][j] = val;
	}
	
	public int[][] getGrillPlayer() {
		return grillPlayer;
	}


	public void setGrillPlayer(int[][] grillPlayer) {
		this.grillPlayer = grillPlayer;
	}


	public int[][] getGrillOpponent() {
		return grillOpponent;
	}


	public void setGrillOpponent(int[][] grillOpponent) {
		this.grillOpponent = grillOpponent;
	}


	public ArrayList<Boat> getListeBoat() {
		return listeBoatPlayer;
	}



	public void setListeBoat(ArrayList<Boat> listeBoat) {
		this.listeBoatPlayer = listeBoat;
	}
	
	public void setListeBoat2(ArrayList<Boat> listeBoat) {
		this.listeBoatPlayer = listeBoat;
	}
}
