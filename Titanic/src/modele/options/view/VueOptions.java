package modele.options.view;

import modele.options.Controller.ControllerDefault;
import modele.options.Controller.ControllerEpoque;
import modele.options.Controller.ControllerStrategy;
import modele.options.Controller.ControllerValider;
import modele.options.Options;
import modele.player.stategy.Strategy;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class VueOptions extends JPanel implements Observer {
    private JButton valider;
    private Options options;
    private ArrayList<String> tabEpoque;
    private ArrayList<String> tabStrat;
    private JButton[] buttonsEpoque;
    private JButton[] buttonsStrat;
    public final static int NB_EPOQUE = 2;
    public final static int NB_STRAT = 2;

    public VueOptions(Options options){
        this.options = options;
        tabEpoque = null;
        tabStrat = null;
        makeTabEpoque();
        makeEpoque();

        makeTabStrat();
        makeStrategy();

        makeValider();
        options.addObserver(this);
        update(null, null);
    }

    private void makeValider() {
        JPanel validationPan = new JPanel();
        valider = new JButton("Valider");
        valider.addActionListener(new ControllerValider(options));
        JButton defaultB = new JButton("Defaut");
        defaultB.setFocusPainted(false);
        defaultB.addActionListener(new ControllerDefault(options));
        validationPan.add(valider);
        validationPan.add(defaultB);
        this.add(validationPan);
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

    private void makeEpoque(){
        JPanel epoque = new JPanel();
        JLabel text = new JLabel("Choisir une epoque : ");
        epoque.add(text);
        buttonsEpoque = new JButton[NB_EPOQUE];
        for (int i = 0; i != NB_EPOQUE; i++){
            buttonsEpoque[i] = new JButton();
            buttonsEpoque[i].addActionListener(new ControllerEpoque(options));
            buttonsEpoque[i].setFocusPainted(false);
            buttonsEpoque[i].setText(tabEpoque.get(i));
            epoque.add(buttonsEpoque[i]);
        }
        this.add(epoque);
    }

    private void makeStrategy(){
        JPanel stratPan = new JPanel();
        JLabel text = new JLabel("Choisir une strategie pour l'enemie: ");
        stratPan.add(text);
        buttonsStrat = new JButton[NB_STRAT];
        for (int i = 0; i != NB_STRAT; i++){
            buttonsStrat[i] = new JButton();
            buttonsStrat[i].addActionListener(new ControllerStrategy(options));
            buttonsStrat[i].setFocusPainted(false);
            buttonsStrat[i].setText(tabStrat.get(i));
            stratPan.add(buttonsStrat[i]);
        }
        this.add(stratPan);
    }



    @Override
    public void update(Observable observable, Object o) {
        if (!options.displayed()){
            Thread.currentThread().interrupt();
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        }
        for (int i = 0; i != NB_EPOQUE; i++) {
            if (buttonsEpoque[i].getText().equals(options.getEpoque()))
                buttonsEpoque[i].setEnabled(false);
            else
                buttonsEpoque[i].setEnabled(true);
        }

        for (int i = 0; i != NB_STRAT; i++){
            if (buttonsStrat[i].getText().equals(options.getNomStrat()))
                buttonsStrat[i].setEnabled(false);
            else
                buttonsStrat[i].setEnabled(true);
        }
    }
}
