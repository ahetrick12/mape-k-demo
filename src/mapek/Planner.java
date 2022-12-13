package src.mapek;

import src.util.Bounds;
import src.util.Logger;

/*
 * Detemines the next action to be taken to achieve system adaptation goals, i.e. adjust the guessing bounds
 */
public class Planner implements Component<Boolean> {

    private Executer executer;

    private Knowledge knowledge = Knowledge.getInstance();
    private Logger logger = Logger.getInstance();
    

    public Planner(Executer execute) {
        this.executer = execute;
    }

    @Override
    public void execute(Boolean alterSystem) {
        if (!alterSystem) 
        {
            // If system doesn't need to be altered, do nothing
            executer.execute(null);
            logger.print("\t> PLANNER: We will plan to NOT alter the system and signify the end of the game");
            return;
        }
        
        int guess = knowledge.getGuess();
        int target = knowledge.getTarget();
        Bounds bounds = knowledge.getBounds();

        if (guess < target) {
            bounds.setLower(guess + 1);
        } else {
            bounds.setUpper(guess - 1);
        }

        logger.print("\t> PLANNER: We will plan to alter system to have new bounds of " + bounds);

        executer.execute(bounds);
    } 
    
}
