package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Modele;
import modele.player.Player;
import view.VueGrilleJoueur;

public class ControllerStartGame implements ActionListener{

	protected Modele m;
	protected Player p ;
	protected VueGrilleJoueur vue;

	public ControllerStartGame(Modele modele, VueGrilleJoueur vue){
		this.p = p;
		this.vue = vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			}

}
