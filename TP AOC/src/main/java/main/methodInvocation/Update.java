package main.methodInvocation;

import main.client.Capteur;
import main.client.CapteurImpl;
import main.servant.ObserverDeCapteur;

public class Update implements MethodInvocation{
    public Update(ObserverDeCapteur obs, Capteur arg) {
        this.obs = obs;
        this.capteur = arg;

    }

    ObserverDeCapteur obs;
    Capteur capteur;

    @Override
    public Object call() throws Exception {
        obs.update(capteur);
        return null;
    }
}
