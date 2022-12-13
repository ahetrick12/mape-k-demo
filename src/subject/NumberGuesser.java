package src.subject;
import java.util.*;

import src.mapek.Listener;
import src.util.*;

public class NumberGuesser implements Sensor {

    private List<Listener> listeningComponents = new ArrayList<Listener>();
    private Bounds bounds;
    private boolean targetFound = false;

    public NumberGuesser(Bounds bounds) {
        this.bounds = bounds;
    }

    public void run() throws InterruptedException {
        Random rand = new Random();
        int number = 0;

        while (!targetFound)
        {
            number = rand.nextInt(bounds.getUpper() - bounds.getLower()) + bounds.getLower();
            System.out.println("Bounds: " + bounds + "\nGuess: " + number + "\n");
            notify(number);

            Thread.sleep(1000);
        }

        System.out.println("Target reached at " + number + "!");
    }

    public void setBounds(Bounds bounds) { this.bounds = bounds; }

    public void notifyEndGame() { targetFound = true; }

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
