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
        int type = AbstractDAOFactory.TXT;

        AbstractDAOFactory dao = AbstractDAOFactory.getAbstractDAOFactory(type);
        if (dao != null) {
           dao.getClassTxtDAO().load();
        } else {
            System.out.println("chargement impossible");
        }
    }
}
