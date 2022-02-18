package main;

import main.client.Capteur;
import main.client.CapteurImpl;
import main.proxy.Canal;
import main.servant.Afficheur;
import main.servant.ObserverDeCapteur;
import main.service.ObserverDeCapteurAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService scheduler = Executors.newSingleThreadExecutor();


        Capteur cap1 = new CapteurImpl();
        Capteur cap2 = new CapteurImpl();



        ObserverDeCapteur observerDeCapteur = new Afficheur();

        ObserverDeCapteurAsync canal = new Canal(observerDeCapteur,scheduler);


        cap1.attach(canal);
        cap2.attach(canal);

        cap1.tick();
        cap2.tick();

    }
}
