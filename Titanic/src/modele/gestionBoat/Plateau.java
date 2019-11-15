package modele.gestionBoat;

import java.util.ArrayList;

public class Plateau {
	protected int[][] grillPlayer ;
	protected int[][] grillOpponent;
	protected ArrayList<Boat> listeBoat;
	public static final int  X = 11;
	public static final int  Y = 11;
	
	public Plateau(String epoch) {
		this.grillPlayer = new int[X][Y];
		this.grillOpponent = new int[X][Y];
		settingBoat(epoch);
		
	}
	
	
	public void settingBoat(String epoch) {
		Boat portAvion, croiseur,sousMarins1, sousMarins2, torpilleur;
		if(epoch.contentEquals("XVI")) {
			portAvion = new BoatXVI(0, 0, 5, true);
			croiseur = new BoatXVI(0, 1, 4, true);
			sousMarins1 = new BoatXVI(0, 2, 3, true);
			sousMarins2 = new BoatXVI(0, 3, 3, true);
			torpilleur = new BoatXVI(0,4,2,true);
		}
		else {

			portAvion = new BoatXX(0, 0, 5, true);
			croiseur = new BoatXX(0, 1, 4, true);
			sousMarins1 = new BoatXX(0, 2, 3, true);
			sousMarins2 = new BoatXX(0, 3, 3, true);
			torpilleur = new BoatXX(0,4,2,true);
		}
		this.listeBoat.add(portAvion);
		this.listeBoat.add(croiseur);
		this.listeBoat.add(sousMarins1);
		this.listeBoat.add(sousMarins2);
		this.listeBoat.add(torpilleur);
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
		return listeBoat;
	}


	public void setListeBoat(ArrayList<Boat> listeBoat) {
		this.listeBoat = listeBoat;
	}
	
	public void initializerPlateau() {
	  int i ,j;
	  for(i=0; i<X; i++) {
		  for(j=0; j<Y; j++) {
		  grillPlayer[i][j]=-1;//Empty
		  grillOpponent[i][j]=-1;
	  }
	  }
		
	}
    public boolean IsEmpty(int[][] grille,int x , int y) { 	 
    	return grille[x][y]==-1;//true if is Empty
    }
    
    public boolean BoatPositionEmpty(int[][] grille,int x , int y,Boat boat) {
    	boolean empty=true;
    	if(boat.isHorizontal()) {
    		if(IsEmpty(grille,x,y)){
    			int i = x+1 ;
    			while(i <= boat.getSize() && empty==true) {
    			  if(IsEmpty(grille,i,y))
    				 i++;
    			  else 
    				  empty= false;
    			
    			}
    				
    		}
    	}
    	if(!boat.isHorizontal()) {
    		if(IsEmpty(grille,x,y)){
    			int i = y+1 ;
    			while(i <= boat.getSize() && empty==true) {
    			  if(IsEmpty(grille,x,i))
    				 i++;
    			  else 
    				  empty= false;
    			
    			}
    				
    		}
    	}
    		
    	return empty;
    }
	
}
