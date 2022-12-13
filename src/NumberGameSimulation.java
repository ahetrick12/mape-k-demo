package src;

import src.mapek.*;
import src.subject.NumberGuesser;
import src.util.Bounds;

import java.util.*;

public class NumberGameSimulation {

    private static Bounds bounds = new Bounds(0, 10000);

    public static void main(String[] args) throws InterruptedException {
        int target = new Random().nextInt(bounds.getUpper());
        System.out.println("Target: " + target);
        System.out.println("==================================\n");

        Knowledge.getInstance().setTarget(target);

        NumberGuesser game = new NumberGuesser(bounds);
        
        Execute execute = new Execute(game);
        Plan plan = new Plan(execute);
        Analyze analyze = new Analyze(plan);
        Monitor monitor = new Monitor(analyze);
        game.register(monitor);

        game.run();
    }
}
