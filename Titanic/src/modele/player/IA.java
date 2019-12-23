package modele.player;

import java.util.Collection;

import modele.gestionBoat.Boat;
import modele.gestionBoat.Plateau;
import modele.player.strategy.StrategyRandom;
import modele.player.strategy.Strategy;

public class IA extends Player {

    Strategy tireStrategy;

    public IA(Plateau plateau, int munition, Collection<Boat> boats, Strategy s) {
        super(plateau, munition, boats);
        isIA = true;
        tireStrategy = new StrategyRandom();
    }

    public void setStrategy(Strategy s) {
        tireStrategy = s;
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
