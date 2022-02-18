package main.clientservant;

import main.service.CapteurAsync;

import java.util.LinkedList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AfficheurImpl implements Afficheur {

    private LinkedList<Future> values = new LinkedList<>();

    private String display = "";

    @Override
    public void update(CapteurAsync capteur) {
        System.out.println("Updating");
        values.addLast(capteur.getValue());
    }



    public LinkedList<Future> getValues() {
        return values;
    }

    public void show() throws ExecutionException, InterruptedException {

        for (Future f : values) {
            if (f.isDone()) display += " - " + f.get();
        }
        values.removeIf(future -> future.isDone());
        System.out.println(display);

    }
}
