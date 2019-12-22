package modele.options.view;

import modele.options.Controller.ControllerEpoque;
import modele.options.Controller.ControllerStrategy;
import modele.options.Controller.ControllerValider;
import modele.options.Options;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class VueOptions extends JPanel implements Observer {
    private JButton valider;
    private JPanel all;
    private Options options;
    private JLabel labelErrorStrat;
    private JLabel labelErrorEpoque;
    private JRadioButton[] buttonsEpoque;
    private JRadioButton[] buttonsStrat;

    public VueOptions(Options options){
        this.options = options;
        all = new JPanel();
        all.setLayout(new GridLayout(4, 0));
        makeEpoque();
        makeStrategy();
        makeValider();
        makePanelError();
        this.add(all, BorderLayout.CENTER);
        options.addObserver(this);
    }

    private void makePanelError() {
        JPanel pannelError = new JPanel();
        GridLayout gridError = new GridLayout(2, 2);
        pannelError.setLayout(gridError);


        all.add(pannelError);
    }

    private void makeValider() {
        JPanel validationPan = new JPanel();
        valider = new JButton("Valider");
        valider.addActionListener(new ControllerValider(options));
        validationPan.add(valider, BorderLayout.NORTH);
        all.add(validationPan, BorderLayout.SOUTH);
    }

    private void makeEpoque(){
        JLabel text = new JLabel("Choisir une epoque : ");
        buttonsEpoque = new JRadioButton[Options.NB_EPOQUE];
        ArrayList<String> tabEpoque = options.getTabEpoque();
        JPanel epoquePan = new JPanel();
        epoquePan.add(text);
        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i != Options.NB_EPOQUE; i++){
            buttonsEpoque[i] = new JRadioButton();
            buttonsEpoque[i].addActionListener(new ControllerEpoque(options));
            buttonsEpoque[i].setFocusPainted(false);
            buttonsEpoque[i].setText(tabEpoque.get(i));
            group.add(buttonsEpoque[i]);
            epoquePan.add(buttonsEpoque[i]);
        }
        labelErrorEpoque = new JLabel("Veuillez selectionner une epoque.");
        labelErrorEpoque.setForeground(Color.red);
        labelErrorEpoque.setVisible(false);
        epoquePan.add(labelErrorEpoque);
        all.add(epoquePan);
    }

    private void makeStrategy(){
        JPanel stratPan = new JPanel();
        JLabel text = new JLabel("Choisir une strategie pour l'enemie: ");
        stratPan.add(text);
        buttonsStrat = new JRadioButton[Options.NB_STRAT];
        ArrayList<String> tabStrat = options.getTabStrat();
        ButtonGroup group = new ButtonGroup();
        for (int i = 0; i != Options.NB_STRAT; i++){
            buttonsStrat[i] = new JRadioButton();
            buttonsStrat[i].addActionListener(new ControllerStrategy(options));
            buttonsStrat[i].setFocusPainted(false);
            buttonsStrat[i].setText(tabStrat.get(i));
            group.add(buttonsStrat[i]);
            stratPan.add(buttonsStrat[i]);
        }
        labelErrorStrat = new JLabel("Veuillez selectionner une strategie.");
        labelErrorStrat.setForeground(Color.red);
        labelErrorStrat.setVisible(false);
        stratPan.add(labelErrorStrat);
        all.add(stratPan, BorderLayout.CENTER);
    }



    @Override
    public void update(Observable observable, Object o) {
        if (!options.displayed()){
            Thread.currentThread().interrupt();
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        }
        if (options.getErrorStrat())
            labelErrorStrat.setVisible(true);
        else
            labelErrorStrat.setVisible(false);

        if (options.getErrorEpoque())
            labelErrorEpoque.setVisible(true);
        else
            labelErrorEpoque.setVisible(false);
    }
}
