package mapek;

import util.Bounds;

public class Knowledge {
    private static Knowledge instance;

    private Bounds currentBounds = new Bounds(0, 10000);
    private int currentGuess = 0;
    private int targetValue = 0;

    public Knowledge(Bounds bounds, int guess, int target) {
        updateBounds(bounds.getLower(), bounds.getUpper());
        currentGuess = guess;
        targetValue = target;
    }

    public static synchronized Knowledge getInstance() {
        if (instance == null) {
            instance = new Knowledge(new Bounds(0, 10000), 0, 0);
        }
        return instance;
    }

    public void updateBounds(int lower, int upper) {
        currentBounds.setBounds(lower, upper);
    }

    public void updateGuess(int guess) {
        currentGuess = guess;
    }
}
