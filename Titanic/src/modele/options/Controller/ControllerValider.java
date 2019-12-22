package modele.options.Controller;

import modele.options.Options;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerValider implements ActionListener{
    Options options;

    public ControllerValider(Options options) {
        this.options = options;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        options.setDisplayed(false);
    }
}
