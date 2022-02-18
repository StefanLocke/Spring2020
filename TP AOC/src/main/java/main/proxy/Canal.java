package main.proxy;

import main.client.Capteur;
import main.methodInvocation.Update;
import main.servant.ObserverDeCapteur;
import main.service.ObserverDeCapteurAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Canal implements ObserverDeCapteurAsync {

    public Canal(ObserverDeCapteur obs,ExecutorService scheduler) {
        this.obs = obs;
        this.scheduler = scheduler;
    }

    private ExecutorService scheduler;

    private ObserverDeCapteur obs;
    @Override
    public Future update(Capteur capteur) {

        Update mi = new Update(obs,capteur);
        Future future = scheduler.submit(mi);

        return future;
    }
}
