package controlleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	public static JList list = new JList(new String[] {"EAST", "SOUTH", "WEST", "NORTH"});
	public static JList noEast = new JList(new String[] { "SOUTH", "WEST", "NORTH"});
	public static JList noSouth = new JList(new String[] {"EAST",  "WEST", "NORTH"});
	public static JList noWeast = new JList(new String[] {"EAST", "SOUTH",  "NORTH"});
	public static JList noNorth = new JList(new String[] {"EAST", "SOUTH", "WEST"});
	
	public ControllerPoserBoat(Modele modele, VueGrilleJoueur vuePlayer){
		this.modele = modele;
		this.vue = vuePlayer;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {	
			int x = e.getX()/CaseGraphic.SIZE;
			int y = e.getY()/CaseGraphic.SIZE;
			
			if(idBoat < 5) {
				JOptionPane.showMessageDialog(null, list, "Multi-Select Example", JOptionPane.PLAIN_MESSAGE);
				int direction = list.getSelectedIndices()[0];
				System.out.println(direction);
				modele.settingBoatPositionP1(x,y,direction,idBoat);
					idBoat++;
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
