package main.service;

import main.clientservant.Capteur;

import java.util.concurrent.Future;

//SERVICE
public interface ObserverDeCapteurAsync {
    public Future update(Capteur capteur);
}
