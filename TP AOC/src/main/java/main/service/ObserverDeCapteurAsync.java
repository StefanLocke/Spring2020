package main.service;

import main.client.Capteur;
import main.servant.ObserverDeCapteur;

import java.util.concurrent.Future;

//SERVICE
public interface ObserverDeCapteurAsync {
    public Future update(Capteur capteur);
}
