package src.mapek;

import src.util.Bounds;

public class Planner implements Component<Boolean> {

    private Knowledge knowledge = Knowledge.getInstance();
    private Executer executer;

    public Planner(Executer execute) {
        this.executer = execute;
    }

    @Override
    public void execute(Boolean alterModel) {
        if (!alterModel) 
        {
            executer.execute(null);
            System.out.println("\t> PLANNER: We will plan to NOT alter the system and signify the end of the game");
            return;
        }
        
        int guess = knowledge.getGuess();
        int target = knowledge.getTarget();
        Bounds bounds = knowledge.getBounds();

        if (guess < target) {
            bounds.setLower(guess);
        } else {
            bounds.setUpper(guess);
        }

        System.out.println("\t> PLANNER: We will plan to alter system to have new bounds of " + bounds);

        executer.execute(bounds);
    } 
    
}
