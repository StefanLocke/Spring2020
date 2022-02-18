package main.strategy;

import main.clientservant.CapteurImpl;
import main.service.ObserverDeCapteurAsync;

public class StrategyEpoque implements Strategy{

    CapteurImpl capteur;
    @Override
    public void executeTick() {
        capteur.value++;
        for (ObserverDeCapteurAsync obs : capteur.observerDeCapteurs) {
            obs.update(capteur);
        }
    }

    @Override
    public void configure(CapteurImpl capteur) {
        this.capteur = capteur;
    }

    @Override
    public int executeGetValue() {
        return capteur.value;
    }
}
