package view;

import modele.Modele;

import javax.swing.*;

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
        add(option);
    }

    private void makeMenuFile() {
        add(file);
    }


}
