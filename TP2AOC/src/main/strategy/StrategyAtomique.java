package main.strategy;

import main.clientservant.Capteur;
import main.clientservant.CapteurImpl;
import main.service.ObserverDeCapteurAsync;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

public class StrategyAtomique implements Strategy {

    CapteurImpl capteur;

    public StrategyAtomique() {
    }

    @Override
    public void configure(CapteurImpl capteur) {
        this.capteur = capteur;
    }
    boolean isReady = true;


    @Override
    public void executeTick() {
        System.out.println(this + " : executeTick");

        if (isReady) {
            System.out.println(this + " : executeTick : in if");
            getCount = 0;
            isReady = false;
            capteur.value++;
            for (ObserverDeCapteurAsync obs : capteur.observerDeCapteurs) {
                obs.update(capteur);
            }
        }
    }


    int getCount = 0;
    @Override
    public int executeGetValue() {
        System.out.println(this + " : executeGetValue");
        getCount++;
        if (getCount >= capteur.observerDeCapteurs.size()) {
            isReady = true;
        }
        return capteur.value;
    }
}
