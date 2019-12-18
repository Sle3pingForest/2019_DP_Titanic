import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.*;

import modele.Modele;
import modele.gestionBoat.Plateau;
import modele.player.Human;
import modele.player.IA;
import modele.player.Player;
import view.*;

public class Jeu extends JFrame{
	
	public static Jeu instance;
	private VueMenu jpMenu;
	private Modele modele;
	private String epoque;
	
	public static Jeu getInstance() {
		if (instance == null) {
			instance = new Jeu();
		}
		return instance;
	}
	
	public Jeu () {

		JOptionPane jOpChoix = new JOptionPane(), jOpValidation = new JOptionPane();
		String [] an = {"XVI", "XX"};
		int rang = jOpChoix.showOptionDialog(null,
				"Veuillez choisir l'époque durant laquelle vous souhaitez jouer.",
				"Choix de l'époque de jeu",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				an,
				an[0]);
		JOptionPane.showMessageDialog(null, "Vous avez choisi le " + an[rang] + "ème siècle.", "Epoque choisie !",
				JOptionPane.INFORMATION_MESSAGE);

		epoque = an[rang];
		System.out.println(epoque);

		jpMenu = new VueMenu(this.modele);
		this.setJMenuBar(jpMenu);
		this.setTitle("TITANIC");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
                
		setPreferredSize(new Dimension(screenWidth,screenHeight));

		
		Plateau plateau = new Plateau(epoque);
		Plateau plateau2 = new Plateau(epoque);
		
		Player human = new Human(plateau,50,plateau.getListeBoat());
		Player IA = new IA(plateau2, 50, plateau.getListeBoat());
		
		modele = new Modele(human, IA, plateau, plateau2);
		
		VuePlateau vueplateau = new VuePlateau(modele);
		setJMenuBar(new PlateauMenuBar(modele));
                this.add(vueplateau);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		this.pack();
		this.setVisible(true);
	}

	public Modele getModele() {
		return modele;
	}

	public void restart() {
		this.dispose();
	}

	/*
        public void saveGame(){
            AbstractDAOFactory.getAbstractDAOFactory(1).getGameDAO().save(this);
            modele.getP1().getPlateau().getGrillPlayer();
            modele.getP1().getPlateau().getGrillOpponent();
            modele.getP2().getPlateau().getGrillPlayer();
            modele.getP2().getPlateau().getGrillOpponent();
        }

        public void loadGame(){
            AbstractDAOFactory.getAbstractDAOFactory(1).getGameDAO().load(this);
            modele.getP1().getPlateau().getGrillPlayer();
            modele.getP1().getPlateau().getGrillOpponent();
            modele.getP2().getPlateau().getGrillPlayer();
            modele.getP2().getPlateau().getGrillOpponent();
        }*/

	public static void main(String[] args) {
		Jeu j = new Jeu();
	}
}
