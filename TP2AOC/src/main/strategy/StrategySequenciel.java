package main.strategy;

import main.clientservant.CapteurImpl;
import main.service.ObserverDeCapteurAsync;

public class StrategySequenciel implements Strategy{


    boolean isReady = true;
    int getCount = 0;
    int returnValue;
    @Override
    public void executeTick() {

        System.out.println(this + " : executeTick");
        capteur.value++;
        if (isReady) {
            System.out.println(this + " : executeTick : in if");
            returnValue = capteur.value;
            getCount = 0;
            isReady = false;
            for (ObserverDeCapteurAsync obs : capteur.observerDeCapteurs) {
                obs.update(capteur);
            }
        }
    }
    CapteurImpl capteur;
    @Override
    public void configure(CapteurImpl capteur) {
        this.capteur = capteur;
    }

    @Override
    public int executeGetValue() {
        System.out.println(this + " : executeGetValue");
        getCount++;
        if (getCount >= capteur.observerDeCapteurs.size()) {
            isReady = true;
        }
        return returnValue;
    }
}
