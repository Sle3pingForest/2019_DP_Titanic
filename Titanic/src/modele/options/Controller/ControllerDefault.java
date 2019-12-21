package modele.options.Controller;

import modele.options.Options;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerDefault implements ActionListener {
    Options options;

    public ControllerDefault(Options options) {
         this.options = options;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        options.setDefault();
    }
}
