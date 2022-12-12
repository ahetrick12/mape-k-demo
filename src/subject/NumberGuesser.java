package src.subject;
import java.util.*;

import src.mapek.Listener;
import src.util.*;

public class NumberGuesser implements Sensor {

    private List<Listener> listeningComponents = new ArrayList<Listener>();
    private Bounds bounds;

    public NumberGuesser(Bounds bounds) {
        this.bounds = bounds;
    }

    public void run() throws InterruptedException {
        Random rand = new Random();

        while (true)
        {
            int number = rand.nextInt(bounds.getUpper() - bounds.getLower()) + bounds.getLower();
            System.out.println("Bounds: " + bounds + "\nGuess: " + number);
            notify(number);

            Thread.sleep(1000);
        }
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    @Override
    public void register(Listener component) {
        listeningComponents.add(component);
    }

    @Override
    public void deregister(Listener component) {
        listeningComponents.remove(component);
    }

    @Override
    public void notify(int num) {
        for (Listener component: listeningComponents) {
            component.update(num);
        }
    }
}
