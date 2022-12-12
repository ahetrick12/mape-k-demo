package src.mapek;

import src.util.Bounds;

public class Knowledge {
    private static Knowledge instance;

    private Bounds currentBounds = new Bounds(0, 10000);
    private int currentGuess = 0;
    private int targetValue = 0;

    public Knowledge(Bounds bounds, int guess, int target) {
        updateBounds(bounds);
        currentGuess = guess;
        targetValue = target;
    }

    public static synchronized Knowledge getInstance() {
        if (instance == null) {
            instance = new Knowledge(new Bounds(0, 10000), 0, 0);
        }
        return instance;
    }

    public Bounds getBounds() { return currentBounds; }

    public int getGuess() { return currentGuess; }

    public int getTarget() { return targetValue; }

    public void updateBounds(Bounds bounds) {
        currentBounds.setBounds(bounds.getLower(), bounds.getUpper());
    }

    public void updateGuess(int guess) {
        currentGuess = guess;
    }

    public void setTarget(int target) {
        targetValue = target;
    }
}
