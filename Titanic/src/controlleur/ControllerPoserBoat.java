package controlleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import modele.Modele;
import modele.gestionBoat.Boat;
import modele.player.Player;
import view.CaseGraphic;
import view.VueGrilleJoueur;

public class ControllerPoserBoat implements MouseListener {

	public Modele modele;
	public VueGrilleJoueur vue;
	public static int idBoat = 0;
	
	public ControllerPoserBoat(Modele modele, VueGrilleJoueur vuePlayer){
		this.modele = modele;
		this.vue = vue;
	}
	@Override
	public void mouseClicked(MouseEvent e) {	
			int x = e.getX()/CaseGraphic.SIZE;
			int y = e.getY()/CaseGraphic.SIZE;
			if(idBoat < 5) {
				boolean isOk = modele.settingBoatPositionP1(x,y,-1,idBoat);
				if(isOk ) {
					idBoat++;
				}
			}
			System.out.println("Id boat" + idBoat);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
