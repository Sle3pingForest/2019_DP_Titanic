package view;

import com.sun.org.apache.xpath.internal.operations.Mod;
import controlleur.ControllerStartGame;
import controlleur.ControllerTirer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import modele.Modele;
import modele.State;
import modele.player.Player;
import modele.player.stategy.StategyRandom;


public class VuePlateau extends JPanel implements Observer{

    protected Player p;
    protected Modele modele;
        VueGrilleJoueur grillePlayer ;
        VueGrilleEnnemi grilleEnnemi ;
    private JPanel grid;
    private JPanel paneInformation;
    private JLabel information;


    public VuePlateau(Modele modele){
        this.p = modele.getP1();
        grillePlayer = new VueGrilleJoueur(modele);
        grilleEnnemi = new VueGrilleEnnemi(modele);
        setLayout(new BorderLayout());
        modele.addObserver(this);

        grid = new JPanel();
        grid.add(grillePlayer, BorderLayout.EAST);
        grid.add(grilleEnnemi, BorderLayout.WEST);


        information = new JLabel("Selectionner une case sur la grille de gauche pour poser un bateau.");
        paneInformation = new JPanel();
        paneInformation.add(information);

        this.add(paneInformation, BorderLayout.SOUTH);
        this.add(grid, BorderLayout.CENTER);
    }
    
    @Override
	public void update(Observable o, Object arg) {
        Modele mod = (Modele)o;
        State s = mod.getState();
        if (s == State.SELECTCASETOPLACE) {
            information.setText("Selectionner une case sur la grille de gauche pour poser un bateau.");
        }
        else if (s == State.SELECTDIRECTION) {
            information.setText("Veuillez selectionner une direction.");
        }
        else if (s == State.PLAY) {
            information.setText("Selectionner une case sur la grille de droite pour tirer !");
        }
    }
        
        public VueGrilleEnnemi getVueEnnemi()
        {
            return this.grilleEnnemi;
        }
        public VueGrilleJoueur getVuePlayer()
        {
            return this.grillePlayer;
        }
}
