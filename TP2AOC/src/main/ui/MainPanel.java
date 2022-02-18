package main.ui;

import main.Simulator;
import main.clientservant.Afficheur;

import javax.swing.*;

public class MainPanel extends JPanel {
    public MainPanel(Simulator sim) {
        BoxLayout layout = new BoxLayout(this,BoxLayout.X_AXIS);

        this.setLayout(layout);

        this.add(Box.createHorizontalGlue());
        this.add(new CapteurView(sim.getCapteur()));
        this.add(Box.createHorizontalGlue());
        for (Afficheur aff: sim.getAfficheur()) {
            this.add(new AfficheurView(aff));
            this.add(Box.createHorizontalGlue());
        }

    }
}
