package view;

import controlleur.ControllerStartGame;
import controlleur.ControllerTirer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import modele.Modele;
import modele.player.Player;
import modele.player.stategy.StategyRandom;


public class VuePlateau extends JPanel implements Observer{
    
    
    protected JButton start;
    protected Player p;
    protected Modele modele;
        VueGrilleJoueur grillePlayer ;
        VueGrilleEnnemi grilleEnnemi ;
    public VuePlateau(Modele modele){
        this.p = modele.getP1();
        grillePlayer = new VueGrilleJoueur(modele);
       grilleEnnemi = new VueGrilleEnnemi(modele);

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

        
        public VueGrilleEnnemi getVueEnnemi()
        {
            return this.grilleEnnemi;
        }
        public VueGrilleJoueur getVuePlayer()
        {
            return this.grillePlayer;
        }
}
