package src;

import src.mapek.*;
import src.subject.NumberGuesser;
import src.util.Bounds;

import java.util.*;

public class NumberGameSimulation {

    private static Bounds bounds = new Bounds(0, 10000);

    public static void main(String[] args) throws InterruptedException {
        int target = new Random().nextInt(bounds.getUpper());
        Knowledge.getInstance().setTarget(target);

        System.out.println("\n==================================");
        System.out.println("TARGET: " + target);
        System.out.println("==================================");

        
        NumberGuesser game = new NumberGuesser(bounds);
        
        Executer execute = new Executer(game);
        Planner plan = new Planner(execute);
        Analyzer analyze = new Analyzer(plan);
        Monitor monitor = new Monitor(analyze);
        game.register(monitor);

        game.run();
    }
}
