package modele.options.Controller;

import modele.options.Options;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerStrategy implements ActionListener {

    private Options options;

    public ControllerStrategy(Options options) {
        this.options = options;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton button = (JRadioButton) e.getSource();
        String text = button.getActionCommand();
        options.setStrategy(text);
    }
}
