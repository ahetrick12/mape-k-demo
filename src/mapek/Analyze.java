package src.mapek;

import src.util.Bounds;

public class Analyze implements Component<Integer> {

    private Knowledge knowledge = Knowledge.getInstance();
    private Plan plan;

    public Analyze(Plan plan) {
        this.plan = plan;
    }

    @Override
    public void execute(Integer guess) {   
        int target = knowledge.getTarget();

        boolean alterModel = !(guess == target);
        plan.execute(alterModel);
    }
}
