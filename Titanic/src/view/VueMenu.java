package view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import modele.Modele;

public class VueMenu extends JMenuBar implements Observer{

    public VueMenu(Modele modele) {

        JMenu menu = new JMenu("Menu");

        /*JMenuItem restart = new JMenuItem("Recommencer");
        restart.addActionListener(new ControllerRestart(jeu));
        menu.add(restart);*/


       /* JMenuItem save = new JMenuItem("Sauvegarder");
        //save.addActionListener(new ControllerSave(jeu));
        menu.add(save);

        JMenuItem load = new JMenuItem("Charger");
        //load.addActionListener(new ControllerLoad(jeu));
        menu.add(load); 

        JMenuItem quitter = new JMenuItem("Quitter");
        quitter.addActionListener(new ControllerClose(j));
        menu.add(quitter);
        */
        this.add(menu);
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub

    }

}
