package main.ui;

import main.Simulator;

import javax.swing.*;

public class launcher {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My First GUI");
        frame.setContentPane(new MainPanel(new Simulator()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}
