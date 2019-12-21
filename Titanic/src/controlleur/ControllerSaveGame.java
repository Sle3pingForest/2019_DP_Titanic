package controlleur;

import dao.AbstractDAOFactory;
import modele.Modele;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ControllerSaveGame implements ActionListener {

    public Modele mod;
    public ControllerSaveGame(Modele mod){
            this.mod = mod;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int type = AbstractDAOFactory.TXT;

        AbstractDAOFactory dao = AbstractDAOFactory.getAbstractDAOFactory(type);
        if (dao != null) {
            dao.getClassTxtDAO().save(mod);
        } else {
            System.out.println("Sauvegarde impossible");
        }
    }
}
