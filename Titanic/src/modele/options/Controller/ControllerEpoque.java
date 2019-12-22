package modele.options.Controller;

import modele.options.Options;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerEpoque implements ActionListener{
    private Options options;

    public ControllerEpoque(Options options){
        this.options = options;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton button = (JRadioButton) e.getSource();
        String text = button.getActionCommand();
        options.setEpoque(text);
    }
}
