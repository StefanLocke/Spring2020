package main.clientservant;

import main.service.ObserverDeCapteurAsync;

public interface Capteur {

    public void attach(ObserverDeCapteurAsync obs);
    public void detach(ObserverDeCapteurAsync obs);
    public int getValue();
    public void tick();
}
