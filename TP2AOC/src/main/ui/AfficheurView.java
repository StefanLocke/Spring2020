package main.ui;

import main.clientservant.Afficheur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AfficheurView extends JPanel {

    Afficheur afficheur;
    JLabel display;
    public AfficheurView(Afficheur afficheur) {
        BoxLayout layout = new BoxLayout(this,BoxLayout.Y_AXIS);
        this.setLayout(layout);
        this.afficheur = afficheur;
        this.add(new JLabel("Afficheur"));
        display = new JLabel("display");
        this.add(display);
        this.add(Box.createVerticalGlue());

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() { // Moche
                while(true) {
                    try {
                        Thread.sleep(100);
                        refresh();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }

    public void refresh() throws ExecutionException, InterruptedException {
        String text = "";
        for (Future f :afficheur.getValues()) {
            if (f.isDone()) {
                text+= " - " + f.get();
            }else {
                text += " - waiting";
            }
        }
        display.setText(text);
    }
}
