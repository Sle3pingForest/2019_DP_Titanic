package controlleur;

import dao.AbstractDAOFactory;
import modele.Modele;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerLoadGame implements ActionListener{

    public Modele mod;
    public ControllerLoadGame(Modele mod){
        this.mod = mod;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int type = AbstractDAOFactory.CSV;

        AbstractDAOFactory dao = AbstractDAOFactory.getAbstractDAOFactory(type);
        if (dao != null) {
            System.out.println("Chargement en cours...");
           dao.getDAO().load(mod);
        } else {
            System.out.println("chargement impossible");
        }
    }
}
