package modele.options;

import modele.player.stategy.StategyCroix;
import modele.player.stategy.StategyRandom;
import modele.player.stategy.Strategy;

import java.util.Observable;

public class Options extends Observable {
    private String epoque;
    private int numberOfPlayer;
    private Strategy croix;
    private Strategy random;
    private Strategy strat;
    private String nomStrat;
    private boolean displayed;

    public Options(){
        random = new StategyRandom();
        croix = new StategyCroix();
        init();
    }

    private void init() {
        numberOfPlayer = 1;
        strat = random;
        epoque = "XVI";
        nomStrat = "Croix";
        displayed = true;
    }

    public void setStrategy(String s){
        if (s.equals("Croix"))
            strat = croix;
        else if(s.equals("Aleatoire"))
            strat = random;
        nomStrat = s;
        update();
    }


    public String getEpoque() {
        return epoque;
    }

    public void setEpoque(String epoque) {
        this.epoque = epoque;
        update();
    }

    public int getNumberOfPlayer() {
        return numberOfPlayer;
    }

    public void setNumberOfPlayer(int numberOfPlayer) {
        this.numberOfPlayer = numberOfPlayer;
    }

    public void setStrategy(Strategy strat) {
        this.strat = strat;
        update();
    }

    public boolean displayed() {
        return displayed;
    }

    public void setDisplayed(boolean displayed) {
        this.displayed = displayed;
        update();
    }

    public void update(){
        setChanged();
        notifyObservers();
    }

    public void setDefault() {
        init();
        update();
    }


    public String getNomStrat() {
        return nomStrat;
    }

    public Strategy getStrategy() {
        return strat;
    }
}
