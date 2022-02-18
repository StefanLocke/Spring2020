package main;

import main.clientservant.Capteur;
import main.clientservant.CapteurImpl;
import main.proxy.Canal;
import main.clientservant.AfficheurImpl;
import main.clientservant.Afficheur;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {

    public static ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
    public static void main(String[] args) throws InterruptedException, ExecutionException {



        Capteur cap1 = new CapteurImpl();
        Afficheur observerDeCapteur = new AfficheurImpl();


        Canal canal1 = new Canal(observerDeCapteur,cap1);


        cap1.attach(canal1);
        cap1.tick();
        cap1.tick();
        cap1.tick();

        Thread.sleep(2000
        );
        cap1.tick();
        Thread.sleep(2000
        );
        cap1.tick();

        while (true) {
            ((AfficheurImpl)observerDeCapteur).show();
            Thread.sleep(1000);
        }

    }
}
