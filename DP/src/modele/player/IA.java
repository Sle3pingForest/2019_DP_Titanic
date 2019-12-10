package modele.player;

import java.util.Collection;
import java.util.Random;

import modele.gestionBoat.Boat;
import modele.gestionBoat.Plateau;
import modele.player.stategy.StategyRandom;
import modele.player.stategy.Strategy;

public class IA extends Player {
     Strategy tireStrategy;
     
     
	public IA(Plateau plateau, int munition, Collection<Boat> boats) {
		super(plateau, munition, boats);
		isIA = true;	
                
        }

	

	
	@Override
	public String playerType() {
		// TODO Auto-generated method stub
		return "IA";
	}

	
	public void shoot(Plateau p) {
                tireStrategy=new StategyRandom();
		tireStrategy.shoot(p);
		
	}


  
	

	
	
}
