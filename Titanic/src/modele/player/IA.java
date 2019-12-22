package modele.player;

import java.util.Collection;
import java.util.Random;

import modele.gestionBoat.Boat;
import modele.gestionBoat.Plateau;
import modele.player.stategy.StategyCroix;
import modele.player.stategy.StategyRandom;
import modele.player.stategy.Strategy;

public class IA extends Player {
     Strategy tireStrategy;
     Strategy croix;
     Strategy random;
     
	public IA(Plateau plateau, int munition, Collection<Boat> boats, Strategy s) {
		super(plateau, munition, boats);
		isIA = true;
		croix = new StategyCroix();
		random = new StategyRandom();
		tireStrategy=new StategyRandom();
	}

	public void setStrategy(String s){
		if (s.equals("Croix"))
			tireStrategy = croix;
		else
			tireStrategy = random;
	}

	
	@Override
	public String playerType() {
		// TODO Auto-generated method stub
		return "IA";
	}

	
	public void shoot(Plateau p) {
		tireStrategy.shoot(p);
		
	}


  
	

	
	
}
