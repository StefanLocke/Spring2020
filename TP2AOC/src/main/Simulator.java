package main;

import main.clientservant.Afficheur;
import main.clientservant.AfficheurImpl;
import main.clientservant.Capteur;
import main.clientservant.CapteurImpl;
import main.proxy.Canal;
import main.ui.AfficheurView;

import java.util.LinkedList;
import java.util.List;

public class Simulator {

    private Capteur capteur;

    private List<Afficheur> afficheurs;

    public Simulator() {

        capteur = new CapteurImpl();

        afficheurs = new LinkedList<>();

        Afficheur a1 = new AfficheurImpl();
        Afficheur a2 = new AfficheurImpl();

        afficheurs.add(a1);
        afficheurs.add(a2);

        Canal canal = new Canal(a1,capteur);
        Canal canal2 = new Canal(a2,capteur);

        capteur.attach(canal);
        capteur.attach(canal2);
    }

    public List<Afficheur> getAfficheur() {
        return afficheurs;
    }

    public Capteur getCapteur() {
        return capteur;
    }
}
