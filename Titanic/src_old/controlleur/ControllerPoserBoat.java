package controlleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JList;
import javax.swing.JOptionPane;

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
		this.vue = vuePlayer;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {	
			int x = e.getX()/CaseGraphic.SIZE;
			int y = e.getY()/CaseGraphic.SIZE;
			
			if(x!= 0 && y != 0 ) {
			ArrayList<Integer> listDirectionOK = modele.checkPosition(x, y, idBoat);
			ArrayList<String> list = new ArrayList<String>() ;	
			for(int i = 0 ; i < listDirectionOK.size(); i++) {
				list.add(Modele.DIRECTION[listDirectionOK.get(i)]);
			}
			String[] stockArr = new String[list.size()];
			stockArr = list.toArray(stockArr);
			if(idBoat < 5) {

				String input = (String) JOptionPane.showInputDialog(null, "Choose now...", "Choice a direction", JOptionPane.QUESTION_MESSAGE, null,stockArr,null); 
				
				boolean isok =modele.settingBoatPositionP1(x,y,input,idBoat);
				if(isok) {
					idBoat++;
				}
			}
			if(idBoat == 4) {
				modele.p1.isReady(true);
			}
		}
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
