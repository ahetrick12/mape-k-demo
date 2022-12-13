package src.mapek;

import src.util.*;

/*
 * Represents the shared knowledge in the MAPE-K framework. Contains the current bounds, the current guess, and the target value.
 * Shared knowledge is represented as a singleton.
 */
public class Knowledge {
    private static Knowledge instance;

    private Bounds currentBounds = new Bounds(0, 0);
    private int currentGuess = 0;
    private int targetValue = 0;

    private Logger logger = Logger.getInstance();

    public Knowledge(Bounds bounds, int guess, int target) {
        updateBounds(bounds);
        currentGuess = guess;
        targetValue = target;
    }

    public static synchronized Knowledge getInstance() {
        if (instance == null) {
            instance = new Knowledge(new Bounds(0, 0), 0, 0);
        }
        return instance;
    }

    public Bounds getBounds() { return currentBounds; }

    public int getGuess() { return currentGuess; }

    public int getTarget() { return targetValue; }

    public void updateBounds(Bounds bounds) {
        logger.print("\t\t> KNOWLEDGE: Updating current bounds to " + bounds);
        currentBounds.setBounds(bounds.getLower(), bounds.getUpper());
    }

    public void updateGuess(int guess) {
        logger.print("\t\t> KNOWLEDGE: Updating current guess to " + guess);
        currentGuess = guess;
    }

    public void setTarget(int target) {
        logger.print("\t\t> KNOWLEDGE: Updating current target to " + target);
        targetValue = target;
    }
}
