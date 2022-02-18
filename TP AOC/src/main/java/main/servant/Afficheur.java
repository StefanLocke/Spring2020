package main.servant;

import main.client.Capteur;

public class Afficheur implements ObserverDeCapteur{

    @Override
    public void update(Capteur capteur) {
        System.out.println("Updated obs : " + this + "with :" + capteur);
    }
}
