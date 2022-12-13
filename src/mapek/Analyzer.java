package src.mapek;

import src.util.Bounds;

public class Analyzer implements Component<Integer> {

    private Knowledge knowledge = Knowledge.getInstance();
    private Planner planner;

    public Analyzer(Planner plan) {
        this.planner = plan;
    }

    @Override
    public void execute(Integer guess) {   
        int target = knowledge.getTarget();
        boolean alterModel = !(guess == target);

        System.out.println("\t> ANALYZER: Guess has " + (alterModel ? "NOT" : "") + " reached target");

        planner.execute(alterModel);
    }
}
