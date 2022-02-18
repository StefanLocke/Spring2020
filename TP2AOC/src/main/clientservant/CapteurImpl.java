package main.clientservant;

import main.service.ObserverDeCapteurAsync;
import main.strategy.Strategy;
import main.strategy.StrategyAtomique;
import main.strategy.StrategyEpoque;
import main.strategy.StrategySequenciel;

import java.util.LinkedList;

public class CapteurImpl implements Capteur {

    public LinkedList<ObserverDeCapteurAsync> observerDeCapteurs;
    public int value;
    private Strategy strategy;
    public boolean isReady;

    public CapteurImpl(){
        value = 0;
        observerDeCapteurs = new LinkedList<>();
        strategy = new StrategySequenciel();
        strategy.configure(this);
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
    public int getValue() {
        System.out.println("returning value " + value);
        return strategy.executeGetValue();
    }

    @Override
    public void tick() {
        System.out.println("Doing tick");
        strategy.executeTick();
    }

}
