package main.ui;

import main.clientservant.Capteur;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;


public class CapteurView extends JPanel {
    Capteur capteur;
    JButton tickButton;
    public CapteurView(Capteur capteur) {
        BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
        this.setLayout(layout);
            this.capteur = capteur;
        this.add(new JLabel("Capteur"));
        tickButton = new JButton("Tick");
        this.add(tickButton);


        tickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Executors.newSingleThreadExecutor().submit(capteur::tick);
            }
        });
        this.add(Box.createVerticalGlue());

    }
}
