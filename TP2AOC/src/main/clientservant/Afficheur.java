package main.clientservant;

import main.service.CapteurAsync;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

public interface Afficheur {

    public void update(CapteurAsync capteur);
    public LinkedList<Future> getValues();
}
