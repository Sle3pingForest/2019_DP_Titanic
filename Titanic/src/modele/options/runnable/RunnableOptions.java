package modele.options.runnable;

import modele.options.Options;
import modele.options.view.VueOptions;

import javax.swing.*;

public class RunnableOptions implements Runnable {
    private Options options;

    public RunnableOptions(Options options){
        this.options = options;
    }

    private void frameOptions(){
        JFrame frame = new JFrame("Options");
        frame.add(new VueOptions(options));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400,400);
    }

    @Override
    public void run() {
        frameOptions();
    }
}
