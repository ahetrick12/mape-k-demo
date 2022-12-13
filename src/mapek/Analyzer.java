package src.mapek;

import src.util.Logger;

/*
 * Analyzes data from Monitor component and decides whether the system needs to adapt or not - sends information to Planer
 */
public class Analyzer implements Component<Integer> {

    private Planner planner;

    private Knowledge knowledge = Knowledge.getInstance();
    private Logger logger = Logger.getInstance();

    public Analyzer(Planner plan) {
        this.planner = plan;
    }

    @Override
    public void execute(Integer guess) {   
        int target = knowledge.getTarget();
        boolean alterSystem = !(guess == target);

        logger.print("\t> ANALYZER: Guess has " + (alterSystem ? "NOT " : "") + "reached target of " + target);

        planner.execute(alterSystem);
    }
}
