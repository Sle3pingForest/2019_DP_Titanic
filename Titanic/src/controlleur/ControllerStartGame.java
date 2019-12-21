package controlleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modele.Modele;
import modele.player.Player;
import view.VuePlateau;

public class ControllerStartGame implements ActionListener{

	protected Modele m;
	protected Player p ;
	protected VuePlateau vue;

	public ControllerStartGame(Modele modele, VuePlateau vue){
		this.p = p;
		this.vue = vue;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			}

}
