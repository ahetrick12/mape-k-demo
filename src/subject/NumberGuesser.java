package src.subject;
import java.util.*;

import src.mapek.Listener;
import src.util.*;

/*
 * A number guesser that tries to guess a number in a given range
 */
public class NumberGuesser implements Sensor {

    private List<Listener> listeningComponents = new ArrayList<Listener>();
    private Bounds bounds;
    private boolean targetFound = false;

    private Logger logger = Logger.getInstance();

    public NumberGuesser(Bounds bounds) {
        this.bounds = bounds;
    }

    public void run() throws InterruptedException {
        Random rand = new Random();
        int guess = 0;

        while (!targetFound)
        {
            // Wait for a bit
            Thread.sleep(1500);

            // Guess the number and notify listeners
            int range = bounds.getUpper() - bounds.getLower();

            if (range > 0)
                guess = rand.nextInt(range) + bounds.getLower();
            else
                guess = bounds.getLower();

            logger.print("\nGAME: Guessing a number in " + bounds + "...");
            logger.print("GUESS: " + guess + "\n");

            notify(guess);            
        }

        // Target found
        logger.print("\n==================================");
        logger.print("Target reached at " + guess + "!");
        logger.print("==================================\n");
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
    public void notify(int num)  {
        try {
            // Wait a bit for MAPE-K loop to run/display, just for visual purposes
            Thread.sleep(500);

            for (Listener component: listeningComponents) {
                component.update(num);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
