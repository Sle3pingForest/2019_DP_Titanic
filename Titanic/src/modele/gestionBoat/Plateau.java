package modele.gestionBoat;

import java.util.ArrayList;
import java.util.Collection;

public class Plateau {
	public static final int  HIGHT = 11;
	public static final int  WIDTH = 11;
	public static final String XVI ="XVI";
	public static final String XX = "XX";
	private String epoch;
	protected Case[][] grillOpponent;
	protected Case[][] grillPlayer ;
	protected ArrayList<Boat> listeBoatPlayer;

	public Plateau(String epoch) {
		this.grillPlayer = new Case[WIDTH][HIGHT];
		this.grillOpponent = new Case[WIDTH][HIGHT];
		initializerPlateau();
		this.listeBoatPlayer = new ArrayList<Boat>();
		settingBoat(epoch);
		this.epoch = epoch;

	}
	//check if can place the boat with no collison on other , and the boat stay on plateau on out range
	public boolean boatPositionEmpty(Case[][] grille,int x , int y,int  idboat) { 
		boolean empty=true;
		if(listeBoatPlayer.get(idboat).isHorizontal()) {
			if(isEmpty(grille,x,y) && (x+ listeBoatPlayer.get(idboat).getSize() <= WIDTH) ){
				int i = x+1 ;
				while(i <= listeBoatPlayer.get(idboat).getSize() && empty==true) {
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
		if(!listeBoatPlayer.get(idboat).isHorizontal() ) {
			if(isEmpty(grille,x,y) && (y+ listeBoatPlayer.get(idboat).getSize() <= HIGHT) ){
				int i = y+1 ;
				while(i <= listeBoatPlayer.get(idboat).getSize() && empty==true) {
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

	public String getEpoch() {
		return epoch;
	}
	public Case[][] getGrillOpponent() {
		return grillOpponent;
	}
	
	public Case[][] getGrillPlayer() {
		return grillPlayer;
	}




	//getter and setter

	public ArrayList<Boat> getListeBoat() {
		return listeBoatPlayer;
	}
	
	public void initializerPlateau() {
		int i ,j;
		for(i=0; i<WIDTH; i++) {
			for(j=0; j<HIGHT; j++) {
				grillPlayer[i][j] = new Case(-1);//Empty
				grillOpponent[i][j] = new Case(-1);
			}
		}

	}


	public boolean isEmpty(Case[][] grille,int x , int y) { 	
		if(grille[x][y].isWater() && grille[x][y].getid()==-1)
			return true ;//true if is Empty
		return false;
	}


	public void setEpoch(String epoch) {
		this.epoch = epoch;
	}


	public void setGrilleValue(int i, int j, int val) {
		this.grillPlayer[i][j].setId(val);
	}


	public void setGrillOpponent(Case[][] grillOpponent) {
		this.grillOpponent = grillOpponent;
	}



	public void setGrillPlayer(Case[][] grillPlayer) {
		this.grillPlayer = grillPlayer;
	}
	public void setListeBoat(ArrayList<Boat> listeBoat) {
		this.listeBoatPlayer = listeBoat;
	}
	public void setListeBoat2(ArrayList<Boat> listeBoat) {
		this.listeBoatPlayer = listeBoat;
	}
	
	//function who bluid 5 boat at position 0 0
	public void settingBoat(String epoch) {
		Boat portAvion,  croiseur, sousMarins,  sousMarins2,  torpilleur;
		this.epoch = epoch;
		if(epoch.compareTo(XVI) == 0) {
			portAvion = new BoatXVI("Porte Avion",0,0, 0, 5, true);
			croiseur = new BoatXVI("Croiseur", 1,0,0, 4, true);
			sousMarins2 = new BoatXVI("Sous Marins 2",2,0, 0, 3, true);
			sousMarins = new BoatXVI("Sous Marins",3,0, 0, 3, true);
			torpilleur = new BoatXVI("Torpilleur",4,0,0,2,true);
		}
		else {
			portAvion = new BoatXX("Porte Avion",0,0, 0, 5, true);
			croiseur = new BoatXX("Croiseur", 1,0,0, 4, true);
			sousMarins2 = new BoatXX("Sous Marins 2",2,0, 0, 3, true);
			sousMarins = new BoatXX("Sous Marins",3,0, 0, 3, true);
			torpilleur = new BoatXX("Torpilleur",4,0,0,2,true);
		}

		this.listeBoatPlayer.add(portAvion);
		this.listeBoatPlayer.add(croiseur);
		this.listeBoatPlayer.add(sousMarins);
		this.listeBoatPlayer.add(torpilleur);
		this.listeBoatPlayer.add(sousMarins2);
	}
}
