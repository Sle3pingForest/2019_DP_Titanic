import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.*;

import modele.Modele;
import modele.gestionBoat.Plateau;
import modele.options.Options;
import modele.options.runnable.RunnableOptions;
import modele.player.Human;
import modele.player.IA;
import modele.player.Player;
import view.*;

public class Jeu extends JFrame{

	private Modele modele;
	private String epoque;
	
	public Jeu (Options options) {

		this.setTitle("TITANIC");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
                
		setPreferredSize(new Dimension(screenWidth,screenHeight));
		
		modele = new Modele(options);
		
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


	public static void main(String[] args) {
		Options options = new Options();
		Runnable frame = new RunnableOptions(options);
		new Thread(frame).start();
		while (options.displayed()) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		final Options jeuOptions = options;

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Jeu(jeuOptions);
			}
		});
	}
}
