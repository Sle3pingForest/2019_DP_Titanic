package controlleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modele.Modele;
import view.CaseGraphic;
import view.VueGrilleEnnemi;
import view.VuePlateau;

public class ControllerTirer {
	
	protected Modele modele;
	protected VuePlateau vue;
	protected VueGrilleEnnemi vueEnnemi;
	public ControllerTirer(Modele modele,VuePlateau p) {
		this.modele = modele;
		vueEnnemi = vueEnnemi;
	}

	
}
