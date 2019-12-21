package controlleur;

import modele.Modele;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerNewGame implements ActionListener {
    Modele mod;

    public ControllerNewGame(Modele mod){
        this.mod = mod;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        mod.newGame();
    }
}
