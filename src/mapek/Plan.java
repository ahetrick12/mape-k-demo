package src.mapek;

import src.util.Bounds;

public class Plan implements Component<Boolean> {

    private Knowledge knowledge = Knowledge.getInstance();
    private Execute execute;

    public Plan(Execute execute) {
        this.execute = execute;
    }

    @Override
    public void execute(Boolean alterModel) {
        if (!alterModel) 
        {
            execute.execute(null);
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

        execute.execute(bounds);
    } 
    
}
