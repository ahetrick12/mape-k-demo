package src;

import src.mapek.*;
import src.subject.NumberGuesser;
import src.util.Bounds;
import src.util.Logger;

import java.util.*;

/*
 * Simulates the number guessing game as well as the MAPE-K loop
 */
public class NumberGameSimulation {

    private static Bounds bounds = new Bounds(0, 10000);

    public static void main(String[] args) throws InterruptedException {
        Logger logger = Logger.getInstance();
        Knowledge knowledge = Knowledge.getInstance();
        
        // Set initial values
        int target = new Random().nextInt(bounds.getUpper());
        Knowledge.getInstance().setTarget(target);
        knowledge.updateBounds(bounds);

        logger.setActive(true); // Logger not initially set active so above calls to Knowledge don't print to console
        logger.print("\n==================================");
        logger.print("TARGET: " + target);
        logger.print("==================================");

        // Initialize the game as well as MAPE-K components
        NumberGuesser game = new NumberGuesser(bounds);
        
        Executer execute = new Executer(game);
        Planner plan = new Planner(execute);
        Analyzer analyze = new Analyzer(plan);
        Monitor monitor = new Monitor(analyze);
        game.register(monitor);

        // Run the game
        game.run();
    }
}
