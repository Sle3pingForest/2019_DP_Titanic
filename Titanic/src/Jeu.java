import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;

import modele.Modele;
import modele.gestionBoat.Plateau;
import modele.player.Human;
import modele.player.IA;
import modele.player.Player;
import view.PlateauMenuBar;
import view.VueGrilleEnnemi;
import view.VueGrilleJoueur;
import view.VuePlateau;

public class Jeu extends JFrame{
	
	public static Jeu instance;
	
	public static Jeu getInstance() {
		if (instance == null) {
			instance = new Jeu();
		}
		return instance;
	}
	
	public Jeu () {


		this.setTitle("TITANIC");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
                
		setPreferredSize(new Dimension(screenWidth,screenHeight));

		
		Plateau plateau = new Plateau("XVI");
		Plateau plateau2 = new Plateau("XVI");
		
		Player human = new Human(plateau,50,plateau.getListeBoat());
		Player IA = new IA(plateau2, 50, plateau.getListeBoat());
		
		Modele modele = new Modele(human, IA, plateau, plateau2);
		
		VuePlateau vueplateau = new VuePlateau(modele);
		setJMenuBar(new PlateauMenuBar(modele));
                this.add(vueplateau);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Jeu j = new Jeu();
	}
}
