package main.servant;

import main.client.Capteur;

public interface ObserverDeCapteur {

    public void update(Capteur capteur);
}
