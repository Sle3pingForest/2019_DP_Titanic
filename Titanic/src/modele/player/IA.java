package modele.player;

import java.util.Collection;

import modele.gestionBoat.Boat;
import modele.gestionBoat.Plateau;
import modele.player.stategy.Strategy;

public class IA extends Player {
     Strategy tireStrategy;
     
     
	public IA(Plateau plateau, int munition, Collection<Boat> boats) {
		super(plateau, munition, boats);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String playerType() {
		// TODO Auto-generated method stub
		return "IA";
	}

	@Override
	public void shoot(Plateau p) {
		tireStrategy.shoot(p);
		
	}
	

	
	
}
