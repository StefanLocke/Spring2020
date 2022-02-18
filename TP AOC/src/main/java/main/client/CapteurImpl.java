package main.client;

import main.servant.ObserverDeCapteur;
import main.service.ObserverDeCapteurAsync;

import java.util.LinkedList;

public class CapteurImpl implements Capteur {

    LinkedList<ObserverDeCapteurAsync> observerDeCapteurs;

    public CapteurImpl(){
        observerDeCapteurs = new LinkedList<>();
    }

    @Override
    public void attach(ObserverDeCapteurAsync obs) {
        observerDeCapteurs.add(obs);
    }

    @Override
    public void detach(ObserverDeCapteurAsync obs) {
        observerDeCapteurs.remove(obs);
    }

    @Override
    public void tick() {
        System.out.println("Capteur " + this + " a change !");
        notifyChange();
    }

    private void notifyChange(){
        for (ObserverDeCapteurAsync obs : observerDeCapteurs) {
            obs.update(this);
        }
    }
}
