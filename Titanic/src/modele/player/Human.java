package modele.player;

import java.util.Collection;

import modele.gestionBoat.Boat;
import modele.gestionBoat.Plateau;

public class Human extends Player {
   
	public Human(Plateau plateau, int munition, Collection<Boat> boats) {
      super(plateau,munition,boats);
	}
	
	@Override
	public String playerType() {
		return "Human";
	}

	@Override
	public void shoot(Plateau p) {
		// TODO Auto-generated method stub
		if(!noMunition()) {
			useMunition();
			//complete
		}
		
	}


}
