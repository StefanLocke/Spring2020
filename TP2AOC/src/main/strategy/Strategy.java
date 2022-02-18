package main.strategy;

import main.clientservant.Capteur;
import main.clientservant.CapteurImpl;
import main.service.ObserverDeCapteurAsync;

public interface Strategy {
    public void executeTick();
    public void configure(CapteurImpl capteur);
    public int executeGetValue();
}
