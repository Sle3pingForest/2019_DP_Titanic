package modele;

import modele.gestionBoat.Plateau;
import modele.player.Player;

public class Modele {
	
	public Player p1;
	public Player p2;
	public Plateau plateau;
	
	public Modele(Player p1, Player p2, Plateau plateau, Plateau plateau2) {
		this.p1 = p1;
		this.p2 = p2;
		this.plateau = plateau;
		this.p1.setPlateau(plateau);
		this.p2.setPlateau(plateau2);
		//this.p1.setBoats(this.plateau.getListeBoat());
		//this.p2.setBoats(this.plateau2.getListeBoat());
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
