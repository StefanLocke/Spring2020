package main.proxy;

import main.Main;
import main.clientservant.Capteur;
import main.clientservant.Afficheur;
import main.service.CapteurAsync;
import main.service.ObserverDeCapteurAsync;

import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Canal implements ObserverDeCapteurAsync, CapteurAsync {

    public Canal(Afficheur obs, Capteur cap) {
        this.obs = obs;
        this.cap = cap;
        this.service = Main.service;
    }

    private ScheduledExecutorService service;
    private Afficheur obs;
    private Capteur cap;

    @Override
    public Future getValue() {

        return service.schedule(
                () -> cap.getValue(),
                new Random().nextInt(1000),
                TimeUnit.MILLISECONDS);
    }

    @Override
    public Future update(Capteur capteur) {
        return service.schedule(
                () -> obs.update(this),
                new Random().nextInt(1000),
                TimeUnit.MILLISECONDS);
    }
}
