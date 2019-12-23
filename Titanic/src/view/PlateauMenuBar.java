package view;

import controlleur.ControllerLoadGame;
import controlleur.ControllerNewGame;
import controlleur.ControllerSaveGame;
import modele.Modele;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlateauMenuBar extends JMenuBar {
    JMenu file;
    JMenu option;
    Modele mod;

    public PlateauMenuBar(Modele modele){
        super();
        this.mod = modele;
        option = new JMenu("Option");
        file = new JMenu("File");
        makeMenuFile();
        makeMenuOption();
    }

    private void makeMenuOption() {
        JMenu changerStrategy = new JMenu("Strategie IA");
        JMenuItem strategieAlea = new JMenuItem("Aleatoire");
        strategieAlea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mod.setStrategy("Aleatoire");
            }
        });
        JMenuItem strategyCroix = new JMenuItem("Croix");
        strategyCroix.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mod.setStrategy("Croix");
            }
        });
        changerStrategy.add(strategyCroix);
        changerStrategy.add(strategieAlea);
        option.add(changerStrategy);
        add(option);
    }

    private void makeMenuFile() {
        add(file);
        JMenuItem newGame = new JMenuItem("Nouvelle Partie");
        newGame.addActionListener(new ControllerNewGame(mod));

        JMenuItem save = new JMenuItem("Sauvegarder");
        save.addActionListener(new ControllerSaveGame(mod));

        JMenuItem load = new JMenuItem("Charger");
        load.addActionListener(new ControllerLoadGame(mod));
        file.add(newGame);
        file.add(save);
        file.add(load);
    }
}
