package main.client;

import main.servant.ObserverDeCapteur;
import main.service.ObserverDeCapteurAsync;

public interface Capteur {

    public void attach(ObserverDeCapteurAsync obs);
    public void detach(ObserverDeCapteurAsync obs);
    public void tick();
}
