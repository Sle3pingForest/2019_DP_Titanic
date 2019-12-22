package modele.options;

import modele.player.stategy.StategyCroix;
import modele.player.stategy.StategyRandom;
import modele.player.stategy.Strategy;

import java.util.ArrayList;
import java.util.Observable;

public class Options extends Observable {
    private String epoque;
    private int numberOfPlayer;
    private Strategy croix;
    private Strategy random;
    private Strategy strat;
    private String nomStrat;
    private boolean displayed;
    private boolean errorStrat;
    private boolean errorEpoque;
    private ArrayList<String> tabEpoque;
    private ArrayList<String> tabStrat;
    public final static int NB_EPOQUE = 2;
    public final static int NB_STRAT = 2;

    public Options(){
        random = new StategyRandom();
        croix = new StategyCroix();
        tabEpoque = null;
        tabStrat = null;
        makeTabEpoque();
        makeTabStrat();
        init();
    }

    private void init() {
        numberOfPlayer = 1;
        strat = random;
        epoque = "";
        nomStrat = "";
        displayed = true;
        errorStrat = false;
        errorEpoque = false;
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

    private void setDisplayed(boolean displayed) {
        this.displayed = displayed;
        update();
    }

    public void update(){
        setChanged();
        notifyObservers();
    }

    public String getNomStrat() {
        return nomStrat;
    }

    public Strategy getStrategy() {
        return strat;
    }

    public void valider() {
        if (!tabEpoque.contains(epoque))
            errorEpoque = true;
        else
            errorEpoque = false;
        if (!tabStrat.contains(nomStrat))
            errorStrat = true;
        else
            errorStrat = false;
        if (!errorStrat && !errorEpoque){
            setDisplayed(false);
        }
        update();
    }

    private void makeTabStrat() {
        if (tabStrat == null){
            tabStrat = new ArrayList<String>(NB_STRAT);
        }
        tabStrat.add("Croix");
        tabStrat.add("Aleatoire");
    }

    private void makeTabEpoque(){
        if (tabEpoque == null)
            tabEpoque = new ArrayList<String>(NB_EPOQUE);
        tabEpoque.add("XVI");
        tabEpoque.add("XX");
    }

    public ArrayList<String> getTabEpoque(){
        return tabEpoque;
    }

    public ArrayList<String> getTabStrat(){
        return tabStrat;
    }

    public boolean getErrorStrat(){
        return errorStrat;
    }

    public boolean getErrorEpoque(){
        return errorEpoque;
    }

}
