package controlleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modele.Modele;
import view.CaseGraphic;
import view.VueGrilleEnnemi;

public class ControllerTirer implements MouseListener {
	
	protected Modele modele;
	protected VueGrilleEnnemi vue;
	
	public ControllerTirer(Modele modele, VueGrilleEnnemi vue) {
		this.modele = modele;
		this.vue = vue;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX()/CaseGraphic.SIZE;
		int y = e.getY()/CaseGraphic.SIZE;
		if(this.modele.tire(x, y)) {
			System.out.println("touche trop fort");
		}
		else {
			System.out.println("loupe gros noob");
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
