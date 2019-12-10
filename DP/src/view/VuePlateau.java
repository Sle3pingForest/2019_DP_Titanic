package view;

import controlleur.ControllerStartGame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import modele.Modele;
import modele.player.Player;


public class VuePlateau extends JPanel implements Observer{
    
    
    protected JButton start;
    protected Player p;
    public VuePlateau(Modele modele){
        this.p = modele.getP1();
        VueGrilleJoueur grillePlayer = new VueGrilleJoueur(modele);
        VueGrilleEnnemi grilleEnnemi = new VueGrilleEnnemi(modele);

        this.start = new JButton("Start");
     	this.start.setEnabled(false);
     	this.start.addActionListener(new ControllerStartGame(modele, this));
        this.add(grillePlayer, BorderLayout.WEST);
        
     	this.add(start,BorderLayout.CENTER);
        this.add(grilleEnnemi, BorderLayout.EAST);
         p.addObserver(this);
 
     	this.start.setPreferredSize(new Dimension(80,40));
    }
    
    	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	        if(p.getReady()){
	        	this.start.setEnabled(true);
	        }
		
	}

}
